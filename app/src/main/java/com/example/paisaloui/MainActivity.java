package com.example.paisaloui;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
ProgressBar progressBar;
TextView textView7,textView8,textView13,textView6;
GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.circular_determinative_pb);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        gifImageView=findViewById(R.id.gifImageView);
        textView6=findViewById(R.id.textView6);
        textView13=findViewById(R.id.textView13);





        String[] arraySpinner = new String[] {
                "SBI", "UCO", "BOB"
        };
        Spinner s = (Spinner) findViewById(R.id.database);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        progressBar.setMax(100);
        progressBar.setProgress(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i=0;i<=68;i++){

                   progressBar.setProgress(i);
                   try {
                       sleep(30);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();

       s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    gifImageView.setImageResource(R.drawable.crosssign);
                    textView8.setText("Sorry!!");
                    textView8.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
                    textView7.setText("You are not eligible for loan");
                    textView13.setVisibility(View.GONE);
                    textView6.setVisibility(View.GONE);
                }else if (position==1){
                    gifImageView.setImageResource(R.drawable.checksign);
                    textView8.setText("Congrats!!");
                    textView8.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.green));
                    textView7.setText("You are eligible for loan");
                    textView13.setVisibility(View.VISIBLE);
                    textView6.setVisibility(View.VISIBLE);
                }else  if (position==2){
                    gifImageView.setImageResource(R.drawable.crosssign);
                    textView8.setText("Sorry!!");
                    textView8.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
                    textView7.setText("You are not eligible for loan");
                    textView13.setVisibility(View.GONE);
                    textView6.setVisibility(View.GONE);
                }
               }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }
}