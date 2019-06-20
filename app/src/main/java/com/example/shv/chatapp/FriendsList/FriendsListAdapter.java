package com.example.shv.chatapp.FriendsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shv.chatapp.ChatList.ChatListItem;
import com.example.shv.chatapp.ChatList.ChatListItemViewHolder;
import com.example.shv.chatapp.R;

import java.util.List;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendViewHolder> {
    List<User> friends;
    Context context;

    public FriendsListAdapter(List<User> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.frienditem, parent, false);
        return (new FriendViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final FriendViewHolder viewHolder, final int position) {
        User item = friends.get(position);
        viewHolder.username.setText(item.getUname());
        viewHolder.userImage.setImageBitmap(item.getImage());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
