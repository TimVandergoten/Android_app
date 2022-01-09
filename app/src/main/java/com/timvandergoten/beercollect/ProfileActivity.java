package com.timvandergoten.beercollect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProfileActivity extends AppCompatActivity {
    Fragment LikedBeers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemSbeer) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
    /*private void setupPager(ViewPager2 viewPager2){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager(),getLifecycle());
        adapter.addFragment(new LikedBeersFragment(),ProfileActivity.this.getResources().getString(R.string.fragtitleList));
        adapter.addFragment(new LikedBeerDetailFragment(),ProfileActivity.this.getResources().getString(R.string.fragTitleDetail));
        viewPager2.setAdapter(adapter);
    }
    public void setViewPager2(int fragNum){
        viewPager2.setCurrentItem(fragNum);
    }*/


}