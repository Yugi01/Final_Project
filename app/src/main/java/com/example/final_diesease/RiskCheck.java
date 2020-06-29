package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_check);

        txtriskSearch = findViewById(R.id.riskSearch);

    }

    public void Search(String place)
    {

        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("CITYNAME",place);
        helpRequest.makeRequest("riskSearch", this,null);


    }

    public void onClickSearch(View view)
    {
        String place =txtriskSearch.getText().toString();
        Search(place);
    }

    public void OnClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }


}
