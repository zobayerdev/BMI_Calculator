package com.trodev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button recalculatebmi;
    TextView mbmidisplay, mbmicategory, mgender;
    Intent intent;
    ImageView mimageview, mdev;
    String mbmi;
    float intbmi;
    String height;
    String weight;
    float intheight;
    float intweight;
    RelativeLayout mbackground;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        recalculatebmi = findViewById(R.id.recalculatebmi);

        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mimageview = findViewById(R.id.bmiimage);
        mbackground = findViewById(R.id.contentlayout);
        mdev = findViewById(R.id.dev);


        intent = getIntent();

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");


        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);

        mbmi = Float.toString(intbmi);



        if(intbmi < 16)
        {
            mbmicategory.setText("BMI Category: "+"Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.ic_ok);
        }
        else if(intbmi< 16.9 && intbmi > 16)
        {
            mbmicategory.setText("BMI Category: "+"Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.ic_ok);
        }

        else if(intbmi< 18.4 && intbmi > 17)
        {
            mbmicategory.setText("BMI Category: "+"Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.ic_ok);
        }
        else if(intbmi <25 && intbmi>18.4)
        {
            mbmicategory.setText("BMI Category: "+"Normal");
           // mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ic_ok);
        }

        else if(intbmi <29.4 && intbmi>25)
        {
            mbmicategory.setText("BMI Category: "+"Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.ic_bad);
        }
        else {
            mbmicategory.setText("BMI Category: "+"Obese Class 1");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.ic_bad);
        }

        mgender.setText("Gender: "+intent.getStringExtra("gender"));
        mbmidisplay.setText("Your BMI is: "+mbmi);


        mdev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this, Developer.class);
                startActivity(intent);
            }
        });


        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}