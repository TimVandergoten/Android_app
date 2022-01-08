package com.timvandergoten.beercollect.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.timvandergoten.beercollect.Models.Beer;
import com.timvandergoten.beercollect.R;

import java.net.URI;
import java.util.ArrayList;

public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeerViewHolder> {
    private ArrayList<Beer> listBeers = new ArrayList<>();
    private Context myContext;

    public BeersAdapter(Context context, ArrayList<Beer> beers) {
        myContext = context;
        listBeers = beers;
    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item_list_layout, parent, false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, int position) {
        holder.bindBeers(listBeers.get(position));
    }

    @Override
    public int getItemCount() {
        return listBeers.size();
    }

    public static class BeerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView beerName;
        TextView tagLine;
        TextView desc;

        public BeerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.beerImageView);
            beerName = (TextView) itemView.findViewById(R.id.foundBeerName);
            tagLine = (TextView) itemView.findViewById(R.id.beerTagline);
            desc = (TextView) itemView.findViewById(R.id.beerDesc);
        }


        public void bindBeers(Beer beer) {
            Picasso.get().load(beer.getImageUrl()).into(imageView); //put this in detail activity
            beerName.setText(beer.getName());
            tagLine.setText(beer.getTagline());
            desc.setText(beer.getDescription());
        }
    }
}
