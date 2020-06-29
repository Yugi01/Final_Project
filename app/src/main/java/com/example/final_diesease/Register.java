package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText userNameET, userSurnameET, userUserName,userPassET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameET = findViewById(R.id.name);
        userSurnameET =findViewById(R.id.userSurname);
        //userEmailET =findViewById(R.id.userEmail);
        userUserName=findViewById(R.id.userName);
        userPassET = findViewById(R.id.userPass);


    }

    public void setRegister(String userName, String name, String surname, String userPass)
    {
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("USERNAME",userName);

        helpRequest.populateParams("FNAME" ,name);
        //helpRequest.populateParams("EMAIL",email);
        helpRequest.populateParams("LNAME" ,surname);
        helpRequest.populateParams("PASSWORD",userPass);
        helpRequest.makeRequest("register",this,null);
    }

    public void onClickRegister(View view)
    {
        String userName=userUserName.getText().toString();
        String name =userNameET.getText().toString();
        String surname =userSurnameET.getText().toString();
      //  String email =userEmailET.getText().toString();

        String pass= userPassET.getText().toString();

        setRegister(userName,name,surname,pass);

    }

    public void OnClickBack(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
