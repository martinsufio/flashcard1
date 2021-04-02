package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        ImageView dismissButton =findViewById(R.id.dismissButton);
        ImageView saveButton =findViewById(R.id.saveButton);


        String s1 = getIntent().getStringExtra("stringKey1");
        String s2 = getIntent().getStringExtra("stringKey2");
        String s3 = getIntent().getStringExtra("stringKey3");
        String s4 = getIntent().getStringExtra("stringKey4");
        String s5 = getIntent().getStringExtra("stringKey5");
        String s6 = getIntent().getStringExtra("stringKey6");
        ((EditText)findViewById(R.id.editQuestion)).setText(s1);
        ((EditText)findViewById(R.id.editAnswer)).setText(s2);
        ((EditText)findViewById(R.id.editAnswer2)).setText(s3);
        ((EditText)findViewById(R.id.editAnswer3)).setText(s4);
        ((EditText)findViewById(R.id.editAnswer4)).setText(s5);
        ((EditText)findViewById(R.id.editAnswer5)).setText(s6);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.right2_in,R.anim.left2_out);
            }

        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.editQuestion)).getText().toString();
                String answer = ((EditText) findViewById(R.id.editAnswer)).getText().toString();
                String answer2 = ((EditText) findViewById(R.id.editAnswer2)).getText().toString();
                String answer3 = ((EditText) findViewById(R.id.editAnswer3)).getText().toString();
                String answer4 = ((EditText) findViewById(R.id.editAnswer4)).getText().toString();
                String answer5 = ((EditText) findViewById(R.id.editAnswer5)).getText().toString();
                if(question.isEmpty() || answer.isEmpty()){
                    Toast.makeText(getApplicationContext(), "You Must Write something in both question and answer", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent data = new Intent(); // create a new Intent, this is where we will put our data
                    data.putExtra("string1", question); // puts one string into the Intent, with the key as 'string1'
                    data.putExtra("string2", answer); // puts another string into the Intent, with the key as 'string2
                    data.putExtra("string3", answer2);
                    data.putExtra("string4", answer3);
                    data.putExtra("string5", answer4);
                    data.putExtra("string6", answer5);
                    setResult(RESULT_OK, data); // set result code and bundle data for response

                    finish(); // closes this activity and pass data to the original activity that launched this activity

                }
                overridePendingTransition(R.anim.down_out, R.anim.down_in);

            }
        });




    }




}