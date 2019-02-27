package com.example.bangchat;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ButtonBarLayout loginButton;
    private ButtonBarLayout signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);


    }


    public void account(View view) {

        switch (view.getId())
        {
            case R.id.loginButton :
            {
                Intent loginIntent  = new Intent(this,LoginActivity.class);
                startActivity(loginIntent);
                print("Sign Up Button Clicked!");
                break;

            }
            case R.id.signupButton :
            {
                Intent signupIntent = new Intent(this,signUpActivity.class);
                startActivity(signupIntent);
                print("Sign up Button Clicked");
                break;
            }
            default:
            {
                print("Invalid button clicked");
                break;
            }

        }



    }


    private void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }
}
