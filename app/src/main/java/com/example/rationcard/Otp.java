package com.example.rationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {

    TextView timer;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        timer =(TextView) findViewById(R.id.textView10);
        verify=(Button) findViewById(R.id.button3);

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

            }
        }.start();

    }
}
