package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView flashcardquestion1 = findViewById(R.id.question1);
        TextView flashcardanswer1 = findViewById(R.id.answer1);

        flashcardquestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardquestion1.setVisibility(View.INVISIBLE);
                flashcardanswer1.setVisibility(View.VISIBLE);
            }
        });
    }
}