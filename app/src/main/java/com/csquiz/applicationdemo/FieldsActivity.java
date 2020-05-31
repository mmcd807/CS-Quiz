package com.csquiz.applicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FieldsActivity extends AppCompatActivity {

    private Button Programming;
    private Button Artificial;
    private Button Machine;
    private Button Networking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);

        Programming = findViewById(R.id.Programming);
        Artificial = findViewById(R.id.Artificial);
        Machine = findViewById(R.id.Machine);
        Networking = findViewById(R.id.Networking);

        Programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FieldsActivity.this , ProgrammingActivity.class));
            }
        });

        Artificial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FieldsActivity.this , QuizActivity.class));
            }
        });

        Machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FieldsActivity.this , QuizActivity.class));
            }
        });

        Networking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FieldsActivity.this , QuizActivity.class));
            }
        });
    }
}
