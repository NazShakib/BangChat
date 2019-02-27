package com.example.bangchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    private TextView forgetPassword;
    private TextView signupAccount;
    private ImageView loginAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgetPassword = findViewById(R.id.mainForgotPass);
        signupAccount = findViewById(R.id.mainNewAccount);
        loginAccount = findViewById(R.id.mainLogin);

        linearLayout = findViewById(R.id.loadingPanel);
    }


    public void login(View view) {

        switch (view.getId())
        {
            case R.id.mainLogin :
            {
                linearLayout.setVisibility(View.VISIBLE);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.mainForgotPass :
            {
                print("Forget Password Clicked");
                break;
            }
            case R.id.mainNewAccount :
            {
                print("Create Account Clicked");
                break;
            }
            default:
            {
                print("Invalid Key");
                break;
            }
        }

    }

    public void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }

}
