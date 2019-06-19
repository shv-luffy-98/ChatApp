package com.example.shv.chatapp.ChatList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shv.chatapp.R;

import java.util.Collections;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListItemViewHolder> {
    List<ChatListItem> items;
    Context context;

    public ChatListAdapter(Context context, List<ChatListItem> listItems) {
        items = listItems;
        this.context = context;
    }

    @Override
    public ChatListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.chatlistitem, parent, false);
        return (new ChatListItemViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final ChatListItemViewHolder viewHolder, final int position) {
        ChatListItem item = items.get(position);
        viewHolder.username.setText(item.getUname());
        viewHolder.lastMessage.setText(item.getLastMessage());
        viewHolder.userImage.setImageBitmap(item.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
