package com.example.shv.chatapp.ChatList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shv.chatapp.R;

public class ChatListItemViewHolder extends RecyclerView.ViewHolder {
    TextView username, lastMessage;
    ImageView userImage;

    public ChatListItemViewHolder(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.userName);
        lastMessage = itemView.findViewById(R.id.lastMessage);
        userImage = itemView.findViewById(R.id.userImage);
    }
}
