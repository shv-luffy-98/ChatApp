package com.example.shv.chatapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shv.chatapp.ChatList.ChatListItem;
import com.example.shv.chatapp.FriendsList.User;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ChatListItem.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.user);
        User.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.user);
        username = findViewById(R.id.logInUserName);
        password = findViewById(R.id.logInPassword);
        logInButton = findViewById(R.id.logInButton);
    }

    public void logInClick(View v) {
        String user = username.getText().toString(), pass = password.getText().toString();
        if (user.length() == 0 || pass.length() == 0) {
            Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_LONG).show();
        } else {Authenticate r = new Authenticate(getApplicationContext(),new Callback(){
            @Override
            public void success(Object rr) {
                AppResponse rrr = (AppResponse) rr;
                if(rrr.token == null){
                    Toast.makeText(getApplicationContext(), rrr.error, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), rrr.token, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtra("token",rrr.token);
                    startActivity(i);
                    finish();
                }
            }
            @Override
            public void error(String error){
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
            }
        },"login");
            r.doRequest(user,pass);
        }
    }

    public void register(View v) {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0) && resultCode == R.integer.notLogOut)
            finish();
    }
}
