package com.example.navtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    ArrayList<Employee> employees;

    public MyRecyclerViewAdapter(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.employee_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Employee currentEmployeeBeingPopulated = employees.get(i);
        viewHolder.tvName.setText(currentEmployeeBeingPopulated.getName());
        viewHolder.tvBday.setText(currentEmployeeBeingPopulated.getBirthday());
        viewHolder.tvwage.setText(currentEmployeeBeingPopulated.getWage());
        viewHolder.tvHiredate.setText(currentEmployeeBeingPopulated.getHiredate());
        viewHolder.tvImage.setText(currentEmployeeBeingPopulated.getImage());
        viewHolder.tvID.setText("ID: "+currentEmployeeBeingPopulated.getId());
        Glide
                .with(viewHolder.employeePic.getContext())
                .load("https://crossfitreload.fitness/wp-content/uploads/2016/06/stormTrooper.jpg")
                .into(viewHolder.employeePic);

        Log.d("TAG", "onBindViewHolder: item being rendered "+i);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvBday;
        TextView tvwage;
        TextView tvHiredate;
        TextView tvImage;
        TextView tvID;
        ImageView employeePic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvRvName);
            tvBday = itemView.findViewById(R.id.tvRvBday);
            tvwage = itemView.findViewById(R.id.tvRvWage);
            tvHiredate = itemView.findViewById(R.id.tvRvHireDate);
            tvImage = itemView.findViewById(R.id.tvImage);
            employeePic = itemView.findViewById(R.id.ivEmployeePic);

        }
    }
}
