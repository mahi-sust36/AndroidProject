package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chattingapp.databinding.ActivitySignUpBinding;

public class signUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
    }
}