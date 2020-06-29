package com.example.final_diesease;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
                                Intent intent = new Intent(ctx,Home.class);

                                ctx.startActivity(intent);
                            }
                            else
                            {
                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Login status");
                                alertDialog.setMessage("Username or password incorrect");
                                alertDialog.show();
                            }
                            break;

                        case"register":
                            String registerStatus=jo.getString("code");

                            if(registerStatus.equals("register successful"))
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                                builder.setMessage("You can now Login")
                                        .setTitle("Register Successful")
                                        .setCancelable(false)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Intent intent = new Intent(ctx,MainActivity.class);//Home is new class with xml file
                                                ctx.startActivity(intent);
                                            }
                                        });
                                alertDialog =builder.create();
                                alertDialog.show();





                            }
                            else
                            {

                                String name = jo.getString("name");
                                String surname=jo.getString("surname");
                                String email=jo.getString("email");
                                String user = jo.getString("user");
                                String pass = jo.getString("pass");
                                String code = jo.getString("code");
                                String mistakes="";

                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Error in Registering");
                                if(name.equals(""))
                                {
                                    mistakes+="Name not entered \n";
                                }
                                 if(surname.equals(""))
                                {
                                    mistakes+="Surname not entered \n";
                                }
                                 if(email.equals(""))
                                {
                                    mistakes+="Email not entered \n";
                                }
                                if(user.equals(""))
                                {
                                    mistakes+="userName not entered \n";
                                }
                                if(pass.equals(""))
                                {
                                    mistakes+="Pass not entered \n";
                                }
                                if(code.equals("reg_failed"))
                                {
                                    mistakes+="User name is taken";
                                }

                                alertDialog.setMessage(mistakes);
                                alertDialog.show();

                            }

                            break;
                        case"riskCountry":
                            callBack.OnCountryClick(jo);
                            break;

                        case"riskSearch":
                            callBack.OnSearchSuccess(jo);

                            break;

                        case"highrisk":
                            callBack.OnHigh(jo);
                            break;


                        case"addCase":

                            String add = jo.getString("code");
                            if(add.equals("insert successful"))
                            {
                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Case Status");
                                alertDialog.setMessage("Case Added");
                                alertDialog.show();
                            }
                            else
                            {
                                alertDialog = new AlertDialog.Builder(ctx).create();
                                alertDialog.setTitle("Error in adding the case");
                                alertDialog.setMessage("invalid inputs");
                                alertDialog.show();
                            }

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
        void OnCountryClick(JSONObject response);
        void OnHigh(JSONObject response);


    }


}
