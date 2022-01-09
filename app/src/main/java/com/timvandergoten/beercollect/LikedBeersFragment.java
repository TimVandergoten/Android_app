package com.timvandergoten.beercollect;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.timvandergoten.beercollect.Adapters.BeersAdapter;
import com.timvandergoten.beercollect.Adapters.LikedBeersAdapter;
import com.timvandergoten.beercollect.Database.DatabaseHelper;
import com.timvandergoten.beercollect.Models.LikedBeer;

import java.util.ArrayList;
import java.util.List;

public class LikedBeersFragment extends Fragment {
    Toolbar toolbar;
    private ArrayList<LikedBeer>foundLikedBeers;
    private LikedBeersAdapter likedBeersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liked_beers, container, false);
        toolbar = view.findViewById(R.id.toolbar2);
        ((ProfileActivity)getActivity()).setSupportActionBar(toolbar);
        foundLikedBeers = (ArrayList<LikedBeer>) DatabaseHelper.getInstance(getContext()).likedBeerDao().getAll();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        initFoundBeerList(view,getContext(),navController);

    }

    private void initFoundBeerList(View view, Context context,NavController navController) {
        likedBeersAdapter = new LikedBeersAdapter(context,foundLikedBeers,navController);
        RecyclerView recyclerView = view.findViewById(R.id.LikedBeersRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(likedBeersAdapter);
    }
}