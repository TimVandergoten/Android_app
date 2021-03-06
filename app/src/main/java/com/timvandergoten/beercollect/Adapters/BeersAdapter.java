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
import com.timvandergoten.beercollect.Models.Beer;
import com.timvandergoten.beercollect.R;

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
        holder.bindBeers(listBeers.get(position),position);
    }

    @Override
    public int getItemCount() {
        return listBeers.size();
    }

    public class BeerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView beerName;
        TextView tagLine;
        TextView desc;
        LinearLayout ListItem;

        public BeerViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.beerImageView);
            beerName = (TextView) itemView.findViewById(R.id.foundBeerName);
            tagLine = (TextView) itemView.findViewById(R.id.beerTagline);
            desc = (TextView) itemView.findViewById(R.id.beerDesc);
            ListItem = itemView.findViewById(R.id.beerItem);
        }


        public void bindBeers(Beer beer, int position) {
            Picasso.get().load(beer.getImageUrl()).into(imageView); //put this in detail activity
            beerName.setText(beer.getName());
            tagLine.setText(beer.getTagline());
            desc.setText(beer.getDescription());
            ListItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(myContext, DetailBeerActivity.class);
                    intent.putExtra(DetailBeerActivity.ClICKEDBEER,listBeers.get(position));
                    myContext.startActivity(intent);
                }
            });
        }
    }

}
