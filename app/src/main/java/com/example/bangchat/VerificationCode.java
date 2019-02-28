package com.example.bangchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class VerificationCode extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText userCode;
    private ImageView mainLogin;
    private String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        userCode = findViewById(R.id.mainloginCode);
        mainLogin = findViewById(R.id.mainLogin);
        toolbar = findViewById(R.id.loginToolbar);
        toolbar.setTitle("Verify Phone Number");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void verifiyAccount()
    {
        mainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = userCode.getText().toString().trim();
                print("Code: "+code);
            }
        });
    }


    private void print(Object object)
    {
        Toast.makeText(this,object.toString(),Toast.LENGTH_SHORT).show();
    }
}
