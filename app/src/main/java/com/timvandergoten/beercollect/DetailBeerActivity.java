package com.timvandergoten.beercollect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.timvandergoten.beercollect.Database.DatabaseHelper;
import com.timvandergoten.beercollect.Models.Beer;
import com.timvandergoten.beercollect.Models.LikedBeer;

import java.util.ArrayList;
import java.util.List;

public class DetailBeerActivity extends AppCompatActivity {
    public static final String ClICKEDBEER = "clickedBeer";
    Toolbar toolbar;
    Beer beer;
    TextView name;
    TextView tagLine;
    TextView desc;
    TextView comment;
    Button addBtn;
    ImageView background;
    ArrayList<LikedBeer> likedBeers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_beer);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        Intent mIntent = getIntent();
        beer = (Beer) mIntent.getParcelableExtra(ClICKEDBEER);
        name = findViewById(R.id.detailBeerName);
        name.setText(beer.getName());
        tagLine = findViewById(R.id.tagLineDetail);
        tagLine.setText(beer.getTagline());
        desc=findViewById(R.id.descriptionDetail);
        desc.setText(beer.getDescription());
        background = findViewById(R.id.beerImg);
        Picasso.get().load(beer.getImageUrl()).into(background);
        comment = findViewById(R.id.FoundBeerComment);
        addBtn = findViewById(R.id.addBeerBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LikedBeer newLikedbeer = new LikedBeer(beer.getBeerId(), beer.getName(),beer.getTagline(),beer.getDescription(),beer.getImageUrl(), (String) comment.getText());
                if (DatabaseHelper.getInstance(DetailBeerActivity.this).likedBeerDao().loadByBeerId(beer.getBeerId()).isEmpty()) {
                    AddBeer(newLikedbeer);
                    Toast.makeText(DetailBeerActivity.this,R.string.succes,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DetailBeerActivity.this,R.string.allready,Toast.LENGTH_SHORT).show();
                }

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
    public void AddBeer(LikedBeer beer) {
        DatabaseHelper.getInstance(this).likedBeerDao().insertAll(beer);
    }
}