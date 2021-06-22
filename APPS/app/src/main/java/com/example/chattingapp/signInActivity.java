package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chattingapp.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInActivity extends AppCompatActivity {
    ActivitySignInBinding binding ;
    ProgressDialog progressDialog ;
    FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());

        getSupportActionBar().hide() ;

        auth = FirebaseAuth.getInstance() ;

        progressDialog = new ProgressDialog(signInActivity.this) ;
        progressDialog.setTitle("Loging account");
        progressDialog.setMessage("Loging to your account ");

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            progressDialog.show() ;
            auth.signInWithEmailAndPassword(binding.etEmail.getText().toString() , binding.etPassword.getText().toString()).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if( task.isSuccessful())
                            {
                                Intent intent = new Intent(signInActivity.this ,MainActivity.class);
                                startActivity(intent);
                            }else
                            {
                                Toast.makeText(signInActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });
        binding.tvclickSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signInActivity.this ,signUpActivity.class);
                startActivity(intent);
            }
        });
        if(auth.getCurrentUser() != null)
        {
            Intent intent = new Intent(signInActivity.this ,MainActivity.class);
            startActivity(intent);
        }
    }
}