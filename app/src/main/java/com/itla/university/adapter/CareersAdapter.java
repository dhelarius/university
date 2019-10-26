package com.itla.university.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.university.R;
import com.itla.university.model.entity.Career;

import java.util.List;

public class CareersAdapter extends RecyclerView.Adapter<CareersAdapter.ViewHolder> {

    private List<Career> careers;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textCareerName;
        TextView textNumAsignatures;
        TextView textNumCredits;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCareerName = itemView.findViewById(R.id.textCareerName);
            textNumAsignatures = itemView.findViewById(R.id.textNumAsignatures);
            textNumCredits = itemView.findViewById(R.id.textNumCredits);
        }

        static void bind(@NonNull ViewHolder holder, Career item) {
            holder.textCareerName.setText(item.getName());
            holder.textNumAsignatures.setText(String.valueOf(item.getAsignatures()));
            holder.textNumCredits.setText(String.valueOf(item.getCredits()));
        }
    }

    public CareersAdapter(List<Career> careers){ this.careers = careers; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View careerView = inflater.inflate(R.layout.career_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(careerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Career item = careers.get(position);
        ViewHolder.bind(holder, item);
    }

    @Override
    public int getItemCount() {
        return careers.size();
    }
}
