package com.example.android.boostgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PastworkoutActivity extends AppCompatActivity {

    private List<PastWorkout> pastworkoutList;
    private RecyclerView recyclerView;
    private GymworkoutAdapter pastworkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastworkout);

        pastworkoutList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pastworkoutList.add(new PastWorkout("Workout:chest and triceps","Reps:5reps","Date:2/2/2018"));
        pastworkoutList.add(new PastWorkout("Workout:abs","Reps:6reps","Date:5/2/2018"));
        pastworkoutList.add(new PastWorkout("Workout:back,biceps and forearms","Reps:6reps","Date:9/2/2018"));
        pastworkoutList.add(new PastWorkout("Workout:shoulder and legs","Reps:4reps","Date:3/2/2018"));


        pastworkoutAdapter = new GymworkoutAdapter(pastworkoutList,this);
        recyclerView.setAdapter(pastworkoutAdapter);


        

    }
}
