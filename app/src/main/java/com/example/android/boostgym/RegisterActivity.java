package com.example.android.boostgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtfirstnamereg;
    private EditText txtlastnamereg;

    Button RegAccount, Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegAccount = (Button) findViewById(R.id.btnCreateaccountLogin);
        Login = (Button)findViewById(R.id.btnLoginAccount);

        txtfirstnamereg = (EditText)findViewById(R.id.txtfirstname);
        txtlastnamereg = (EditText)findViewById(R.id.lastnameregistration);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });
    }
}
