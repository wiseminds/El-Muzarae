package com.wadektech.el_muzarae.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.ui.FarmerUploadActivity;
import com.wadektech.el_muzarae.ui.MainActivity;

public class FarmerRegistrationFormActivity extends AppCompatActivity {
    EditText fFullNames, fPhoneNumber, fRegion, fState, fCounty, fFarmerPass, fConfirmPass ;
    Button btnRegisterFarmer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_registration_form);
        
        fFullNames = findViewById(R.id.et_full_names);
        fPhoneNumber = findViewById(R.id.et_phone_number);
        fRegion = findViewById(R.id.et_region);
        fState = findViewById(R.id.et_state);
        fCounty = findViewById(R.id.et_county);
        fFarmerPass = findViewById(R.id.et_farmer_password);
        fConfirmPass = findViewById(R.id.et_confirm_farmer_password);
        btnRegisterFarmer = findViewById(R.id.btn_farmer_register);
        
        btnRegisterFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fFullNames.getText().toString().trim() ;
                String phone = fPhoneNumber.getText().toString().trim() ;
                String region = fRegion.getText().toString().trim() ;
                String state = fState.getText().toString().trim() ;
                String county = fCounty.getText().toString().trim() ;
                String password = fFarmerPass.getText().toString().trim() ;
                String passConfirm = fConfirmPass.getText().toString().trim() ;
                
                if (TextUtils.isEmpty(name)){
                    fFullNames.setError("Field cannot be blank!");
                } else if (TextUtils.isEmpty(phone)) {
                    fPhoneNumber.setError("Field cannot be blank!");
                }else if (TextUtils.isEmpty(region)) {
                    fRegion.setError("Field cannot be blank!");
                }else if (TextUtils.isEmpty(state)) {
                    fState.setError("Field cannot be blank!");
                } else if (TextUtils.isEmpty(county)){
                    fCounty.setError("Field cannot be blank!");
                } else if (!password.matches(passConfirm)) {
                    fConfirmPass.setError("Passwords do not match!");
                } else {
                    registerFarmer(name , password);
                }
            }
        });
    }

    private void registerFarmer(String name, String password) {
        //temporary bypass activity for test flow
        if (password.contains("farmer")){
            Intent intent = new Intent(getApplicationContext(), FarmerUploadActivity.class) ;
            finish();
            startActivity(intent);
        }
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
        }, 0);
    }
}
