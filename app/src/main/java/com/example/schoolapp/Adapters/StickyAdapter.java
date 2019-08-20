package com.example.schoolapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolapp.Model.AssignmentModel;
import com.example.schoolapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StickyAdapter extends RecyclerView.Adapter<StickyAdapter.Holder> {

    Context mContext;
    ArrayList<AssignmentModel.Assignments> mArraylist;

    public StickyAdapter(Context mContext, ArrayList<AssignmentModel.Assignments> mArrayListString) {
        this.mContext = mContext;
        this.mArraylist = mArrayListString;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.homework_list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mTextView_Book.setText(mArraylist.get(position).getTitle());
        holder.mTextView_Subject.setText(mArraylist.get(position).getDescription());
        holder.mTextView_dline.setText(mArraylist.get(position).getDeadlinedate());
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("D");

        Date now;
        try {
            now = simpleDateformat.parse(mArraylist.get(position).getModify_date());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            holder.mTextView_Date.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            simpleDateformat = new SimpleDateFormat("E");
            holder.mTextView_Day.setText(simpleDateformat.format(now));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return mArraylist.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mTextView_Date, mTextView_Day, mTextView_Book, mTextView_Subject,mTextView_dline;

        public Holder(View itemView) {
            super(itemView);
            mTextView_Book = itemView.findViewById(R.id.txt_title);
            mTextView_Subject = itemView.findViewById(R.id.txt_notice);
            mTextView_Date = itemView.findViewById(R.id.txtDate);
            mTextView_Day = itemView.findViewById(R.id.txtDay);
            mTextView_dline = itemView.findViewById(R.id.txt_dline);
        }
    }
}