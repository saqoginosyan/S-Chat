package com.example.sargis.schat.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sargis.schat.fragments.InfoFragment;
import com.example.sargis.schat.OneUserActivity;
import com.example.sargis.schat.R;
import com.example.sargis.schat.models.MessageModel;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MessageModel> messagesList;
    private String userImgUrl;

    public MessageAdapter(Context context, List<MessageModel> messagesList, String userImgUrl) {
        this.context = context;
        this.messagesList = messagesList;
        this.userImgUrl = userImgUrl;
    }

    @Override
    public int getItemViewType(int position) {
        final MessageModel model = messagesList.get(position);
        if (model.isMine()) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            view = inflater.inflate(R.layout.send_message, parent, false);
            return new SendViewHolder(view);
        }
        view = inflater.inflate(R.layout.receive_message, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel model = messagesList.get(position);
        if (model.isMine()) {
            ((SendViewHolder) holder).bind(model);
            String sendDate = new SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(new Date());
            ((SendViewHolder) holder).sendTime.setText(sendDate);

        } else {
            ((ReceiveViewHolder) holder).bind(model);
            String receiveDate = new SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(new Date());
            ((ReceiveViewHolder) holder).receiveTime.setText(receiveDate);
        }
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class SendViewHolder extends RecyclerView.ViewHolder {
        TextView myTxt;
        TextView sendTime;

        SendViewHolder(View itemView) {
            super(itemView);
            myTxt = itemView.findViewById(R.id.send_text);
            sendTime = itemView.findViewById(R.id.send_time);
        }

        void bind(MessageModel messageModel) {
            myTxt.setText(messageModel.getMessage());
        }
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {
        CircleImageView receiveImg;
        TextView receiveTxt;
        TextView receiveTime;

        ReceiveViewHolder(View itemView) {
            super(itemView);
            receiveImg = itemView.findViewById(R.id.receive_img);
            receiveTxt = itemView.findViewById(R.id.receive_text);
            receiveTime = itemView.findViewById(R.id.receive_time);
            final int position = ((OneUserActivity) context).getIntent().getIntExtra(UsersChatAdapter.POSITION_KEY, 0);

            receiveImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InfoFragment infoFragment = new InfoFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(OneUserActivity.INFO_KEY, position);
                    infoFragment.setArguments(bundle);
                    ((OneUserActivity) context)
                            .getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, infoFragment).commit();
                }
            });
        }

        void bind(MessageModel messageModel) {
            Picasso.get().load(userImgUrl).into(receiveImg);
            receiveTxt.setText(messageModel.getMessage());
        }

    }
}
