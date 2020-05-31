package com.csquiz.applicationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class QuizActivity extends AppCompatActivity {

     private Button Logout;
     private Button Next;

     int total = 0;
     int correct = 0;
     int wrong = 0;

     private int myScore;
     private String Answer;

     private TextView quest;
     private TextView Number;
     private TextView Timer;
     private TextView Score;

     DatabaseReference reference;

     private RadioButton Opt1;
     private RadioButton Opt2;
     private RadioButton Opt3;
     private RadioButton Opt4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Logout = findViewById(R.id.Logout);
        Next = findViewById(R.id.Next);

        quest = findViewById(R.id.quest);
        Number = findViewById(R.id.Number);
        Timer = findViewById(R.id.Timer);
        Score = findViewById(R.id.Score);

        Opt1 = findViewById(R.id.Opt1);
        Opt2 = findViewById(R.id.Opt2);
        Opt3 = findViewById(R.id.Opt3);
        Opt4 = findViewById(R.id.Opt4);


        updateQuestion();
        reverseTimer(30, Timer);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizActivity.this , StartActivity.class));
            }
        });


    }

        private void updateQuestion(){

            total++;

            if(total>6){
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                i.putExtra("total", String.valueOf(total));
                i.putExtra("correct", String.valueOf(correct));
                i.putExtra("Incorrect", String.valueOf(wrong));
                startActivity(i);
                //open the result activity
            }

            else{
                reference = FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Question question = dataSnapshot.getValue(Question.class);

                        quest.setText(question.getQuestion());
                        Opt1.setText(question.getOption1());
                        Opt2.setText(question.getOption2());
                        Opt3.setText(question.getOption3());
                        Opt4.setText(question.getOption4());

                        Opt1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(Opt1.getText().toString().equals(question.getAnswer())){
                                    Toast.makeText(QuizActivity.this, "Correct answer", Toast.LENGTH_SHORT).show();
                                    Opt1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            Opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                }
                                else{
                                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                                    //find correct answer and make it green
                                    wrong++;
                                    Opt1.setBackgroundColor(Color.RED);

                                    if(Opt2.getText().toString().equals(question.getAnswer())){

                                        Opt2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(Opt3.getText().toString().equals(question.getAnswer())){
                                        Opt3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(Opt4.getText().toString().equals(question.getAnswer())){
                                        Opt4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                }

                            }
                        });

                        Opt2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(Opt2.getText().toString().equals(question.getAnswer())){
                                    Toast.makeText(QuizActivity.this, "Correct answer", Toast.LENGTH_SHORT).show();
                                    Opt2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            Opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                }
                                else{
                                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                                    //find correct answer and make it green
                                    wrong++;
                                    Opt2.setBackgroundColor(Color.RED);

                                    if(Opt1.getText().toString().equals(question.getAnswer())){

                                        Opt1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(Opt3.getText().toString().equals(question.getAnswer())){
                                        Opt3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(Opt4.getText().toString().equals(question.getAnswer())){
                                        Opt4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                }

                            }
                            });

                            Opt3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(Opt3.getText().toString().equals(question.getAnswer())){
                                        Toast.makeText(QuizActivity.this, "Correct answer", Toast.LENGTH_SHORT).show();
                                        Opt3.setBackgroundColor(Color.GREEN);
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                correct++;
                                                Opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                updateQuestion();
                                            }
                                        }, 1500);
                                    }
                                    else{
                                        Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                                        //find correct answer and make it green
                                        wrong++;
                                        Opt3.setBackgroundColor(Color.RED);

                                        if(Opt1.getText().toString().equals(question.getAnswer())){

                                            Opt1.setBackgroundColor(Color.GREEN);
                                        }
                                        else if(Opt2.getText().toString().equals(question.getAnswer())){
                                            Opt2.setBackgroundColor(Color.GREEN);
                                        }
                                        else if(Opt4.getText().toString().equals(question.getAnswer())){
                                            Opt4.setBackgroundColor(Color.GREEN);
                                        }


                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                updateQuestion();
                                            }
                                        }, 1500);
                                    }

                                }

                            });

                            Opt4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if(Opt4.getText().toString().equals(question.getAnswer())){
                                        Toast.makeText(QuizActivity.this, "Correct answer", Toast.LENGTH_SHORT).show();
                                        Opt4.setBackgroundColor(Color.GREEN);
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                correct++;
                                                Opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                updateQuestion();
                                            }
                                        }, 1500);
                                    }
                                    else{
                                        Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                                        //find correct answer and make it green
                                        wrong++;
                                        Opt4.setBackgroundColor(Color.RED);

                                        if(Opt1.getText().toString().equals(question.getAnswer())){

                                            Opt1.setBackgroundColor(Color.GREEN);
                                        }
                                        else if(Opt2.getText().toString().equals(question.getAnswer())){
                                            Opt2.setBackgroundColor(Color.GREEN);
                                        }
                                        else if(Opt3.getText().toString().equals(question.getAnswer())){
                                            Opt3.setBackgroundColor(Color.GREEN);
                                        }


                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                Opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                updateQuestion();
                                            }
                                        }, 1500);
                                    }

                                }

                            });




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }
        public void reverseTimer(int seconds, final TextView tv){
        new CountDownTimer(seconds * 1000 + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%O2d", seconds));
            }

            @Override
            public void onFinish() {

                tv.setText("Completed");
                Intent myIntent = new Intent(QuizActivity.this , ResultActivity.class);
                myIntent.putExtra("total", String.valueOf(total));
                myIntent.putExtra("correct", String.valueOf(correct));
                myIntent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(myIntent);

            }
        }.start();

        }


}
