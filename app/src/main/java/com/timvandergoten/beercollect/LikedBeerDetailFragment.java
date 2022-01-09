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


public class LikedBeerDetailFragment extends Fragment {
    Button nextFrag;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liked_beer_detail, container, false);
        toolbar = view.findViewById(R.id.toolbar2);
        ((ProfileActivity)getActivity()).setSupportActionBar(toolbar);
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