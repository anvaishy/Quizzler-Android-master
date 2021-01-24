package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    /* TODO: Declare constants here */


    // TODO: Declare member variables here:
     Button mtb;
     Button mfb;
     int marks=0;
TextView mytext;
int x;int question;
TextView mscore;
ProgressBar mProgressBar;
    // TODO: Uncomment to create question bank
    private Data[] q = new Data[] {
            new Data(R.string.question_1, true),
            new Data(R.string.question_2, true),
            new Data(R.string.question_3, false),
            new Data(R.string.question_4, true),
            new Data(R.string.question_5, false),
            new Data(R.string.question_6, false),
            new Data(R.string.question_7, true),
            new Data(R.string.question_8, false),
            new Data(R.string.question_9, true),
            new Data(R.string.question_10, true),
            new Data(R.string.question_11, false),
            new Data(R.string.question_12, false),
            new Data(R.string.question_13,true)
    };
    final int proginc = (int) Math.ceil(100/q.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mscore=(TextView) findViewById(R.id.score);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mfb= (Button)findViewById(R.id.false_button);
        mtb= (Button)findViewById(R.id.true_button);
        mytext=(TextView) findViewById(R.id.question_text_view);
        Data fq=q[x];


        question = q[x].getQ();
        mytext.setText(question);

        mtb.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              validate(true);
              update();
          }
      });

        mfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate(false);
                update();

            }
        });

    }
    private void validate(boolean user)
    {
        boolean c = (boolean)q[x].isAns();
        if(user==c)
        {marks++;
        mscore.setText("Score "+marks+"/"+q.length);
        mProgressBar.incrementProgressBy(proginc);
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }


    }
    private void update()
    {
        x=(x+1)%q.length;
        if(x==0) {
            AlertDialog.Builder A = new AlertDialog.Builder(this);
            A.setTitle("game over");
            A.setCancelable(false);
            A.setMessage("score = "+marks+"/"+q.length);
            A.setPositiveButton("exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            A.show();


        }
        question=q[x].getQ();
        mytext.setText(question);



    }
}
