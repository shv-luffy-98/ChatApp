package com.example.shv.chatapp;


import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

class Authenticate {
    RequestQueue rq;
    Callback cb;
    Context cc;
    String route;
    Authenticate(Context c, Callback callback,String r){
        cc = c;
        cb = callback;
        route = r;
    }
    public void doRequest(final String username, final String password){
        rq = Volley.newRequestQueue(cc);
        String url = "http://192.168.43.59:8080/"+route;
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ToJSON tj = new ToJSON(response);
                AppResponse rr = tj.convert(AppResponse.class);
                cb.call(rr);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        rq.add(sr);
    }
}