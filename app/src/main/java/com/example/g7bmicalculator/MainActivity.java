package com.example.g7bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrentheight;
    TextView mcurrentage, mcurrentweght;
    ImageView mincreamentage, mincreamentweight, mdecreamentweight, mdecreamentage;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;

    int intweight=55;
    int intage=22;
    int currentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="22";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweght=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincreamentage=findViewById(R.id.increamentage);
        mdecreamentage=findViewById(R.id.decreamentage);
        mincreamentweight=findViewById(R.id.increamentweight);
        mdecreamentweight=findViewById(R.id.decreamentweight);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });

//        seekbar java code starts here
        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentprogress=i;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
// seekbar java code ends here

//        increamentals for age
        mincreamentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage=intage + 1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecreamentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage=intage - 1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });
//        for age ends here

//        for weight starts here
        mincreamentweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight + 1;
                weight2=String.valueOf(intweight);
                mcurrentweght.setText(weight2);
            }
        });

        mdecreamentweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight - 1;
                weight2=String.valueOf(intweight);
                mcurrentweght.setText(weight2);
            }
        });
//        for weight ends here



        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                condition starts here
                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Yor Gender First", Toast.LENGTH_SHORT).show();
                }
                else if (mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Yor Height First", Toast.LENGTH_SHORT).show();
                }
                else if (intage==0 || intage<0){
                    Toast.makeText(getApplicationContext(), "Age is incorrect", Toast.LENGTH_SHORT).show();
                }
                else if (intweight==0 || intweight<0){
                    Toast.makeText(getApplicationContext(), "Weight is incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }
//          condition ends here



            }
        });



    }
}