package com.example.myfinalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity  extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null)
        {
            Intent intent = new Intent(SplashActivity.this , NoteActivity.class);
            startActivity(intent);
        }
        else {
            findViewById(R.id.loginBtn).setOnClickListener(v -> {
                Intent intent = new Intent(this, loginActivity.class);
                startActivity(intent);

            });

            findViewById(R.id.signBtn).setOnClickListener(v -> {
                Intent intent = new Intent(this, SignActivity.class);
                startActivity(intent);

            });

        }
    }
}
