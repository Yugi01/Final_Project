package com.example.final_diesease;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HelpRequest {


    String url="https://lamp.ms.wits.ac.za/home/s2246323/";
    Map<String, String> params;

    public HelpRequest()
    {
        params = new HashMap<>();
    }


    public void makeRequest(final String type, final Context ctx)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(ctx);

        url+=type+".php";
        Log.d("URL",url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray ja = new JSONArray(response);
                    JSONObject jo = ja.getJSONObject(0);
                    switch(type)
                    {

                        case"login":
                            String loginStatus = jo.getString("code");
                            if(loginStatus.equals("Login success"))
                            {
                                Intent intent = new Intent(ctx,Home.class);//Home is new class with xml file
                                ctx.startActivity(intent);
                            }
                            break;

                        case"register":

                            break;


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
        protected Map<String,String> getParams()
        {
            return params;
        }
        };

        requestQueue.add(stringRequest);

    }

    public void populateParams(String key, String value)
    {
        params.put(key, value);
    }


}
