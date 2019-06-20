package com.example.shv.chatapp.ChatList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shv.chatapp.ChatActivity;
import com.example.shv.chatapp.R;
import com.example.shv.chatapp.Listeners.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {
    public List<ChatListItem> chats;
    private RecyclerView chatList;
    private ChatListAdapter adapter;

    private void initChatList() {
        chats = new ArrayList<>();
        chats.add(new ChatListItem("Srikanth", "Bye"));
        chats.add(new ChatListItem("Srihari", "Hi"));
    }

    private void addAdapter() {
        chatList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        adapter = new ChatListAdapter(getContext(), chats);
        chatList.setAdapter(adapter);

        chatList.setLayoutManager(new LinearLayoutManager(getContext()));
        chatList.addOnItemTouchListener(new RecyclerTouchListener(getContext(), chatList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(),
                        ChatsFragment.this.chats.get(position).getUname() + "'s chats not found",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(getContext(), ChatActivity.class);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        chatList = view.findViewById(R.id.chatListView);
        initChatList();
        addAdapter();
        return view;
    }
}
