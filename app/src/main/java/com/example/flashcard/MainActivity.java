package com.example.flashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        ImageView addCard = findViewById(R.id.addCard);
        ImageView editButton = findViewById(R.id.editButton);


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
        answerShowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer1.setVisibility(View.INVISIBLE);
                flashcardquestion1.setVisibility(View.VISIBLE);
                answerShowing.setVisibility(View.INVISIBLE);
                flashcardanswer2.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer2.setVisibility(View.INVISIBLE);
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer3.setVisibility(View.INVISIBLE);
                flashcardanswer4.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer4.setVisibility(View.INVISIBLE);
                flashcardanswer5.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer5.setVisibility(View.INVISIBLE);
                answerNotShowing.setVisibility(View.VISIBLE);

            }
        });

        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer1.setVisibility(View.INVISIBLE);
                flashcardquestion1.setVisibility(View.VISIBLE);
                answerShowing.setVisibility(View.INVISIBLE);
                flashcardanswer2.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer2.setVisibility(View.INVISIBLE);
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer3.setVisibility(View.INVISIBLE);
                flashcardanswer4.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer4.setVisibility(View.INVISIBLE);
                flashcardanswer5.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer5.setVisibility(View.INVISIBLE);
                answerNotShowing.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this, addCard.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardanswer1.setVisibility(View.INVISIBLE);
                flashcardquestion1.setVisibility(View.VISIBLE);
                answerShowing.setVisibility(View.INVISIBLE);
                flashcardanswer2.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer2.setVisibility(View.INVISIBLE);
                flashcardanswer3.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer3.setVisibility(View.INVISIBLE);
                flashcardanswer4.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer4.setVisibility(View.INVISIBLE);
                flashcardanswer5.setBackgroundColor(getResources().getColor(R.color.blue));
                flashcardanswer5.setVisibility(View.INVISIBLE);
                answerNotShowing.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this, addCard.class);
                intent.putExtra("stringKey1", ((TextView) findViewById(R.id.question1)).getText().toString());
                intent.putExtra("stringKey2", ((TextView) findViewById(R.id.answer1)).getText().toString());
                intent.putExtra("stringKey3", ((TextView) findViewById(R.id.answer2)).getText().toString());
                intent.putExtra("stringKey4", ((TextView) findViewById(R.id.answer3)).getText().toString());
                intent.putExtra("stringKey5", ((TextView) findViewById(R.id.answer4)).getText().toString());
                intent.putExtra("stringKey6", ((TextView) findViewById(R.id.answer5)).getText().toString());
                MainActivity.this.startActivityForResult(intent, 100);

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100  && resultCode == RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String string1 = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String string2 = data.getExtras().getString("string2");
            String string3 = data.getExtras().getString("string3");
            String string4 = data.getExtras().getString("string4");
            String string5 = data.getExtras().getString("string5");
            String string6 = data.getExtras().getString("string6");

            ((TextView)findViewById(R.id.question1)).setText(string1);
            ((TextView)findViewById(R.id.answer1)).setText(string2);
            ((TextView)findViewById(R.id.answer2)).setText(string3);
            ((TextView)findViewById(R.id.answer3)).setText(string4);
            ((TextView)findViewById(R.id.answer4)).setText(string5);
            ((TextView)findViewById(R.id.answer5)).setText(string6);
        }
    }
}