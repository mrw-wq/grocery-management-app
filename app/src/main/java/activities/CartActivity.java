// Import these at the top of the file first!
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group4.groceryup_clean.models.Order;
import android.widget.Toast;
import android.util.Log;

private void saveOrderToFirebase() {
    // 1. Get the connection to the Database
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // 2. Get the current User's ID (From Team 2's Auth)
    String currentUserId = FirebaseAuth.getInstance().getUid();

    if (currentUserId == null) {
        Toast.makeText(this, "Please login first!", Toast.LENGTH_SHORT).show();
        return;
    }

    // 3. Create the Order Object (Using Team 1's Model)
    Order finalOrder = new Order();
    finalOrder.setUserId(currentUserId);
    finalOrder.setItems(CartManager.getInstance().getCartItems());
    finalOrder.setTotalAmount(CartManager.getInstance().getTotalPrice());
    finalOrder.setOrderStatus("Pending");
    finalOrder.setOrderDate(System.currentTimeMillis());

    // 4. Send it to the Cloud!
    db.collection("orders")
            .add(finalOrder)
            .addOnSuccessListener(documentReference -> {
                // SUCCESS!
                Toast.makeText(this, "Order # " + documentReference.getId() + " placed!", Toast.LENGTH_LONG).show();

                // Clear the local cart so they can shop again
                CartManager.getInstance().getCartItems().clear();
                adapter.notifyDataSetChanged();
                tvTotal.setText("KSh 0.00");
            })
            .addOnFailureListener(e -> {
                // ERROR
                Log.e("FIREBASE_ERROR", "Order failed: " + e.getMessage());
                Toast.makeText(this, "Failed to place order. Try again.", Toast.LENGTH_SHORT).show();
            });
}