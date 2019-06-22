package com.example.shv.chatapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shv.chatapp.ChatList.ChatsFragment;
import com.example.shv.chatapp.FriendsList.FriendsFragment;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class HomeActivity extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(R.integer.notLogOut, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        TabLayout tabs = findViewById(R.id.chatListTabs);
        ViewPager viewPager = findViewById(R.id.chatListViewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ChatsFragment(), "Chats");
        viewPagerAdapter.addFragments(new FriendsFragment(), "Friends");

        viewPager.setAdapter(viewPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        Intent received = getIntent();
        final String token = received.getStringExtra("token");
        try {
            final Socket sock = IO.socket("http://" + ServerIP.IP+":8080");
            sock.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args){
                    try {
                        JSONObject jo = new JSONObject();
                        jo.put("token", token);
                        sock.emit("register_connection", jo);
                    }catch(Exception e) {}
                }
            }).on("message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    try {
                        Log.i("something","something ");
                        JSONObject obj = (JSONObject) args[0];
                        JSONArray messages = obj.getJSONArray("messages");
                        Log.i("LENGTH",""+messages.length());
                        for(int i = 0;i < messages.length();++i){
                            JSONObject message = messages.getJSONObject(i);
                            Log.i("print",message.getString("_id"));
                            Log.i("print",message.getString("from"));
                            Log.i("print",message.getString("message"));
                        }
                    }catch(Exception e){Log.e("JSON",e.getMessage());}
                }
            });
            sock.connect();
        }catch (Exception e){
            Log.e("Socket",e.getMessage());}
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

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragments(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
/*

    <android.support.v7.widget.RecyclerView
        android:id="@+id/chatListView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/toolbar" />
 */