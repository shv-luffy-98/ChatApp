package com.example.shv.chatapp.FriendsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shv.chatapp.R;

public class FriendViewHolder extends RecyclerView.ViewHolder {
    TextView username;
    ImageView userImage;

    public FriendViewHolder(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.userName);
        userImage = itemView.findViewById(R.id.userImage);
    }
}
