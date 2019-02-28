package com.example.bangchat;



import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import data.DataValidition;
import data.userData;

public class MainActivity extends AppCompatActivity {

  private Button loginButton;
  private TextInputLayout userName,userPhoneNumber;

  DataValidition data;
  userData user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        userPhoneNumber= findViewById(R.id.userPhone);
        loginButton = findViewById(R.id.loginButton);
        accountNext();
    }


    public void accountNext() {
       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = userName.getEditText().getText().toString().trim();
               String phone =userPhoneNumber.getEditText().getText().toString().trim();
               data = new DataValidition(name,phone);
               if(data.checkBoth())
               {
                   user = new userData(name,phone);
                   Intent intent = new Intent(getApplicationContext(),VerificationCode.class);
                   startActivity(intent);
                   print("Name: "+name+"\nPhone: "+phone);
                   print("\nButton Clicked Successfully");
               }
               else
               {
                   if(!data.checkName())
                   {
                       userName.setError("Name Required");
                       userName.requestFocus();
                       return;
                   }
                  if(!data.checkPhone())
                   {
                       userPhoneNumber.setError("Phone Number Required");
                       userPhoneNumber.requestFocus();
                       return;
                   }
               }

           }
       });
    }



    private void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }

}
