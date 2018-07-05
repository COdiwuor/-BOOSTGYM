package com.example.android.boostgym;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.boostgym.Helper.LocaleHelper;

import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private ProgressBar ProgressBarLogin;

    Button btnLoginLogin, btnCreateLogin;
    EditText txtUserLogin, txtPassword;

    private static String LOGIN_URL;

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginLogin = (Button) findViewById(R.id.btnLoginLogin);
        btnCreateLogin = (Button) findViewById(R.id.btnRegisterLogin);
        txtUserLogin = findViewById(R.id.txtUsernameLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);


        ProgressBarLogin = findViewById(R.id.LoginProgressBar);


        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        btnCreateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Create Account", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    private void validate() {
        String User_name, Pass_word;
        User_name = txtUserLogin.getText().toString().trim();
        Pass_word = txtPassword.getText().toString().trim();
        if (User_name.isEmpty()) {
            txtUserLogin.setError("Username is required");
        } else if (Pass_word.isEmpty()) {
            txtPassword.setError("Password is required");
        } else {
               LOGIN_URL="https://boost-gym.herokuapp.com/api/Login/"+User_name+"/"+Pass_word;
               ProgressBarLogin.setVisibility(View.VISIBLE);
            login();
        }
    }


    private void login() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ProgressBarLogin.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Logging in", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ProgressBarLogin.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
                    }

                }) {
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
