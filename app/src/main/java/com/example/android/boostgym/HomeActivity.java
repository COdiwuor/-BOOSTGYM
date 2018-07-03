package com.example.android.boostgym;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.boostgym.Helper.LocaleHelper;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {
      Button btn1, btn2, btn3, btn4, btn5, btnlogout;
    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1= (Button)findViewById(R.id.button1);
        btn2 =(Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4= (Button)findViewById(R.id.button4);
        btn5 =  (Button)findViewById(R.id.button5);
        btnlogout =(Button)findViewById(R.id.btnlogout);
        textView = (TextView) findViewById(R.id.text_view);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language ==null)
            Paper.book().write("language","en");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,UserprofileActivity.class));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PastworkoutActivity.class));

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MapsActivity.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,GyminstructorActivity.class));

            }

        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,WorkoutsessionActivity.class));
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this ,MainApplication.class));
            }
        });

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        finish();
        startActivity(new Intent(HomeActivity.this,HomeActivity.class));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.language_en) {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId() == R.id.language_ge){
            Paper.book().write("language","de");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId() == R.id.language_swa){
            Paper.book().write("language","sw");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }




}
