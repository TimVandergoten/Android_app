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
    private Button nextFrag;
    private ArrayList<LikedBeer>foundLikedBeers;
    private LikedBeersAdapter likedBeersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liked_beers, container, false);
        toolbar = view.findViewById(R.id.toolbar2);
        ((ProfileActivity)getActivity()).setSupportActionBar(toolbar);
        nextFrag = (Button) view.findViewById(R.id.nextBtn);
        initFoundBeerList(view,getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        nextFrag = view.findViewById(R.id.nextBtn);
        nextFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_likedBeersFragment_to_likedBeerDetailFragment);
            }
        });
    }

    private void initFoundBeerList(View view, Context context) {
        foundLikedBeers = (ArrayList<LikedBeer>) DatabaseHelper.getInstance(context).likedBeerDao().getAll();
        likedBeersAdapter = new LikedBeersAdapter(context,foundLikedBeers);
        RecyclerView recyclerView = view.findViewById(R.id.LikedBeersRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(likedBeersAdapter);
    }
}