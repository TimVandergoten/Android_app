package com.timvandergoten.beercollect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    android.widget.SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        searchView = findViewById(R.id.searchBeer);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Context context = searchView.getContext();
                Intent intent = new Intent(context, FoundBeerActivity.class);
                intent.putExtra(FoundBeerActivity.BEER, query);
                context.startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemProfile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}