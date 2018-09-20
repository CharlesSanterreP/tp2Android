package com.example.santerrecharles.tp2listeetudiants;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.santerrecharles.tp2listeetudiants.model.Student;

public class AddStudentActivity extends AppCompatActivity{

    Button birthDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

        birthDateButton = findViewById(R.id.birthDateButton);
    }

    public void showDatePicker(View v) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = 1996;
        DatePickerDialog newFragment = new DatePickerDialog(AddStudentActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        birthDateButton.setText(String.valueOf(dayOfMonth)+"/"+String.valueOf(month)+"/"+String.valueOf(year));
                    }
                },year, month, day) ;
        newFragment.show();
    }

    public void addStudent(View v){
        EditText editTextNom = findViewById(R.id.editTextNom);
        EditText editTextPrenom = findViewById(R.id.editTextPrenom);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        RadioGroup radioGroupSexe = findViewById(R.id.radioGroupSex);
        RadioButton radioButtonSexe = findViewById(radioGroupSexe.getCheckedRadioButtonId());
        Button ageButton = findViewById(R.id.birthDateButton);
        Spinner spinnerGroup = findViewById(R.id.spinnerGroup);
        Switch redoublantButton = findViewById(R.id.switchRedoublant);

        Student student = new Student();
        boolean error = false;
        String message = "";
        if(!"".equals(editTextNom.getText().toString())){
            student.setNom(editTextNom.getText().toString());
        }else{
            error = true;
            message = "Veuillez entrer un nom";
        }
        if(!"".equals(editTextPrenom.getText().toString())){
            student.setPrenom(editTextPrenom.getText().toString());
        }else{
            error = true;
            message = "Veuillez entrer un prénom";
        }
        if(!"".equals(editTextEmail.getText().toString())){
            student.setEmail(editTextEmail.getText().toString());
        }else{
            error = true;
            message = "Veuillez entrer un email";
        }
        if(radioButtonSexe != null){
            student.setSexe(radioButtonSexe.getText().toString());
        }else{
            error = true;
            message = "Veuillez renseigner le sexe";
        }
        if(!"Date de naissance".equals(ageButton.getText().toString())){
            student.setAge(ageButton.getText().toString());
        }else{
            error = true;
            message = "Veuillez renseigner la date de naissance";
        }
        student.setGroupe(spinnerGroup.getSelectedItem().toString());
        student.setRedoublant(redoublantButton.isChecked());

        if(error){
            Toast.makeText(v.getContext(), message, Toast.LENGTH_LONG).show();
        }else{
            MainActivity.studentList.add(student);
            Toast.makeText(v.getContext(), "Etudiant ajouté", Toast.LENGTH_LONG).show();
        }
    }
}