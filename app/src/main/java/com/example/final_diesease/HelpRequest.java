package com.example.final_diesease;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

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

    AlertDialog alertDialog;
    String userName;
    String url="https://lamp.ms.wits.ac.za/home/s2246323/";
    Map<String, String> params;

    public HelpRequest()
    {
        params = new HashMap<>();
    }


    public void makeRequest(final String type, final Context ctx, @Nullable final ResponseCallBack callBack)
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
                            userName = jo.getString("user");
                            if(loginStatus.equals("Login successful"))
                            {
                                Intent intent = new Intent(ctx,Home.class);//Home is new class with xml file

                                ctx.startActivity(intent);
                            }
                            break;

                        case"register":
                            String registerStatus=jo.getString("code");

                            if(registerStatus.equals("register successful"))
                            {

                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Register Successful");
                                alertDialog.setMessage("You can now Login");
                                alertDialog.show();
                                Intent intent = new Intent(ctx,MainActivity.class);//Home is new class with xml file
                                ctx.startActivity(intent);
                            }
                            else
                            {

                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Error in Registering");
                                alertDialog.setMessage("Unable to Register");
                                alertDialog.show();

                            }

                            break;
                        case"searchPlace":
//                            Search search = new Search();
//                            JSONArray jarray = new JSONArray(response);
//
//                            for(int i=0; i<ja.length(); i++)
//                            {
//                                JSONObject jsonOb = jarray.getJSONObject(i);
//                                String city =jsonOb.getString("CITY_NAME");
//                                TextView t = new TextView();
//
//                            }

                            break;

                        case"riskSearch":
                            callBack.OnSearchSuccess(jo);

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

    public interface ResponseCallBack
    {

        void OnSearchSuccess(JSONObject response);


    }


}
