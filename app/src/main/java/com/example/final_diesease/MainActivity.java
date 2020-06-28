package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText userET,passET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userET=findViewById(R.id.user);
        passET=findViewById(R.id.password);

    }

    public void Login(String user, String pass)
    {
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("USER_NAME",user);
        helpRequest.populateParams("PASSWORD" ,pass);
        helpRequest.makeRequest("login",this);

    }

    public void OnClickReg(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }


    public void onClickLogin(View view) {

        String user=userET.getText().toString();
        String pass=passET.getText().toString();

        Login(user,pass);
    }
}
