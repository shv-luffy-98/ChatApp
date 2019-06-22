package com.example.shv.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText name, email, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        username = findViewById(R.id.registerUserName);
        password = findViewById(R.id.registerPassword);
    }

    public void registerClick(View v) {
        String nameStr = name.getText().toString(), emailStr = email.getText().toString(), user = username.getText().toString(), pass = password.getText().toString();
        if (nameStr.length() == 0 || emailStr.length() == 0 || user.length() == 0 || pass.length() == 0) {
            Toast.makeText(getApplicationContext(), "All feilds are required", Toast.LENGTH_LONG).show();
        } else {
            Authenticate r = new Authenticate(getApplicationContext(),new Callback(){
                @Override
                public void call(Object rr) {
                    AppResponse rrr = (AppResponse) rr;
                    if(rrr.token == null){
                        Toast.makeText(getApplicationContext(), rrr.error, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), rrr.token, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            },"register");
            r.doRequest(user,pass);
        }
    }
}
