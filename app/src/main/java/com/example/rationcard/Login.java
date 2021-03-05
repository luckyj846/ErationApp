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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
                    Toast.makeText(Login.this, "Enter Ration Card No", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   /* Toast.makeText(Login.this,et1.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(Login.this,Otp.class);
                    startActivity(i1);*/
                   String text = et1.getText().toString();
                    StringRequest request = new StringRequest(Request.Method.GET, "http://13.233.150.190:8080/api/ration/get/getByRation/" + text, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    queue.add(request);
                }

            }
        });


    }

}
