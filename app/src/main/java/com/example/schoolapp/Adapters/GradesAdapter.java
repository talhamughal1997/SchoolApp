package com.example.schoolapp.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Fragments.CalculusFragment;
import com.example.schoolapp.Model.MarksModel;
import com.example.schoolapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.MyViewHolder> {

    ArrayList<MarksModel.Data.Marks> arrayList;
    Activity activity;


    public GradesAdapter(ArrayList<MarksModel.Data.Marks> arrayList, Activity activity) {
        this.arrayList = arrayList;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grades_list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.txt_subject.setText(arrayList.get(i).getSubject());
        myViewHolder.txt_marks.setText(arrayList.get(i).getMark());
        double a = Double.parseDouble(arrayList.get(i).getFinalmark());
        double b;
        if (arrayList.get(i).getMark() != null) {
            b = Double.parseDouble(arrayList.get(i).getMark());
            Toast.makeText(activity, "null", Toast.LENGTH_SHORT).show();
            myViewHolder.txt_percent.setText(getPercentage(b, a) + "%");
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.changeFragment((AppCompatActivity) activity, new CalculusFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public String getPercentage(double obtained, double total) {
        double d = obtained * 100 / total;
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(d);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_subject, txt_marks, txt_percent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_marks = itemView.findViewById(R.id.txt_marks);
            txt_percent = itemView.findViewById(R.id.txt_perc);
            txt_subject = itemView.findViewById(R.id.txt_subject);
        }
    }


}
