package com.example.bangchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import data.DataValidition;
import data.userData;

public class SignupActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText userName,userPhone,userPassword;
    private String name,phone,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userName = findViewById(R.id.userName);
        userPhone = findViewById(R.id.userPhone);
        userPassword= findViewById(R.id.userPassword);
        toolbar = findViewById(R.id.singupToolbar);
        toolbar.setTitle("Create Account");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void sigupAccount(View view) {

        switch (view.getId())
        {
            case R.id.mainForgotPass:
            {
                print("Forgot Password Clicked");
                break;
            }
            case R.id.mainAlreadyHaveAccount:
            {
                Intent loginIntent = new Intent(this,LoginActivity.class);
                startActivity(loginIntent);
                print("Clicked");
                break;
            }
            case R.id.mainSignup:
            {
                name = userName.getText().toString().trim();
                phone = userPhone.getText().toString().trim();
                password = userPassword.getText().toString().trim();
                if(validData(name,phone,password))
                {
                    userData userData = new userData(name,phone,password);
                    print("Name :"+userData.getName());
                    print("Name :"+userData.getPhone());
                    print("Name :"+userData.getPassword());
                    print("Valid Data");
                }
                else
                {
                    print("Invalid Data");
                }
                break;
            }
            default:
            {
                print("Invalid Key");
                break;
            }
        }

    }


    private boolean validData(String name,String phone,String password)
    {
        DataValidition dataValidition = new DataValidition(name,phone,password);
        if(dataValidition.validSignUp())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }

}
