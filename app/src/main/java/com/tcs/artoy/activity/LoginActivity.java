package com.tcs.artoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tcs.artoy.R;
import com.tcs.artoy.model.User;
import com.tcs.artoy.network.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername = null, edtPassword = null;
    Button btnLogin = null;
    ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress_bar);

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
                    else
                        authenticateUser(username, password);

                }catch(Exception e) {
                    Log.e("login_activity_error", "Exception occurs" + e.toString());
                    Toast.makeText(LoginActivity.this, "Exception occurs, please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    public void authenticateUser(String username, String password) {
        progressBar.setVisibility(View.VISIBLE);
        GetDataService service = com.example.demo.retrofitdemo.network.RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<com.tcs.artoy.model.Response> call = service.validateUser(new User(username, "", password));
        call.enqueue(new Callback<com.tcs.artoy.model.Response>() {

            @Override
            public void onResponse(Call<com.tcs.artoy.model.Response> call, Response<com.tcs.artoy.model.Response> response) {
                com.tcs.artoy.model.Response response1 = response.body();
                progressBar.setVisibility(View.GONE);
                if(response1.isSuccess() && response1.isValid()) {
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                }else
                    Toast.makeText(LoginActivity.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<com.tcs.artoy.model.Response> call, Throwable t) {
                Log.d("artoy", t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}