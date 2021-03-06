package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView flashcardquestion1 = findViewById(R.id.question1);
        TextView flashcardanswer1 = findViewById(R.id.answer1);
        TextView flashcardanswer2 = findViewById(R.id.answer2);
        TextView flashcardanswer3 = findViewById(R.id.answer3);
        TextView flashcardanswer4 = findViewById(R.id.answer4);
        TextView flashcardanswer5 = findViewById(R.id.answer5);
        ImageView answerNotShowing = findViewById(R.id.answerNotShowing);
        ImageView answerShowing = findViewById(R.id.answerShowing);
        boolean visible = false;

        flashcardquestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardquestion1.setVisibility(View.INVISIBLE);
                flashcardanswer1.setVisibility(View.VISIBLE);
            }
        });

        flashcardanswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer1.setVisibility(View.INVISIBLE);
                flashcardquestion1.setVisibility(View.VISIBLE);
            }
        });


        flashcardanswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer2.setBackgroundColor(getResources().getColor(R.color.red));
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });

        flashcardanswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

        flashcardanswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer4.setBackgroundColor(getResources().getColor(R.color.red));
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });

        flashcardanswer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer5.setBackgroundColor(getResources().getColor(R.color.red));
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });


        answerNotShowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerNotShowing.setVisibility(View.INVISIBLE);
                flashcardanswer2.setVisibility(View.VISIBLE);
                flashcardanswer3.setVisibility(View.VISIBLE);
                flashcardanswer4.setVisibility(View.VISIBLE);
                flashcardanswer5.setVisibility(View.VISIBLE);
                answerShowing.setVisibility(View.VISIBLE);

            }
        });










    }
}