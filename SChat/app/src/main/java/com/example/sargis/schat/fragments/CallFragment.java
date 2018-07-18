package com.example.sargis.schat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sargis.schat.R;
import com.example.sargis.schat.adapters.UsersCallAdapter;
import com.example.sargis.schat.providers.UsersChatProvider;

public class CallFragment extends Fragment {

    public CallFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_call, container, false);
        final RecyclerView usersCallList = view.findViewById(R.id.call_recycler);
        usersCallList.setHasFixedSize(true);
        usersCallList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final UsersCallAdapter adapter =
                new UsersCallAdapter(getContext(), UsersChatProvider.getUsersList());
        usersCallList.setAdapter(adapter);

        return view;
    }
}
