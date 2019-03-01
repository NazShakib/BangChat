package Firebase;



import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
public class PhoneAuthActivity {


    String phoneNumber,code;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthCredential credential;
    String automaticCode;



    public PhoneAuthActivity(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }

    public PhoneAuthActivity(String phoneNumber,FirebaseAuth mAuth,String code ) {
        this.phoneNumber = phoneNumber;
        this.mAuth = mAuth;
        this.code = code;

    }

        public void mainFunction()
        {

            sendVerificationCode(phoneNumber);

        }
        public void codeSubmitManullay()
        {
            //verifying the code entered manually
            verifyVerificationCode(code);
        }

        private void sendVerificationCode(String phoneNumber) {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+88" + phoneNumber,
                    60,
                    TimeUnit.SECONDS,
                    TaskExecutors.MAIN_THREAD,
                    mCallbacks);
        }

        private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                //Getting the code sent by SMS
                String automaticCode = phoneAuthCredential.getSmsCode();

                //sometime the code is not detected automatically
                //in this case the code will be null
                //so user has to manually enter the code
                if (code != null) {
                    //verifying the code
                    verifyVerificationCode(automaticCode);
                }
            }


            @Override
            public void onVerificationFailed(FirebaseException e) {
                return;
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                //storing the verification id that is sent to the user
                mVerificationId = s;
            }
        };

        private void verifyVerificationCode(String code) {
            //creating the credential
            credential = PhoneAuthProvider.getCredential(mVerificationId, code);


        }

        public PhoneAuthCredential sentCredential()
        {
            return credential;
        }


    public String getAutomaticCode()
    {
        return automaticCode;
    }





}
