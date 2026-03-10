package com.group4.groceryup_clean.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group4.groceryup_clean.R;
import com.group4.groceryup_clean.models.Order;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        RecyclerView rv = findViewById(R.id.rvOrderHistory);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // Get your specific ID from Team 2's Auth system
        String myId = FirebaseAuth.getInstance().getUid();

        // The Cloud Connection
        FirebaseFirestore.getInstance().collection("orders")
                .whereEqualTo("userId", myId) // Only show MY receipts
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<Order> historyList = queryDocumentSnapshots.toObjects(Order.class);
                    // You can use the same CartAdapter here to show the list!
                });
    }
}