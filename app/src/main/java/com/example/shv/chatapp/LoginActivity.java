package com.example.shv.chatapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

import com.example.shv.chatapp.ChatList.ChatListItem;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");

        ChatListItem.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.user);
        username = findViewById(R.id.logInUserName);
        password = findViewById(R.id.logInPassword);
        logInButton = findViewById(R.id.logInButton);
    }

    public void logInClick(View v) {
        Intent i = new Intent(getApplicationContext(), ChatsList.class);
        startActivityForResult(i, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0) && resultCode == R.integer.notLogOut)
            finish();
    }
}
