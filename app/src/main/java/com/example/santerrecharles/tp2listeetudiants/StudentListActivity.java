package com.example.santerrecharles.tp2listeetudiants;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.santerrecharles.tp2listeetudiants.adapter.StudentListAdapter;
import com.example.santerrecharles.tp2listeetudiants.model.Student;

public class StudentListActivity extends ListActivity {

    private ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        studentListView = findViewById(android.R.id.list);

        StudentListAdapter studentListAdapter = new StudentListAdapter(StudentListActivity.this, MainActivity.studentList);
        studentListView.setAdapter(studentListAdapter);

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) studentListView.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                //Crade de fou voir si j'ai le temps pour refaire en passat l'objet directement
                intent.putExtra("nom", student.getNom());
                intent.putExtra("prenom", student.getPrenom());
                intent.putExtra("sexe", student.getSexe());
                intent.putExtra("email", student.getEmail());
                intent.putExtra("naiss", student.getAge());
                intent.putExtra("groupe", student.getGroupe());
                intent.putExtra("redoublant", student.getRedoublant().toString());
                startActivityForResult(intent, 0);
            }
        });
    }

}
