package com.timvandergoten.beercollect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class DetailBeerActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_beer);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }
}