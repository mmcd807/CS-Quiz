package com.csquiz.applicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgrammingActivity extends AppCompatActivity {

    private Button C;
    private Button Java;
    private Button Cpp;
    private Button Python;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);

        C = findViewById(R.id.C);
        Cpp = findViewById(R.id.Cpp);
        Java = findViewById(R.id.Java);
        Python = findViewById(R.id.Python);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProgrammingActivity.this , QuizActivity.class));
            }
        });

        Cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProgrammingActivity.this , QuizActivity.class));
            }
        });


        Java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProgrammingActivity.this , QuizActivity.class));
            }
        });

        Python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProgrammingActivity.this , QuizActivity.class));
            }
        });
    }
}
