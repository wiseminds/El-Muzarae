package com.wadektech.el_muzarae.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.pojos.ProductDetails;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ProductDetailsViewHolders> {
    List<ProductDetails> productDetailsList ;
    Context context ;

    public ProductDetailsAdapter(List<ProductDetails> productDetailsList, Context context) {
        this.productDetailsList = productDetailsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductDetailsViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farm_product_details_list, parent, false);
        return new ProductDetailsAdapter.ProductDetailsViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailsViewHolders holder, int position) {
        ProductDetails productDetails = productDetailsList.get(position);
        holder.profileImage.setImageResource(productDetails.getProfileImage());
        holder.productImage.setImageResource(productDetails.getProductImage());
        holder.pName.setText(productDetails.getNameOfProduct());
        holder.pPrice.setText(String.valueOf(productDetails.getSellingPrice()));
        holder.farmerName.setText(productDetails.getNameOfFarmer());
        holder.farmerNumber.setText(productDetails.getFarmerPhoneNumber());
        holder.pQuantity.setText(String.valueOf(productDetails.getProductQuantity()));
        holder.farmerCounty.setText(productDetails.getFarmerCounty());
        holder.farmerState.setText(productDetails.getFarmerState());
        holder.pDescription.setText(productDetails.getProductDescription());
        holder.btnCallOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Order placed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productDetailsList.size();
    }

    public class ProductDetailsViewHolders extends RecyclerView.ViewHolder {
        ImageView productImage ;
        CircleImageView profileImage ;
        TextView pName,pPrice, farmerName , farmerNumber, pQuantity, farmerCounty, farmerState, pDescription ;
        Button btnCallOrder ;
        public ProductDetailsViewHolders(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            profileImage = itemView.findViewById(R.id.profile_image);
            pName = itemView.findViewById(R.id.tv_product_name);
            pPrice = itemView.findViewById(R.id.tv_product_price);
            farmerName = itemView.findViewById(R.id.tv_farmer_name);
            farmerNumber = itemView.findViewById(R.id.tv_farmer_number);
            pQuantity = itemView.findViewById(R.id.tv_product_qty);
            farmerCounty = itemView.findViewById(R.id.tv_farm_county);
            farmerState = itemView.findViewById(R.id.tv_farmer_state);
            pDescription = itemView.findViewById(R.id.tv_product_desc);
            btnCallOrder = itemView.findViewById(R.id.btn_call_to_order);

        }
    }
}
