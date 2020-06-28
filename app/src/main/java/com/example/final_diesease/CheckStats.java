package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CheckStats extends AppCompatActivity {


    EditText searchET;
    TextView textView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



       // searchET = findViewById(R.id.txtsearch);

    }

    public void setSearchPlace()
    {
        HelpRequest helpRequest = new HelpRequest();
        //helpRequest.populateParams("CITY",searchET);
        helpRequest.makeRequest("searchPlace",this,null);
    }

    public void OnClickSearchPlace(View view)
    {
       // String search = searchET.getText().toString();
        setSearchPlace();

    }

    public void onClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }








}
