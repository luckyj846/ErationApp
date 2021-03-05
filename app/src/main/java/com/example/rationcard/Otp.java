package com.example.rationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {

    TextView timer;
    EditText et1,et2,et3,et4;
    TextView resend;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        timer =(TextView) findViewById(R.id.textView10);
        et1=(EditText) findViewById(R.id.editText2);
        et2=(EditText)findViewById(R.id.editText3);
        et3=(EditText)findViewById(R.id.editText4);
        verify=(Button) findViewById(R.id.button3);
        resend=(TextView)findViewById(R.id.textView12);


        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (et1.getText().length()==1)
                {
                    et2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (et2.getText().length()==1)
                {
                    et3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (et3.getText().length()==1)
                {
                    et4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Otp.this,Dashboard.class);
                startActivity(i);
            }
        });

        long duration = TimeUnit.MINUTES.toMillis(2);

        new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                timer.setText(sDuration);
            }

            @Override
            public void onFinish()
            {
                timer.setText("OTP Expired");
            }
        }.start();

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

    }
}
