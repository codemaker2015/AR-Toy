package com.tcs.artoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername = null, edtPassword = null;
    Button btnLogin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(loginListener());

    }

    private View.OnClickListener loginListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = null, password = null;
                try {
                    username = edtUsername.getText().toString();
                    password = edtPassword.getText().toString();
                    if(username.equals("") || password.equals(""))
                        Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    else if(username.equals("admin") && password.equals("admin"))
                        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                    else
                        Toast.makeText(LoginActivity.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
                }catch(Exception e) {
                    Log.e("login_activity_error", "Exception occurs" + e.toString());
                    Toast.makeText(LoginActivity.this, "Exception occurs, please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}