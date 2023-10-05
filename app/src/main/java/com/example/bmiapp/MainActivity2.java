package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {
    TextInputLayout name_lay,email_lay,pass_lay,conf_lay;
    EditText name_reg,email_reg,pass_reg,confirmPass_reg;
    Button register;
    TextView already_ac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name_lay=findViewById(R.id.textInputName);
        email_lay=findViewById(R.id.textInputEmail);
        pass_lay=findViewById(R.id.textInputPassword);
        conf_lay=findViewById(R.id.textInputConfirmPassword);


        name_reg=findViewById(R.id.editTextName);
        email_reg=findViewById(R.id.editTextEmail);
        pass_reg=findViewById(R.id.editTextPassword);
        confirmPass_reg=findViewById(R.id.editTextConfirmPassword);

        register=findViewById(R.id.cirRegisterButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=name_reg.getText().toString();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("str",name);
                startActivity(intent);
            }
        });
    }
}