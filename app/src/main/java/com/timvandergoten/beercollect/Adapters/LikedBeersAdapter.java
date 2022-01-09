package com.timvandergoten.beercollect.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.timvandergoten.beercollect.DetailBeerActivity;
import com.timvandergoten.beercollect.LikedBeersFragmentDirections;
import com.timvandergoten.beercollect.Models.LikedBeer;
import com.timvandergoten.beercollect.R;

import java.util.ArrayList;

public class LikedBeersAdapter extends RecyclerView.Adapter<LikedBeersAdapter.LikedBeerViewHolder> {
    private ArrayList<LikedBeer> listBeers = new ArrayList<>();
    private Context myContext;
    private final NavController navController;

    public LikedBeersAdapter(Context context, ArrayList<LikedBeer> beers,NavController navController) {
        myContext = context;
        listBeers = beers;
        this.navController = navController;

    }

    @NonNull
    @Override
    public LikedBeersAdapter.LikedBeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item_list_layout, parent, false);
        return new LikedBeersAdapter.LikedBeerViewHolder(view ,navController);
    }

    @Override
    public void onBindViewHolder(LikedBeersAdapter.LikedBeerViewHolder holder, int position) {
        holder.bindBeers(listBeers.get(position));
    }

    @Override
    public int getItemCount() {
        return listBeers.size();
    }

    public class LikedBeerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView beerName;
        TextView tagLine;
        TextView desc;
        LinearLayout ListItem;
        NavController navController;

        public LikedBeerViewHolder(View itemView,NavController navController) {
            super(itemView);
            this.navController = navController;
            imageView = itemView.findViewById(R.id.beerImageView);
            beerName = (TextView) itemView.findViewById(R.id.foundBeerName);
            tagLine = (TextView) itemView.findViewById(R.id.beerTagline);
            desc = (TextView) itemView.findViewById(R.id.beerDesc);
            ListItem = itemView.findViewById(R.id.beerItem);
        }


        public void bindBeers(LikedBeer beer) {
            Picasso.get().load(beer.getImageUrl()).into(imageView); //put this in detail activity
            beerName.setText(beer.getName());
            tagLine.setText(beer.getTagline());
            desc.setText(beer.getDescription());
            ListItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavDirections direction = LikedBeersFragmentDirections.actionLikedBeersFragmentToLikedBeerDetailFragment(beer);
                    navController.navigate(direction);
                }
            });
        }
    }

}