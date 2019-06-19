package com.example.shv.chatapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.shv.chatapp.ChatList.ChatListAdapter;
import com.example.shv.chatapp.ChatList.ChatListItem;

import java.util.ArrayList;
import java.util.List;

public class ChatsList extends Activity {
    public List<ChatListItem> chats;
    private RecyclerView chatList;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);

        chats = new ArrayList<>();
        chats.add(new ChatListItem("Srikanth", "Bye"));
        chats.add(new ChatListItem("Srihari", "Hi"));
        chatList = findViewById(R.id.chatListView);
        chatList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new ChatListAdapter(getApplication(), chats);
        chatList.setAdapter(adapter);
        chatList.setLayoutManager(new LinearLayoutManager(ChatsList.this));
        chatList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), chatList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), ChatsList.this.chats.get(position).getUname() + "'s chats not found", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
