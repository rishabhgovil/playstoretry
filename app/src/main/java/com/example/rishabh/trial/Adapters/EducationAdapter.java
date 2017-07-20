package com.example.rishabh.trial.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabh.trial.POJOs.education;
import com.example.rishabh.trial.POJOs.games;
import com.example.rishabh.trial.R;

import java.util.ArrayList;

/**
 * Created by RISHABH on 16-07-2017.
 */

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EduViewHolder> {

    Context context;
    ArrayList<education> educationArrayList;

    public EducationAdapter(Context context, ArrayList<education> educationArrayList) {
        this.context = context;
        this.educationArrayList = educationArrayList;
    }

    @Override
    public EduViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.education,parent,false);
        return new EducationAdapter.EduViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(EducationAdapter.EduViewHolder holder, int position) {
        education thisedu = educationArrayList.get(position);
        holder.edu.setText(thisedu.getEdu());

        holder.iv1.setImageResource(thisedu.getIv1());

    }

    @Override
    public int getItemCount() {
        return educationArrayList.size();
    }

    public class EduViewHolder extends RecyclerView.ViewHolder{
        TextView edu;
        ImageView iv1;
        public EduViewHolder(View itemView) {
            super(itemView);
            edu=(TextView)itemView.findViewById(R.id.edu);
            iv1=(ImageView)itemView.findViewById(R.id.iv1);
        }
    }
}
