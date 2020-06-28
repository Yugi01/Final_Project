package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends AppCompatActivity {


    EditText searchET;
    TextView textView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



       // searchET = findViewById(R.id.txtsearch);

    }

    public void setSearch()
    {
        HelpRequest helpRequest = new HelpRequest();
        //helpRequest.populateParams("CITY",searchET);
        helpRequest.makeRequest("search",this);
    }

    public void OnClickSearch(View view)
    {
       // String search = searchET.getText().toString();
        setSearch();

    }







}
