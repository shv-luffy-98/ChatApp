package com.example.shv.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shv.chatapp.ChatList.ChatListAdapter;
import com.example.shv.chatapp.ChatList.ChatListItem;

import java.util.ArrayList;
import java.util.List;


public class ChatsList extends AppCompatActivity {
    public List<ChatListItem> chats;
    private RecyclerView chatList;
    private ChatListAdapter adapter;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(R.integer.notLogOut, intent);
        finish();
    }

    private void initChatList() {
        chats = new ArrayList<>();
        chats.add(new ChatListItem("Srikanth", "Bye"));
        chats.add(new ChatListItem("Srihari", "Hi"));
    }

    private void addAdapter() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        chatList = findViewById(R.id.chatListView);

        initChatList();
        addAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chatlistmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logOut();
                return true;
        }
        return false;
    }

    public void logOut() {
        Intent intent = new Intent();
        setResult(R.integer.LogOut, intent);
        finish();
    }
}
