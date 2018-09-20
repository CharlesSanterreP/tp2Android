package com.example.santerrecharles.tp2listeetudiants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.santerrecharles.tp2listeetudiants.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addStudentButton;
    Button studentListButton;
    public static List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentList = new ArrayList<Student>();

    }

    public void onClickAddStudent(View v){
        Intent intent = new Intent(v.getContext(), AddStudentActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onClickStudentList(View v){
        if(studentList.size() < 1){
            Toast.makeText(v.getContext(), "Il n'y a pas d'étudiant", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(v.getContext(), StudentListActivity.class);
            startActivityForResult(intent, 0);
        }
    }
}
