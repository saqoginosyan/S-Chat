package com.example.sargis.schat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.schat.OneUserActivity;
import com.example.sargis.schat.R;
import com.example.sargis.schat.models.UsersModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersChatAdapter extends RecyclerView.Adapter<UsersChatAdapter.UsersViewHolder> {
    private Context context;
    private List<UsersModel> list;
    public static final String POSITION_KEY = "my key";
    public static final String CHECK_KEY = "check key";

    public UsersChatAdapter(Context context, List<UsersModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.users_chat_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, final int position) {
        final UsersModel usersChatModel = list.get(position);
        holder.userName.setText(usersChatModel.getUserName());
        holder.userStatus.setText(usersChatModel.getUserStatus());
        Picasso.get().load(usersChatModel.getImageUrl()).into(holder.userImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OneUserActivity.class);
                intent.putExtra(POSITION_KEY, position);
                intent.putExtra(CHECK_KEY, "check1");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userName;
        private TextView userStatus;

        UsersViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.users_chat_img);
            userName = itemView.findViewById(R.id.users_chat_name);
            userStatus = itemView.findViewById(R.id.users_chat_status);
        }
    }
}
