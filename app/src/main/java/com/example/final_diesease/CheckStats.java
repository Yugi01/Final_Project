package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckStats extends AppCompatActivity {

    Context ctx;

//    TextView citytxt,countrytxt,casestxt,recenttxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ctx=this;

//        citytxt = findViewById(R.id.caseid);
//        countrytxt=findViewById(R.id.countryid);
//        casestxt=findViewById(R.id.caseid);
//        recenttxt=findViewById(R.id.recentid);


    }

    public void onClickCountry(View view)
    {
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.makeRequest("riskCountry", this, new HelpRequest.ResponseCallBack() {

        @Override
        public void OnSearchSuccess(JSONObject response) {

        }

        @Override
        public void OnCountryClick(JSONObject response) {

//            try {
//               // citytxt.setText(response.getString("response"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

        }

        @Override
        public void OnHigh(JSONObject response) {

        }
    });



    }






    public void OnClickHighRisk(View view)
    {
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.makeRequest("highrisk", this, new HelpRequest.ResponseCallBack() {

            @Override
            public void OnSearchSuccess(JSONObject response) {

            }

            @Override
            public void OnCountryClick(JSONObject response) {

            }

            @Override
            public void OnHigh(JSONObject response) {

                try {


                    for(int i=0; i<response.length(); i++)
                    {
                        String city = response.getString("CITYNAME");
                        String country = response.getString("COUNTRYNAME");
                        String cases = response.getString("CASES");
                        String recent = response.getString("RECENTCASE");

                        TextView citytxt = new TextView(ctx);
                        TextView countrytxt= new TextView(ctx);
                        TextView casestxt=new TextView(ctx);
                        TextView recenttxt= new TextView(ctx);
                        
                        citytxt.setText(city);
                        countrytxt.setText(country);
                        casestxt.setText(cases);
                        recenttxt.setText(recent);


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


      });

    }

    public void onClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }








}
