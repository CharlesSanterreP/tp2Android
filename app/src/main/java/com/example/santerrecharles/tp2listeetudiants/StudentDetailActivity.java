package com.example.santerrecharles.tp2listeetudiants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_detail);

        TextView nomDetail = findViewById(R.id.nomDetail);
        TextView prenomDetail = findViewById(R.id.prenomDetail);
        TextView sexeDetail = findViewById(R.id.sexeDetail);
        TextView emailDetail = findViewById(R.id.emailDetail);
        TextView naissDetail = findViewById(R.id.naissDetail);
        TextView groupeDetail = findViewById(R.id.groupeDetail);
        TextView redoublantDetail = findViewById(R.id.redoublantDetail);

        nomDetail.setText(getIntent().getStringExtra("nom"));
        prenomDetail.setText(getIntent().getStringExtra("prenom"));
        sexeDetail.setText(getIntent().getStringExtra("sexe"));
        emailDetail.setText(getIntent().getStringExtra("email"));
        naissDetail.setText(getIntent().getStringExtra("naiss"));
        groupeDetail.setText(getIntent().getStringExtra("groupe"));
        redoublantDetail.setText(getIntent().getStringExtra("redoublant"));
    }
}
