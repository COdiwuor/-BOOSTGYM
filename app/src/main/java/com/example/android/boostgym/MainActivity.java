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
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.boostgym.Helper.LocaleHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    Button btnLoginLogin, btnCreateLogin;
    EditText txtUserLogin, txtPassword;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginLogin = (Button) findViewById(R.id.btnLoginLogin);
        btnCreateLogin = (Button) findViewById(R.id.btnRegisterLogin);
        txtUserLogin=findViewById(R.id.txtUsernameLogin);
        txtPassword=findViewById(R.id.txtPasswordLogin);

        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validate();
                    }
                });
         btnCreateLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this,"Create Account",Toast.LENGTH_LONG).show();
                 startActivity(new Intent(MainActivity.this,RegisterActivity.class));
             }
         });
    }

    private void validate() {
       String User_name ,Pass_word;
       User_name = txtUserLogin.getText().toString().trim();
       Pass_word = txtPassword.getText().toString().trim();
       if(User_name.isEmpty()){
           txtUserLogin.setError("Username is required");
       }
       else if(Pass_word.isEmpty()){
           txtPassword.setError("Password is required");
        }else{
          login();
       }
    }

    private void login() {
        Toast.makeText(MainActivity.this, "Logging in", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }


}
