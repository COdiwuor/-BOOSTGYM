package com.example.android.boostgym;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class GyminstructorActivity extends AppCompatActivity {

    private List<Instructors> gyminstructorList;
    private RecyclerView recyclerView;
    private GymAdapter gAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyminstructor);

        gyminstructorList=new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        gyminstructorList.add(new Instructors("John", "0771252134", "John@gmail.com", "male"));
        gyminstructorList.add(new Instructors("Mary", "0702252133", "Mary@gmail.com", "female"));
        gyminstructorList.add(new Instructors("Rose", "0703262134", "Rose@gmail.com", "female"));
        gyminstructorList.add(new Instructors("Sam", "0710233134", "Sam@gmail.com", "male"));
        gyminstructorList.add(new Instructors("David", "0701952334", "David@gmail.com", "male"));
        gyminstructorList.add(new Instructors("Rachael", "0704252334", "Rachael@gmail.com", "female"));
        gyminstructorList.add(new Instructors("Brian", "0705242334", "Brian@gmail.com", "male"));
        gAdapter = new GymAdapter(gyminstructorList,this);
        recyclerView.setAdapter(gAdapter);
    }

}
