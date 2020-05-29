package com.csquiz.applicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

     private Button Logout;
     private Button Next;

     private int myScore;
     private String Answer;

     private TextView question;
     private TextView Number;
     private TextView Timer;
     private TextView Score;


     private RadioButton Option1;
     private RadioButton Option2;
     private RadioButton Option3;
     private RadioButton Option4;

     private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Logout = findViewById(R.id.Logout);
        Next = findViewById(R.id.Next);

        question = findViewById(R.id.question);
        Number = findViewById(R.id.Number);
        Timer = findViewById(R.id.Timer);
        Score = findViewById(R.id.Score);

        Option1 = findViewById(R.id.Option1);
        Option2 = findViewById(R.id.Option2);
        Option3 = findViewById(R.id.Option3);
        Option4 = findViewById(R.id.Option4);





        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizActivity.this , StartActivity.class));
            }
        });


    }

    public  void updateQuestion(){
        mQuestionRef = new Firebase("https://activitydemo-6f7da.firebaseio.com/0/question");

        mQuestionRef.add
    }

}
