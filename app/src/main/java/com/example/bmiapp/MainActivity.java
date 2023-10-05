package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout1;
    TextView textView1,textView2,textIntent;
    EditText editText1,editText2,editText3;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout1=findViewById(R.id.linearLayout1);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textIntent=findViewById(R.id.textIntent);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        button1=findViewById(R.id.button1);

        Bundle bundle=getIntent().getExtras();
        String s1=bundle.getString("str");
        if (!s1.equals("")){
            textIntent.setText(s1);
        }

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    int wet=Integer.parseInt(editText1.getText().toString());
                    int ft=Integer.parseInt(editText2.getText().toString());
                    int in=Integer.parseInt(editText3.getText().toString());

                    int totalIn=ft*12+in;
                    double totalCm=totalIn*2.54;
                    double totalM=totalCm/100;
                    double bmi=wet/(totalM*totalM);
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    String formattedNumber = decimalFormat.format(bmi);
                    if(bmi>25){
                        textView1.setText("OVER WEIGHT:");
                        textView2.setText(formattedNumber);
                        linearLayout1.setBackgroundColor(getResources().getColor(R.color.colorOw));
                    }else if(bmi<18){
                        textView1.setText("UNDER WEIGHT:");
                        textView2.setText(formattedNumber);
                        linearLayout1.setBackgroundColor(getResources().getColor(R.color.colorUw));
                    }else{
                        textView1.setText("NORMAL WEIGHT:");
                        textView2.setText(formattedNumber);
                        linearLayout1.setBackgroundColor(getResources().getColor(R.color.colorNw));
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid Value",Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}