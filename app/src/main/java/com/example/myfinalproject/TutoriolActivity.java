
    package com.example.myfinalproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


    public class TutoriolActivity extends AppCompatActivity {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tutorial);

            findViewById(R.id.nexttBtn).setOnClickListener(v->{
                Intent intent = new Intent(this,SplashActivity.class);
                startActivity(intent);
            });

            findViewById(R.id.skipptv).setOnClickListener(v->{
                Intent intent = new Intent(this,SplashActivity.class);
                startActivity(intent);

            });



        }

        }



