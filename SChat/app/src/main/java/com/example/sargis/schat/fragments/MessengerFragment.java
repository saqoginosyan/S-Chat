package com.example.sargis.schat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.schat.OneUserActivity;
import com.example.sargis.schat.R;
import com.example.sargis.schat.adapters.MessageAdapter;
import com.example.sargis.schat.models.MessageModel;
import com.example.sargis.schat.models.UsersModel;
import com.example.sargis.schat.providers.UsersChatProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MessengerFragment extends Fragment {


    public MessengerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messenger, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(OneUserActivity.MESSENGER_KEY);
            final UsersModel user = UsersChatProvider.getUserByPosition(userPosition);
            final TextView textView = view.findViewById(R.id.message_title_name);
            textView.setText(user.getUserName());
            final ImageView imageView = view.findViewById(R.id.message_title_img);
            Picasso.get().load(user.getImageUrl()).into(imageView);
            initializeMessagesList(view, user);
        }
        return view;
    }

    private void initializeMessagesList(View view, UsersModel user) {

        final RecyclerView messagesList = view.findViewById(R.id.message_recycler);
        messagesList.setHasFixedSize(true);

        final LinearLayoutManager manager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        messagesList.setLayoutManager(manager);
        final List<MessageModel> messages = user.getMessages();
        final MessageAdapter adapter = new MessageAdapter(getContext(), messages, user.getImageUrl());
        messagesList.setAdapter(adapter);

        final EditText editText = view.findViewById(R.id.enter_message);
        final ImageButton send = view.findViewById(R.id.send_button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(new MessageModel(editText.getText().toString(), true));
                messages.add(new MessageModel("Zbaxvac em kgrem", false));
                adapter.notifyDataSetChanged();
                editText.setText("");
                messagesList.scrollToPosition(messages.size() - 1);
            }
        });
    }
}
