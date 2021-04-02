package com.example.flashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

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
        ImageView nextButton = findViewById(R.id.nextButton);
        ImageView deleteButton = findViewById(R.id.deleteButton);


        flashcardquestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                flashcardquestion1.setVisibility(View.INVISIBLE);
//                flashcardanswer1.setVisibility(View.VISIBLE);

                View answerSideView = findViewById(R.id.answer1);
                View questionSideView = findViewById(R.id.question1);

// get the center for the clipping circle
                int cx = answerSideView.getWidth() / 2;
                int cy = answerSideView.getHeight() / 2;

// get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(answerSideView, cx, cy, 0f, finalRadius);

// hide the question and show the answer to prepare for playing the animation!
                questionSideView.setVisibility(View.INVISIBLE);
                answerSideView.setVisibility(View.VISIBLE);

                anim.setDuration(3000);
                anim.start();
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
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                currentCardDisplayedIndex = allFlashcards.size();

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
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.question1)).getText().toString());



            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // advance our pointer index so we can show the next card
                if (allFlashcards.size() == 0)
                    return;
                currentCardDisplayedIndex++;
                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if(currentCardDisplayedIndex==allFlashcards.size()){
                    Toast.makeText(getApplicationContext(), "You've reached the end of the cards, going back to start.", Toast.LENGTH_SHORT).show();
                    currentCardDisplayedIndex=0;
                }

                // set the question and answer TextViews with data from the database
                allFlashcards = flashcardDatabase.getAllCards();
                Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);
                
                ((TextView) findViewById(R.id.question1)).setText(flashcard.getQuestion());
                ((TextView) findViewById(R.id.answer1)).setText(flashcard.getAnswer());

                final Animation leftOutAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_out);
                final Animation rightInAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.right_in);

                leftOutAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                findViewById(R.id.question1).startAnimation(leftOutAnim);
                findViewById(R.id.question1).startAnimation(rightInAnim);
            }
        });


        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.question1)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.answer1)).setText(allFlashcards.get(0).getAnswer());
        }




        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.question1)).getText().toString());
                ((TextView) findViewById(R.id.question1)).setText(allFlashcards.get(currentCardDisplayedIndex-1).getQuestion());
                ((TextView) findViewById(R.id.answer1)).setText(allFlashcards.get(currentCardDisplayedIndex-1).getAnswer());
                allFlashcards = flashcardDatabase.getAllCards();
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

            flashcardDatabase.insertCard(new Flashcard(string1,string2));
            allFlashcards = flashcardDatabase.getAllCards();
        }


    }
}