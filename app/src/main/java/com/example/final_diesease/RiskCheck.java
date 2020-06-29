package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RiskCheck extends AppCompatActivity {

    EditText txtriskSearch;
    TextView tcity;
    TextView tcountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_check);

        txtriskSearch = findViewById(R.id.riskSearch);
        tcity = findViewById(R.id.txtRisk);
        tcountry =findViewById(R.id.txtRiskCount);
    }

    public void onClickSearch(View view)
    {
        String search = txtriskSearch.getText().toString();
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("CITY_NAME",search);
        helpRequest.makeRequest("riskSearch", this, new HelpRequest.ResponseCallBack() {
            @Override
            public void OnSearchSuccess(JSONObject response) {

                try {

                    tcity.setText(response.getString("CITY_NAME"));
                    tcountry.setText(response.getString("CASES"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void OnCountryClick(JSONObject response) {

            }

            @Override
            public void OnHigh(JSONObject response) {

            }
        });


    }

    public void OnClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }


}
