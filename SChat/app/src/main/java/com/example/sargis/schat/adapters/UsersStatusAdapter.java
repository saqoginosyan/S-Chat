package com.example.sargis.schat.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.schat.R;
import com.example.sargis.schat.models.UsersModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersStatusAdapter extends RecyclerView.Adapter<UsersStatusAdapter.UsersStatusViewHolder> {

    private Context context;
    private List<UsersModel> list;

    public UsersStatusAdapter(Context context, List<UsersModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UsersStatusAdapter.UsersStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.status_user_item, parent, false);
        return new UsersStatusAdapter.UsersStatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersStatusAdapter.UsersStatusViewHolder holder, final int position) {
        final UsersModel usersStatusModel = list.get(position);
        holder.userStatusName.setText(usersStatusModel.getUserName());
        Picasso.get().load(usersStatusModel.getImageUrl()).into(holder.userStatusImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UsersStatusViewHolder extends RecyclerView.ViewHolder {
        private ImageView userStatusImg;
        private TextView userStatusName;

        UsersStatusViewHolder(View itemView) {
            super(itemView);
            userStatusImg = itemView.findViewById(R.id.user_status_img);
            userStatusName = itemView.findViewById(R.id.user_status_name);
        }
    }
}