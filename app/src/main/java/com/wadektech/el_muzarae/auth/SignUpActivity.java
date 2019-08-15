package com.wadektech.el_muzarae.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wadektech.el_muzarae.R;
import com.wadektech.el_muzarae.ui.MainActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText mUsername, mPassword ;
    Button mLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUsername = findViewById(R.id.et_username);
        mPassword = findViewById(R.id.et_password) ;
        mLogin = findViewById(R.id.btn_login) ;

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString().trim() ;
                String password = mPassword.getText().toString().trim() ;

                //check for blank fields

                if (TextUtils.isEmpty(username)){
                    mUsername.setError("Fields cannot be blank!");
                } else if (TextUtils.isEmpty(password) && password.length() >= 8) {
                    mPassword.setError("Password cannot be less than 8 characters");
                } else {
                    login(username, password) ;
                }
            }
        });
    }

    private void login(String username , String password) {
        //creating a temporary login credential for demo purposes
        if (username.contains("admin") && password.contains("12345678")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong password or username!", Toast.LENGTH_SHORT).show();
        }
    }
}
