package com.example.bangchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private Button signupButton,loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signupButton = findViewById(R.id.signupButton);
        loginButton = findViewById(R.id.loginButton);
    }

    public void account(View view) {
        switch (view.getId())
        {
            case R.id.signupButton :
            {
                Intent signupIntent = new Intent(this,SignupActivity.class);
                startActivity(signupIntent);
                print("Sign Up Button Clicked");
                break;
            }
            case R.id.loginButton :
            {
                Intent loginIntent = new Intent(this,LoginActivity.class);
                startActivity(loginIntent);
                print("Login Button Clicked");
                break;
            }
            default:
            {
                print("Invalid Key");
                break;
            }
        }


    }

    private void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }

}
