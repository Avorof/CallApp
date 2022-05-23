package com.example.callapp;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import timber.log.Timber;

public class urok1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urok1);

        Intent intent = getIntent();
        String string = intent.getStringExtra(EXTRA_MESSAGE);
        Timber.d(string);
    }
}