package healthtotal.example.com.healthtotal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import healthtotal.example.com.healthtotal.db.LoginTable;
import healthtotal.example.com.healthtotal.models.LoginSignUpDetails;

public class SignUpActivity extends AppCompatActivity {

public static long signupPhnno=0;
    public static String signupemail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText FirstName = (EditText) findViewById(R.id.et_fname);
        final EditText LastName = (EditText) findViewById(R.id.et_lname);
        final EditText EmailID = (EditText) findViewById(R.id.et_emailid);
        final EditText Password = (EditText) findViewById(R.id.et_password);
        final EditText ConfirmPassword = (EditText) findViewById(R.id.et_confirmPass);
        final EditText PhoneNumber = (EditText) findViewById(R.id.et_phoneNum);
        final EditText Address= (EditText) findViewById(R.id.et_address);
        final EditText Age= (EditText) findViewById(R.id.et_age);
        final EditText BloodGroup= (EditText) findViewById(R.id.et_bloodgrp);

        Button signupbtn= (Button) findViewById(R.id.btn_sign_up);


        final MyDbOpener objforopener=new MyDbOpener(SignUpActivity.this);/////////////////////////////////////////////////////////////
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirstName==null||LastName==null||EmailID==null||Password==null||ConfirmPassword==null
                        ||PhoneNumber==null||Address==null||Age==null||BloodGroup==null)
                {
                    Toast.makeText(SignUpActivity.this, "Fill all the details to sign up", Toast.LENGTH_SHORT).show();
                }


               else if(objforopener.existUserName(EmailID.getText().toString()))
                {
                    Toast.makeText(SignUpActivity.this, "This username has been taken", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignUpActivity.this, "Try with a different username", Toast.LENGTH_SHORT).show();
                    EmailID.setText("");
                }
//               else if(!isValidEmail((CharSequence) (EmailID.getText().toString())))
//                {
//                    Toast.makeText(SignUpActivity.this, "Invalid email id", Toast.LENGTH_SHORT).show();
//                    EmailID.setText("");
//                }
                else if(!isValidPassword(Password))
                {
                    Toast.makeText(SignUpActivity.this, "Unacceptable Password", Toast.LENGTH_SHORT).show();
                    Password.setText("");
                    ConfirmPassword.setText("");
                }
                else if(!ConfirmPassword.getText().toString().equals(Password.getText().toString()))
                {
                    Toast.makeText(SignUpActivity.this, "passwords do not match", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignUpActivity.this, "confirm password again", Toast.LENGTH_SHORT).show();
                    Password.setText("");
                    ConfirmPassword.setText("");
                }
                else if(PhoneNumber.length()<10)
                {
                    Toast.makeText(SignUpActivity.this, "invalid phone no", Toast.LENGTH_SHORT).show();
                    PhoneNumber.setText("");
                }
                else {
                    signupemail=EmailID.getText().toString();

                    signupPhnno=Long.parseLong(PhoneNumber.getText().toString());
                    LoginSignUpDetails detailsobj=new LoginSignUpDetails(FirstName.getText().toString() + LastName.getText().toString(),
                            EmailID.getText().toString(),Password.getText().toString(),BloodGroup.getText().toString(), PhoneNumber.getText().toString(),
                            Address.getText().toString(),Integer.parseInt(Age.getText().toString())

                            );
                    //myDB.delete(" ", LoginTable.Columns. + "=" + 3, null);
                    objforopener.insertDetails(detailsobj);

                    Intent signUpTodiseaseChart=new Intent(SignUpActivity.this, DiseaseChartActivity.class);
                    startActivity(signUpTodiseaseChart);
                }
            }
        });
    }
    private boolean isValidPassword(EditText pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
