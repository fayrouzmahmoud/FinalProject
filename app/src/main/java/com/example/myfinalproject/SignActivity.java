package com.example.myfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignActivity extends AppCompatActivity {

    EditText emailEt , passwordEt;
    Button signBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null)
        {
            Intent intent = new Intent(SignActivity.this , NoteActivity.class);
            startActivity(intent);
        }

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        signBtn = findViewById(R.id.signBtn);
        signBtn.setOnClickListener(v->{
            doSignUp(emailEt.getText().toString() , passwordEt.getText().toString());
        });

    }

    private void doSignUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();

                        Intent intent = new Intent(SignActivity.this , NoteActivity.class);
                        startActivity(intent);


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(SignActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                });


    }
}
