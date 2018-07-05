package com.example.android.boostgym;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GymAdapter extends RecyclerView.Adapter<GymAdapter.MyViewHolder> {
    private List<Instructors> gymList;
    private Context mCtx;

    public GymAdapter(List<Instructors> gymList, Context mCtx) {
        this.gymList = gymList;
        this.mCtx = mCtx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name ,contact, email, gender;

        public MyViewHolder(View view){
            super(view);
            name=  view.findViewById(R.id.name);
            contact = view.findViewById(R.id.contact);
            email = view.findViewById(R.id.email);
            gender = view.findViewById(R.id.gender);
        }

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.gyminstructor_list_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Instructors instructors = gymList.get(position);
        holder.name.setText(instructors.getName());
        holder.contact.setText(instructors.getContact());
        holder.email.setText(instructors.getEmail());
        holder.gender.setText(instructors.getGender());
    }


    @Override
    public int getItemCount() {
        return gymList.size();
    }

}
