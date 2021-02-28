package com.example.rationcard;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

    public class Home extends Activity implements View.OnClickListener {

        Button next;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);
            next=(Button) findViewById(R.id.button);
            next.setOnClickListener(this);
                      }

        @Override
        public void onClick(View v) {
            Intent i=new Intent(Home.this,Login.class);
            startActivity(i);
        }
    }
