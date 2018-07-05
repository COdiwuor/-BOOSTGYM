package com.example.android.boostgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.ParameterMetaData;
import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

public class AccountCreationActivity extends AppCompatActivity {

    private RadioButton Radiobutton1;
    private RadioButton Radiobutton2;
    private EditText Height;
    private EditText Weight;
    private EditText date_of_birth;
    private EditText Preferred_workout;
    private ProgressBar ProgressBarreading;


    Button btncreateAccount;

    private static final String REGISTER_URL ="https://boost-gym.herokuapp.com/api/register";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENUMBER = "phone_number";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_DATE_OF_BIRTH ="date_of_birth";
    public static final String KEY_PREFERRED_WORKUT = "preferred_workout";




    String txtusername,txtemail,txtpassword,txtretypepassword,txtphonenumber,Gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);


        txtusername = Paper.book().read("txtusername").toString();
        txtemail = Paper.book().read("txtemail").toString();
        txtpassword = Paper.book().read("txtpassword").toString();
        txtretypepassword = Paper.book().read("txtretypepassword").toString();
        txtphonenumber= Paper.book().read("txtphonenumber").toString();

        Radiobutton1 = findViewById(R.id.RadioButton1);
        Radiobutton2 = findViewById(R.id.RadioButton2);
        Height = findViewById(R.id.Height);
        Weight = findViewById(R.id.Weight);
        date_of_birth= findViewById(R.id.DateofBirth);
        Preferred_workout =findViewById(R.id.Prefferedworkout);

        ProgressBarreading = findViewById(R.id.RegisterProgressBar);


        btncreateAccount = findViewById(R.id.save);
        btncreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   validate();
            }

            } );


                Radiobutton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Gender();
                    }
                });
        Radiobutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender();
            }
        });






    }

    private void validate() {
        String  height, weight, Date_of_birth, preffered_workout;
        height =  Height.getText().toString().trim();
        weight = Weight.getText().toString().trim();
        Date_of_birth = date_of_birth. getText().toString().trim();
        preffered_workout = Preferred_workout.getText().toString().trim();

        if (height.isEmpty()){
            Height.setError("Height is required");
        }else if (weight.isEmpty()){
            Weight.setError("Weight is required");
        }else if(Date_of_birth.isEmpty()){
            date_of_birth.setError("Date of birth is required");
        }else if(preffered_workout.isEmpty()){
            Preferred_workout.setError("Preffered workout is required");
        }else{
            ProgressBarreading.setVisibility(View.VISIBLE);
                  registerUser();
        }


    }

    private void Gender() {
        if(Radiobutton1.isChecked()){
            Gender="Male";
        }else if(Radiobutton2.isChecked()){
            Gender="Female";
        }else{
            Gender="";
        }
        Toast.makeText(getApplicationContext(),Gender,Toast.LENGTH_LONG).show();
    }



    private void registerUser (){
        final String username = txtusername;
        final String email = txtemail;
        final String password = txtpassword;
        final String phonenumber = txtphonenumber;
        final String gender = Gender;
        final String fetch_height = Height.getText().toString();
        final String fetch_weight = Weight.getText().toString();
        final String fetch_date_of_birth= date_of_birth. getText().toString();
        final String fetch_preferred_workout =Preferred_workout.getText().toString();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ProgressBarreading.setVisibility(View.GONE);
                        Toast.makeText(AccountCreationActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(AccountCreationActivity.this,HomeActivity.class));

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ProgressBarreading.setVisibility(View.GONE);
                        Toast.makeText(AccountCreationActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_EMAIL,email);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_PHONENUMBER,phonenumber);
                params.put(KEY_GENDER ,gender);
                params.put(KEY_HEIGHT , fetch_height);
                params.put(KEY_WEIGHT,fetch_weight);
                params.put(KEY_DATE_OF_BIRTH,fetch_date_of_birth);
                params.put(KEY_PREFERRED_WORKUT,fetch_preferred_workout);

                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    }

