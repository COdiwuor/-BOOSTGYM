package com.example.android.boostgym;

 public class PastWorkout {
    private String workout,reps,date;

    public PastWorkout(String workout,String reps,String date){
        this.workout = workout;
        this.reps = reps;
        this.date =date;
    }

    public String getWorkout(){
        return workout;
     }
     public String getReps(){
        return reps;
     }
     public String getDate(){
        return date;
     }
}
