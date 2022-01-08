package com.timvandergoten.beercollect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FoundBeerActivity extends AppCompatActivity {
    public static final String BEER = "beerName";
    Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_beer);
        Intent intent = getIntent();
        String beerName = intent.getStringExtra(BEER);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.beerName);
        textView.setText(beerName);

    }
}