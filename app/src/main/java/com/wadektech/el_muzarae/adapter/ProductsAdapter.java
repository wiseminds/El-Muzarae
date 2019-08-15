package com.wadektech.el_muzarae.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.pojos.Products;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {
    List<Products> productsList ;
    Context context ;
    private OnItemListener onItemListener ;

    public ProductsAdapter(List<Products> productsList, Context context, OnItemListener onItemListener) {
        this.productsList = productsList;
        this.context = context;
        this.onItemListener = onItemListener ;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content_details, parent, false);
        return new ProductsAdapter.ProductsViewHolder(view , onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Products products = productsList.get(position) ;
        holder.productPrice.setText(String.valueOf(products.getProductPrice()));
        holder.productName.setText(products.getProductName());
        holder.productImage.setImageResource(products.getProductImage());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView productImage ;
        private TextView  productName , productPrice ;
        public OnItemListener onItemListener ;
        public ProductsViewHolder(@NonNull View itemView, final OnItemListener onItemListener) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.tv_product_name);
            productPrice = itemView.findViewById(R.id.tv_product_price);
            this.onItemListener = onItemListener ;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemListener != null){
                        int position = getAdapterPosition() ;
                        if (position != RecyclerView.NO_POSITION){
                            onItemListener.onItemClicked(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            onItemListener.onItemClicked(getAdapterPosition());
        }
    }
    public interface OnItemListener{
        void onItemClicked(int position);
    }
}
