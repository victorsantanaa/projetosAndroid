package com.jamalicia.entregasquebrada.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jamalicia.entregasquebrada.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirAutenticacao();

            }
        }, 3000);
    }

    private void abrirAutenticacao() {
        Intent intent = new Intent(SplashActivity.this, AutenticacaoActivity.class);
        startActivity(intent);
        finish();
    }
}