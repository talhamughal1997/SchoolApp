package com.example.schoolapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolapp.Model.AnnouncementModel;
import com.example.schoolapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.MyViewHolder> {

    ArrayList<AnnouncementModel.Data.Notices> arrayList;

    public AnnouncementAdapter(ArrayList<AnnouncementModel.Data.Notices> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.announcement_list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView_title.setText(arrayList.get(i).getTitle());
        myViewHolder.mTextView_notice.setText(arrayList.get(i).getNotice());
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("D");

        Date now;
        try {
            now = simpleDateformat.parse(arrayList.get(i).getDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            myViewHolder.mTextView_date.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            simpleDateformat = new SimpleDateFormat("E");
            myViewHolder.mTextView_day.setText(simpleDateformat.format(now));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView_date, mTextView_day, mTextView_title, mTextView_notice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView_date = itemView.findViewById(R.id.txtDate);
            mTextView_day = itemView.findViewById(R.id.txtDay);
            mTextView_title = itemView.findViewById(R.id.txt_title);
            mTextView_notice = itemView.findViewById(R.id.txt_notice);
        }
    }
}
