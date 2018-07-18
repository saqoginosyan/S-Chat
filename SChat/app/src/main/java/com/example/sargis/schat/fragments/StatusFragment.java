package com.example.sargis.schat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sargis.schat.R;
import com.example.sargis.schat.providers.UsersChatProvider;
import com.example.sargis.schat.adapters.UsersStatusAdapter;

public class StatusFragment extends Fragment {

    public StatusFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_status, container, false);
        final RecyclerView usersStatusList = view.findViewById(R.id.status_recycler);
        usersStatusList.setHasFixedSize(true);
        usersStatusList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final UsersStatusAdapter adapter =
                new UsersStatusAdapter(getContext(), UsersChatProvider.getUsersList());
        usersStatusList.setAdapter(adapter);

        return view;
    }
}