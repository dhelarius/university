package com.itla.university.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.itla.university.R;
import com.itla.university.model.entity.Student;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private List<Student> students;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textStudentName;
        TextView textStudentRegistration;
        TextView textCareerNameInStudent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textStudentName = itemView.findViewById(R.id.textStudentName);
            textStudentRegistration = itemView.findViewById(R.id.textStudentRegistration);
            textCareerNameInStudent = itemView.findViewById(R.id.textCareerNameInStudent);
        }

        public static void bind(@NonNull ViewHolder holder, Student item) {
            holder.textStudentName.setText(item.getName());
            holder.textStudentRegistration.setText(item.getRegistration());
            holder.textCareerNameInStudent.setText(item.getCareerName());
        }
    }

    public StudentsAdapter(List<Student> students){
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView = inflater.inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student item = students.get(position);
        ViewHolder.bind(holder, item);
    }

    @Override
    public int getItemCount() { return students.size(); }
}
