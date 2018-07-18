package com.example.sargis.schat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sargis.schat.OneUserActivity;
import com.example.sargis.schat.R;
import com.example.sargis.schat.models.UsersModel;
import com.example.sargis.schat.providers.UsersChatProvider;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoFragment extends Fragment {

    public InfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(OneUserActivity.INFO_KEY);
            final UsersModel user = UsersChatProvider.getUserByPosition(userPosition);
            final TextView textView = view.findViewById(R.id.info_name);
            textView.setText(user.getUserName());
            final TextView birthDay = view.findViewById(R.id.birthDay);
            birthDay.setText(user.getUserInfo());
            final CircleImageView imageView = view.findViewById(R.id.info_img);
            Picasso.get().load(user.getImageUrl()).into(imageView);
        }
        return view;
    }
}
