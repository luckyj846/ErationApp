package com.example.rationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText et1;
    Button submit;
    TextView Goback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1=(EditText)findViewById(R.id.editText);
        submit=(Button) findViewById(R.id.button2);
        Goback=(TextView) findViewById(R.id.textView7);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Home.class);
                startActivity(i);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(et1.getText().toString()))
                {
                    Toast.makeText(Login.this, "Enter Ration No", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this,et1.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(Login.this,Otp.class);
                    startActivity(i1);
                }

            }
        });


    }

}
