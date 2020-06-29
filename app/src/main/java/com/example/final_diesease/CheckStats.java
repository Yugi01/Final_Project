package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CheckStats extends AppCompatActivity {

    Context ctx;
    ArrayAdapter riskAdapter, countryAdapter;
    ArrayList<String> riskArray = new ArrayList<String>();
    ArrayList<String> countryArray = new ArrayList<String>();

//    TextView citytxt,countrytxt,casestxt,recenttxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ctx=this;
        riskAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, riskArray );
        countryAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, countryArray );

        ListView riskList = (ListView) findViewById(R.id.riskList);
        riskList.setAdapter(riskAdapter);

        ListView countryList = (ListView) findViewById(R.id.countryList);
        countryList.setAdapter(countryAdapter);

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
        public void OnCountryClick(JSONArray response) {

            try {

                for(int i=0; i<response.length(); i++)
                {


                    String country = response.getJSONObject(i).getString("COUNTRYNAME");
                    String cases = response.getJSONObject(i).getString("TOTALCASES");
                    String worstCity = response.getJSONObject(i).getString("WORSTCITY");

                    countryAdapter.add(country+"-"+cases+"-"+worstCity);

                }

                countryAdapter.notifyDataSetChanged();


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void OnHigh(JSONArray response) {

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
            public void OnCountryClick(JSONArray response) {

            }

            @Override
            public void OnHigh(JSONArray response) {

                try {


                    for(int i=0; i<response.length(); i++)
                    {
                        String city = response.getJSONObject(i).getString("CITYNAME");
                        String country = response.getJSONObject(i).getString("COUNTRYNAME");
                        String cases = response.getJSONObject(i).getString("CASES");
                        String recent = response.getJSONObject(i).getString("RECENTCASE");


                        riskAdapter.add(city+"-"+country+"-"+cases+"-"+recent);




                    }
                    riskAdapter.notifyDataSetChanged();


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
