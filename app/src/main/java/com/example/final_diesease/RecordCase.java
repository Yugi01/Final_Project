package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RecordCase extends AppCompatActivity {

    EditText countryET,cityET,dateET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_case);

        countryET=findViewById(R.id.country);
        cityET=findViewById(R.id.city);
     //   dateET=findViewById(R.id.date);

    }

    public void onClickAddCase(View view)
    {

        String country = countryET.getText().toString();
        String city = cityET.getText().toString();
       // String date=dateET.getText().toString();

        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("COUNTRY",country);
        helpRequest.populateParams("CITY",city);
        helpRequest.populateParams("USER",helpRequest.userName);
        //Log.d("username works?",helpRequest.userName);
        helpRequest.makeRequest("addCase",this,null);

    }

    public void onClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }





}
