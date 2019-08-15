package com.wadektech.el_muzarae.ui;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import com.wadektech.el_muzarae.auth.FarmerRegistrationFormActivity;
import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.adapter.ProductsAdapter;
import com.wadektech.el_muzarae.auth.SignUpActivity;
import com.wadektech.el_muzarae.pojos.Products;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , ProductsAdapter.OnItemListener {
    RecyclerView mRecycler ;
    ProductsAdapter productsAdapter ;
    LinearLayoutManager linearLayoutManager ;
    List<Products> productsList ;
    ImageView mAdminDashBoard ;
    Products products ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Orders functionality coming soon :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mAdminDashBoard = findViewById(R.id.admin_dashboard);
        mRecycler = findViewById(R.id.products_recycler);
        linearLayoutManager = new LinearLayoutManager(this) ;
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(linearLayoutManager);

        mAdminDashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FarmerRegistrationFormActivity.class);
                finish();
                startActivity(intent);
            }
        });

        productsList = getAllProductsFromDB() ;

        productsAdapter = new ProductsAdapter(productsList, this, this) ;
        mRecycler.setAdapter(productsAdapter);
    }

    private List<Products> getAllProductsFromDB() {
        List<Products> products = new ArrayList<>();
        products.add(new Products(R.drawable.tomatoes, "Tomatoes", 40.0));
        products.add(new Products(R.drawable.onionsjpg, "Onions", 100.0));
        products.add(new Products(R.drawable.driedmaize, "Dried Maize", 43.0));
        products.add(new Products(R.drawable.whiterice, "Dried Rice", 60.0));
        products.add(new Products(R.drawable.watermelonjpg, "Water melons", 58.0));
        products.add(new Products(R.drawable.farmers, "Guavas", 46.0));
        products.add(new Products(R.drawable.sukumawiki, "Sukuma Wiki", 430.0));

        return products ;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 0);
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_market) {

        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_bookmarks) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClicked(int position) {
        Products products = productsList.get(position);
        Intent intent = new Intent(getApplicationContext(), FarmProductDetailActivity.class);
        intent.putExtra("products" , products);
        startActivity(intent);
    }
}
