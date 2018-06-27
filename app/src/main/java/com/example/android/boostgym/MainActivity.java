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
    EditText txtUserLogin, txtPasswordLogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginLogin = (Button) findViewById(R.id.btnLoginLogin);
        btnCreateLogin = (Button) findViewById(R.id.btnRegisterLogin);






        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Logging in", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
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






}
