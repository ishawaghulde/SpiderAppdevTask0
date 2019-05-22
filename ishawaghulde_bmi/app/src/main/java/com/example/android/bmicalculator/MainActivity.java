package com.example.android.bmicalculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText height;
    TextView result;
    Button calculate;
    Typeface myFont;
    TextView quote;
    String comment="";
    Button generateQuote;

    ArrayList<String> list =new ArrayList();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculateBmi);
        quote = (TextView) findViewById(R.id.quote);

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculateRes();
            }
        });

        list.add("Health is not valued, till Sickness comes in.");
        list.add("Take care of your body. Its the only place you have to live in.");
        list.add("Staying healthy is hard. Being unhealthy is hard. Choose your hard.");
        list.add("Every human being is the author of his own health or disease.");
        list.add("It's never too early nor too late to work towards being the healthiest you.");
        list.add("Your body will be around much longer than that expensive handbag. Invest in yourself!");
        list.add("'I totally regret eating healthy today', said no-one ever.");
        list.add("An ounce of Prevention is worth a pound of Cure.");
        list.add("You are what you eat.");
        list.add("Health is not valued, till Sickness comes in");
    }

    public void generateQuote(View view) {

        Random rand = new Random();
        int num = rand.nextInt(10);
        String s = list.get(num);
        quote.setText(s);
    }



    public void calculateRes(){
        String strHeight = height.getText().toString();
        String strWeight = weight.getText().toString();

        if(strHeight != null && !"".equals(strHeight) && !"0".equals(strHeight) && strWeight != null && !"".equals(strWeight)&& !"0".equals(strWeight)){
            float fWeight = Float.parseFloat(strWeight);
            float fHeight = Float.parseFloat(strHeight);
            float bmi = (fWeight/(fHeight*fHeight))*10000;
            displayBMI(bmi);
        }

        else if("0".equals(strHeight) && !"0".equals(strWeight)) {
            comment = "C'mon! I'm sure you are taller than that!";
            result.setText(comment);
        }
        else if( "0".equals(strWeight)&& !"0".equals(strHeight)){
            comment = "Damn! And to think even vacuum has mass.";
            result.setText(comment);
        }
        else if("0".equals(strHeight)&& "0".equals(strWeight) ){
            comment ="Haha sure...Try again!";
            result.setText(comment);
        }
        else if("".equals(strWeight)|| "".equals(strHeight)){
            String comment ="Invalid details, try again";
            result.setText(comment);
        }
    }

    private void displayBMI(float bmi){
        String comment = "";
        if(bmi < 16.00){
            comment = "Severely underweight. A double cheese pizza and an avocado  milkshake, please!";
        }
        else if(bmi < 17.00){
            comment = "Moderately underweight. A cheese pizza, please!";
        }
        else if(bmi < 18.50){
            comment = "Mildly underweight. Almost there, but not quite!";
        }
        else if(bmi < 25.00){
            comment = "Normal. Perfect! You are doing it right.";
        }
        else if(bmi < 30.00){
            comment = "Pre-obese. Almost there, but not quite!";
        }
        else if(bmi < 35.00){
            comment = "Obese class-I. A healthy diet and good exercise goes a long way!";
        }
        else if(bmi < 40.00){
            comment = "Obese class-II. Leafy greens and brisk walking to the rescue!";
        }
        else if(bmi >= 40.00){
            comment = "Obese class-III. Celery juice and gymming to the rescue!";
        }
        bmi =  bmi*100;
        bmi = Math.round(bmi);
        bmi = bmi/100;

        comment = "Your BMI is " + bmi+ ". " + comment;
        myFont = Typeface.createFromAsset(this.getAssets(), "fonts/AlexBrush-Regular.ttf");
        result.setText(comment);
        result.setTypeface(myFont);

    }



}