package com.example.android.boostgym;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

 public class GymworkoutAdapter extends RecyclerView.Adapter<GymworkoutAdapter.MyViewHolder> {
     private List<PastWorkout> pastWorkoutList;
     private Context mCtx;


     public GymworkoutAdapter(List<PastWorkout> pastWorkoutList, Context mCtx) {
         this.pastWorkoutList = pastWorkoutList;
         this.mCtx = mCtx;

     }

     public class MyViewHolder extends RecyclerView.ViewHolder {
         public TextView workout, reps, date;

         public MyViewHolder(View view) {
             super(view);
             workout = view.findViewById(R.id.workout);
             reps = view.findViewById(R.id.workoutreps);
             date = view.findViewById(R.id.date);

         }
     }


     @NonNull
     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater inflater = LayoutInflater.from(mCtx);
         View view = inflater.inflate(R.layout.past_workout_list_row, null);
         return new MyViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         PastWorkout pastWorkout = pastWorkoutList.get(position);
         holder.workout.setText(pastWorkout.getWorkout());
         holder.reps.setText(pastWorkout.getReps());
         holder.date.setText(pastWorkout.getDate());

     }


     @Override
     public int getItemCount() {
         return pastWorkoutList.size();

     }
 }

