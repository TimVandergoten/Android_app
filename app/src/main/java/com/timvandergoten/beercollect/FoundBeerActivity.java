package com.timvandergoten.beercollect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.timvandergoten.beercollect.Adapters.BeersAdapter;
import com.timvandergoten.beercollect.Models.Beer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
public class FoundBeerActivity extends AppCompatActivity{
    public static final String BEER = "beerName";
    Toolbar toolbar;
    ArrayList<Beer> foundBeers;
    Handler FoundBeerHandler = new Handler();
    ProgressDialog progressDialog;
    BeersAdapter beerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_beer);
        Intent intent = getIntent();
        String beerName = intent.getStringExtra(BEER);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        initFoundBeerList();
        new fetchData(beerName).start();
    }

    private void initFoundBeerList() {
        foundBeers = new ArrayList<>();
        beerArrayAdapter = new BeersAdapter(this,foundBeers);
        RecyclerView recyclerView = findViewById(R.id.foundBierList);
        recyclerView.setLayoutManager(new LinearLayoutManager(FoundBeerActivity.this));
        recyclerView.setAdapter(beerArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSbeer:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.itemProfile:
                Intent intent2 = new Intent(this,ProfileActivity.class);
                startActivity(intent2);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class fetchData extends Thread{
        String data ="";
        String beerName;
        public fetchData(String name){
            beerName = name;
        }
        @Override
        public void run() {
            FoundBeerHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(FoundBeerActivity.this);
                    progressDialog.setMessage(FoundBeerActivity.this.getResources().getString(R.string.progress_message));
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });

            try {
                String uriString = "https://api.punkapi.com/v2/beers?beer_name="+beerName;
                URL url = new URL(uriString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = bufferedReader.readLine())!=null){
                    data = data +line;
                }
                if (!data.isEmpty()){
                    foundBeers.clear();

                    JSONArray beers = new JSONArray(data);
                    for (int i = 0;i<beers.length();i++){
                        JSONObject object = beers.getJSONObject(i);
                        Beer beer = new Beer(object.getInt("id") ,object.getString("name"),object.getString("tagline"),object.getString("description"),object.getString("image_url"));
                        foundBeers.add(beer);
                    }

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            FoundBeerHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                    beerArrayAdapter.notifyDataSetChanged();
                }
            });

        }
    }
}