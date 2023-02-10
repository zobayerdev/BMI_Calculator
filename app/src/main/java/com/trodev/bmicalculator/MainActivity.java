package com.trodev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculatebmi;
    private TextView mcurrentheight, mcurrentweight, mcurrentage;
    private ImageView mincrementweight, mincrementage, mdecrementweight, mdecrementage;
    private SeekBar mseekbarforheight;
    private RelativeLayout heightlayout, male, female;

    int intweight = 50 ;
    int intage = 20;
    int currentprogress ;
    String minprogress = "170";
    String typeofuser = "0" ;

    String weight2 = "55";
    String age2 = "23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatebmi = findViewById(R.id.calculatebmi);

        mcurrentheight = findViewById(R.id.currentheight);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrentage = findViewById(R.id.currentage);

        mincrementweight = findViewById(R.id.incrementweight);
        mincrementage = findViewById(R.id.incrementage);

        mdecrementage = findViewById(R.id.decrementage);
        mdecrementweight = findViewById(R.id.decrementweight);


        mseekbarforheight = findViewById(R.id.seekbarforheight);
        heightlayout = findViewById(R.id.heightlayout);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });


        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentprogress = progress;
                minprogress = String.valueOf(currentprogress);
                mcurrentheight.setText(minprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });


        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage - 1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeofuser.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select Gender Fast", Toast.LENGTH_SHORT).show();
                }

                else if(minprogress.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select your Height ", Toast.LENGTH_SHORT).show();
                } else if (intage == 0 || intage < 0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Age ", Toast.LENGTH_SHORT).show();
                } else if (intweight == 0 || intweight < 0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Weight", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height",minprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Your Body Mess Index Result", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}