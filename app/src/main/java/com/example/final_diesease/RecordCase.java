package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RecordCase extends AppCompatActivity {

    EditText locationET,dateET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_case);
    }

    public void onClickAddCase(View view)
    {

    }

    public void onClickHome(View view)
    {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }





}
