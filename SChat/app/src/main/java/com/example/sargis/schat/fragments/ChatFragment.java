package com.example.sargis.schat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sargis.schat.R;
import com.example.sargis.schat.adapters.UsersChatAdapter;
import com.example.sargis.schat.providers.UsersChatProvider;

public class ChatFragment extends Fragment {

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_chat, container, false);
        final RecyclerView usersList = view.findViewById(R.id.chat_recycler);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final UsersChatAdapter adapter =
                new UsersChatAdapter(getContext(), UsersChatProvider.getUsersList());
        usersList.setAdapter(adapter);

        return view;
    }
}
