package com.example.bangchat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import data.userData;

public class VerificationCode extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText userCode;
    private ImageView mainLogin;
    private String code;
    private String number;
    private String verificationId;
    private FirebaseAuth mAuth;
     private String phoneNumber;

     userData data = new userData();
     String thisString = "VerificationCode.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

            mAuth = FirebaseAuth.getInstance();
            FirebaseApp.initializeApp(this);
        userCode = findViewById(R.id.mainloginCode);
        mainLogin = findViewById(R.id.mainLogin);
        toolbar = findViewById(R.id.loginToolbar);
        toolbar.setTitle("Verify Phone Number");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        phoneNumber = getIntent().getStringExtra("phone");
        sendVerificationCode(phoneNumber);

        verifiyAccount();


    }

    public void verifiyAccount()
    {
        mainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = userCode.getText().toString().trim();
                if (code.isEmpty() || code.length() < 6) {
                    userCode.setError("Enter valid code");
                    userCode.requestFocus();
                    return;
                }
                else
                {
                    verifyVerificationCode(code);
                }

            }
        });
    }



    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+88" + phoneNumber,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);

          print("sendVerificationCode is clicked");

    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                String automaticCode = phoneAuthCredential.getSmsCode();
                if(automaticCode!=null)
                {
                    userCode.setText(automaticCode);
                    verifyVerificationCode(automaticCode);
                }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            return;

        }
    };



    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential  credential = PhoneAuthProvider.getCredential(verificationId, code);
        PhoneAuthCredential(credential);

    }

        private void PhoneAuthCredential(PhoneAuthCredential credential) {
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(VerificationCode.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //verification successful we will start the profile activity
                                Intent intent = new Intent(VerificationCode.this, AccountActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            } else {

                                //verification unsuccessful.. display an error message

                                String message = "Somthing is wrong, we will fix it soon...";

                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    message = "Invalid code entered...";
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
