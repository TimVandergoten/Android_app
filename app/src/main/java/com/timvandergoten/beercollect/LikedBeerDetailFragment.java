package com.timvandergoten.beercollect;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.timvandergoten.beercollect.Models.LikedBeer;


public class LikedBeerDetailFragment extends Fragment {
    Button nextFrag;
    Toolbar toolbar;
    LikedBeer likedBeer;
    TextView name;
    TextView tagLine;
    TextView desc;
    TextView comment;
    ImageView background;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liked_beer_detail, container, false);
        toolbar = view.findViewById(R.id.toolbar2);
        ((ProfileActivity)getActivity()).setSupportActionBar(toolbar);
        assert getArguments() != null;
        likedBeer = LikedBeerDetailFragmentArgs.fromBundle(getArguments()).getLikedBeer();
        name = view.findViewById(R.id.detailLBeerName);
        name.setText(likedBeer.getName());
        tagLine = view.findViewById(R.id.tagLineLDetail);
        tagLine.setText(likedBeer.getTagline());
        desc=view.findViewById(R.id.descriptionLDetail);
        desc.setText(likedBeer.getDescription());
        background = view.findViewById(R.id.beerLikedImg);
        Picasso.get().load(likedBeer.getImageUrl()).into(background);
        comment = view.findViewById(R.id.FoundLikedBeerComment);
        comment.setText(likedBeer.getComment());
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        nextFrag = view.findViewById(R.id.prevBtn);
        nextFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.likedBeersFragment,true).build();
                navController.navigate(R.id.action_likedBeerDetailFragment_to_likedBeersFragment,null,navOptions);
            }
        });
    }
}