package com.example.final_diesease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText userNameET, userSurnameET, userEmailET, userUserName,userPassET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameET = findViewById(R.id.user);
        userSurnameET =findViewById(R.id.userSurname);
        userEmailET =findViewById(R.id.userEmail);
        userUserName=findViewById(R.id.userName);
        userPassET = findViewById(R.id.userPass);


    }

    public void setRegister(String name, String surname, String email, String userName, String userPass)
    {
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.populateParams("NAME",name);
        helpRequest.populateParams("SURNAME" ,surname);
        helpRequest.populateParams("EMAIL",email);
        helpRequest.populateParams("USER_NAME" ,userName);
        helpRequest.populateParams("PASSWORD",userPass);
        helpRequest.makeRequest("register",this);
    }

    public void onClickRegister(View view)
    {
        String name =userNameET.getText().toString();
        String surname =userSurnameET.getText().toString();
        String email =userEmailET.getText().toString();
        String userName=userUserName.getText().toString();
        String pass= userPassET.getText().toString();

        setRegister(name,surname,email,userName,pass);

    }

}
