package com.example.shv.chatapp.FriendsList;

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
import com.example.shv.chatapp.Listeners.RecyclerTouchListener;
import com.example.shv.chatapp.R;

import java.util.ArrayList;
import java.util.List;


public class FriendsFragment extends Fragment {
    public List<User> friends;
    private RecyclerView friendsList;
    private FriendsListAdapter adapter;

    private void initFriendsList() {
        friends = new ArrayList<>();
        friends.add(new User("Srihari"));
        friends.add(new User("Srikanth"));
    }

    private void addAdapter() {
        friendsList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        adapter = new FriendsListAdapter(friends, getContext());
        friendsList.setAdapter(adapter);

        friendsList.setLayoutManager(new LinearLayoutManager(getContext()));
        friendsList.addOnItemTouchListener(new RecyclerTouchListener(getContext(), friendsList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(),
                        "No action found, opening chat",
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
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        friendsList = view.findViewById(R.id.friendsListView);
        initFriendsList();
        addAdapter();
        return view;
    }
}
