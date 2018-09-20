package com.example.santerrecharles.tp2listeetudiants.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.santerrecharles.tp2listeetudiants.R;
import com.example.santerrecharles.tp2listeetudiants.model.Student;
import com.example.santerrecharles.tp2listeetudiants.model.StudentHolder;

import java.util.List;

public class StudentListAdapter extends ArrayAdapter<Student> {

    public StudentListAdapter(Context context, List<Student> students){
        super(context, 0,students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_list_row,parent, false);
        }

        StudentHolder viewHolder = (StudentHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new StudentHolder();
            viewHolder.nom = convertView.findViewById(R.id.nomRow);
            viewHolder.prenom = convertView.findViewById(R.id.prenomRow);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Student student = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(student.getNom());
        viewHolder.prenom.setText(student.getPrenom());

        return convertView;
    }
}
