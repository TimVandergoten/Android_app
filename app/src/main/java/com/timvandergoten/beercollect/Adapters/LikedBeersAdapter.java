package com.timvandergoten.beercollect.Adapters;

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
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.timvandergoten.beercollect.DetailBeerActivity;
import com.timvandergoten.beercollect.Models.LikedBeer;
import com.timvandergoten.beercollect.R;

import java.util.ArrayList;

public class LikedBeersAdapter extends RecyclerView.Adapter<LikedBeersAdapter.LikedBeerViewHolder> {
    private ArrayList<LikedBeer> listBeers = new ArrayList<>();
    private Context myContext;

    public LikedBeersAdapter(Context context, ArrayList<LikedBeer> beers) {
        myContext = context;
        listBeers = beers;
    }

    @NonNull
    @Override
    public LikedBeersAdapter.LikedBeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item_list_layout, parent, false);
        return new LikedBeersAdapter.LikedBeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LikedBeersAdapter.LikedBeerViewHolder holder, int position) {
        holder.bindBeers(listBeers.get(position),position);
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

        public LikedBeerViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.beerImageView);
            beerName = (TextView) itemView.findViewById(R.id.foundBeerName);
            tagLine = (TextView) itemView.findViewById(R.id.beerTagline);
            desc = (TextView) itemView.findViewById(R.id.beerDesc);
            ListItem = itemView.findViewById(R.id.beerItem);
        }


        public void bindBeers(LikedBeer beer, int position) {
            Picasso.get().load(beer.getImageUrl()).into(imageView); //put this in detail activity
            beerName.setText(beer.getName());
            tagLine.setText(beer.getTagline());
            desc.setText(beer.getDescription());
            ListItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO:change for fragments
                    Intent intent = new Intent(myContext, DetailBeerActivity.class);
                    intent.putExtra(DetailBeerActivity.ClICKEDBEER,listBeers.get(position));
                    myContext.startActivity(intent);
                }
            });
        }
    }

}