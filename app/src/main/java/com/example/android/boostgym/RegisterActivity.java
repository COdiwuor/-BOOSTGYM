package com.example.android.boostgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

public class RegisterActivity extends AppCompatActivity {



    private EditText txtusername;
    private EditText txtpassword;
    private EditText txtretypepassword;
    private EditText txtemail;
    private EditText txtphonenumber;



    Button btnContinue, Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnContinue = (Button) findViewById(R.id.btnCreateaccountLogin);

        txtusername = (EditText) findViewById(R.id.txtname);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        txtretypepassword = (EditText) findViewById(R.id.txtretypepassword);
        txtemail = (EditText) findViewById(R.id.email);
        txtphonenumber = (EditText) findViewById(R.id.phonenumber);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });







        Paper.init(this);
        EditText txtusername,txtemail,txtpassword,txtretypepassword,txtphonenumber;


        txtusername = findViewById(R.id.txtname);
        txtemail = findViewById(R.id.email);
        txtpassword = findViewById(R.id.txtpassword);
        txtretypepassword = findViewById(R.id.txtretypepassword);
        txtphonenumber = findViewById(R.id.phonenumber);

        String name =  txtusername.getText().toString();
        String email  = txtemail.getText().toString();
        String passsword = txtpassword.getText().toString();
        String retypepassword = txtretypepassword.getText().toString();
        String phonenumber =txtphonenumber.getText().toString();

        Paper.book().write("txtusername",name);
        Paper.book().write("txtemail",email);
        Paper.book().write("txtpassword",passsword);
        Paper.book().write("txtretypepassword",retypepassword)  ;
        Paper.book().write("txtphonenumber",phonenumber);

    }

    private void validate() {
        String username, email, password, retypepassword,phonenumber;
        username = txtusername.getText().toString().trim();
        email = txtemail.getText().toString().trim();
        password = txtpassword.getText().toString().trim();
        retypepassword = txtretypepassword.getText().toString().trim();
        phonenumber = txtphonenumber.getText().toString().trim();


        if (username.isEmpty()){
            txtusername.setError("Username is required");
        }else if (email.isEmpty()){
            txtemail.setError("Email is required");
        }else if(password.isEmpty()){
            txtpassword.setError("Password is required");
        }else if(retypepassword.isEmpty()){
            txtretypepassword.setError("Retype-password");
        }else if(phonenumber.isEmpty()){
            txtphonenumber.setError("Phone number is required");
        }else
            Continue();

    }

    private void Continue(){
        startActivity(new Intent(RegisterActivity.this,AccountCreationActivity.class));

    }


}
