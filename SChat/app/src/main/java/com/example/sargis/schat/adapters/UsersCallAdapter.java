package com.example.sargis.schat.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sargis.schat.OneUserActivity;
import com.example.sargis.schat.R;
import com.example.sargis.schat.models.UsersModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersCallAdapter extends RecyclerView.Adapter<UsersCallAdapter.UsersCallViewHolder> {

    private Context context;
    private List<UsersModel> list;
    public static final String POSITION_KEY1 = "my key1";
    public static final String CHECK_KEY = "check key";

    public UsersCallAdapter(Context context, List<UsersModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UsersCallAdapter.UsersCallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.user_call_item, parent, false);
        return new UsersCallAdapter.UsersCallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersCallAdapter.UsersCallViewHolder holder, final int position) {
        final UsersModel model = list.get(position);
        holder.userCallName.setText(model.getUserName());
        holder.userCallNumber.setText(model.getUserNumber());
        holder.userEmail.setText(model.getUserEmail());
        Picasso.get().load(model.getImageUrl()).into(holder.userCallImg);

        holder.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + model.getUserNumber()));
                context.startActivity(callIntent);
            }
        });

        holder.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + model.getUserEmail()));
                context.startActivity(Intent.createChooser(emailIntent, "Send Mail"));
            }
        });

        holder.userCallImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OneUserActivity.class);
                intent.putExtra(POSITION_KEY1, position);
                intent.putExtra(CHECK_KEY, "check2");
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UsersCallViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView userCallImg;
        private TextView userCallName;
        private TextView userCallNumber;
        private TextView userEmail;
        private ImageButton callBtn;
        private ImageButton emailBtn;

        UsersCallViewHolder(final View itemView) {
            super(itemView);
            userCallImg = itemView.findViewById(R.id.users_call_img);
            userCallName = itemView.findViewById(R.id.users_call_name);
            userCallNumber = itemView.findViewById(R.id.users_call_number);
            userEmail = itemView.findViewById(R.id.users_email);
            callBtn = itemView.findViewById(R.id.call_button);
            emailBtn = itemView.findViewById(R.id.email_button);

        }
    }
}
