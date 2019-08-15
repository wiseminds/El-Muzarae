package com.wadektech.el_muzarae.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.adapter.ProductDetailsAdapter;
import com.wadektech.el_muzarae.pojos.ProductDetails;

import java.util.ArrayList;
import java.util.List;

public class FarmProductDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    LinearLayoutManager linearLayoutManager ;
    ProductDetailsAdapter productDetailsAdapter ;
    List<ProductDetails> productDetailsList ;
    ImageButton mBackNavigation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_product_detail);

        recyclerView = findViewById(R.id.product_detail_recycler);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        productDetailsList = getProductDetailsFromDB();

        productDetailsAdapter = new ProductDetailsAdapter(productDetailsList, this);
        recyclerView.setAdapter(productDetailsAdapter);

        mBackNavigation = findViewById(R.id.product_back);
        mBackNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private List<ProductDetails> getProductDetailsFromDB() {
        List<ProductDetails> details = new ArrayList<>();
        details.add(new ProductDetails(R.drawable.profile, R.drawable.tomatoes, 18, "Red Tomatoes", "John Garang","Jubek", "Juba",120,"Red juicy clean organic tomatoes, come see for yourself and get the best deal of your life!", "+211 920 123 456"));
        details.add(new ProductDetails(R.drawable.profile, R.drawable.onionsjpg, 11, "African Onion", "Derrick Wadek","Jonglei", "Hai Amarat",2500,"African organic onions, come see for yourself and get the best deal of your life!", "+211 920 123 456"));
        details.add(new ProductDetails(R.drawable.profile, R.drawable.sukumawiki, 6, "Sukuma Wiki", "Kenyi Kenyi","Lakes", "Tomping",68,"Green fresh juicy clean inorganic sukuma wiki, come see for yourself and get the best deal of your life!", "+211 920 123 456"));
        details.add(new ProductDetails(R.drawable.profile, R.drawable.watermelonjpg, 35, "Watermelons", "Elliot Alok","Upper Nile", "KonyoKonyo",54,"Big juicy clean organic watermelons, come see for yourself and get the best deal of your life!", "+211 920 123 456"));
        details.add(new ProductDetails(R.drawable.profile, R.drawable.whiterice, 50, "White Rice", "Sharon Onzia","Unity", "Gedi",459,"Dried white clean organic rice, come see for yourself and get the best deal of your life!", "+211 920 123 456"));
        details.add(new ProductDetails(R.drawable.profile, R.drawable.driedmaize, 32, "Dried Maize", "Timothy Kinyanjui","Warap", "Malakal",236,"Traditionally dried african white maize, come see for yourself and get the best deal of your life!", "+211 920 123 456"));

        return details ;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        },0);
    }
}
