package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void OnClickSearch(View view)
    {
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }


}
