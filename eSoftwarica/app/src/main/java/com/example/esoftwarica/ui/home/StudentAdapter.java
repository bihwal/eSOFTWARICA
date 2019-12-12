package com.example.esoftwarica.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.R;

import java.io.FileInputStream;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder> {

    Context mContext;
    List<Students> contactsList;

    public StudentAdapter(Context mContext, List<Students> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }
    @NonNull
    @Override

    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_students,parent,false);
        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        final Students contacts=contactsList.get(position);
        holder.imgcontact.setImageResource(contacts.getImageid());
        holder.tvname.setText(contacts.getName());
        holder.tvage.setText(contacts.getAge());
        holder.tvaddress.setText(contacts.getAddress());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvname,tvage,tvaddress;
        ImageView imgcontact;
        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
            tvage=itemView.findViewById(R.id.tvage);
            tvaddress=itemView.findViewById(R.id.tvaddress);
            imgcontact=itemView.findViewById(R.id.imageView);
        }
    }


}