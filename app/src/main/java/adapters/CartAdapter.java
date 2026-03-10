package com.group4.groceryup_clean.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.group4.groceryup_clean.R;
import com.group4.groceryup_clean.models.OrderItem;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<OrderItem> cartList;

    public CartAdapter(List<OrderItem> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This connects your 'item_cart.xml' to the list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // This puts the actual data into the text fields
        OrderItem item = cartList.get(position);
        holder.tvName.setText(item.getProductName());
        holder.tvPrice.setText("KSh " + String.valueOf(item.getPrice()));
        holder.tvQuantity.setText("x" + item.getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    // This "Holder" finds the IDs inside your item_cart.xml
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvQuantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvPrice = itemView.findViewById(R.id.tvItemPrice);
            tvQuantity = itemView.findViewById(R.id.tvItemQuantity);
        }
    }
}