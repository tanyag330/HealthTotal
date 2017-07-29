package healthtotal.example.com.healthtotal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivityCustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity_custom);

        final EditText uname= (EditText) findViewById(R.id.login_emailId);
        final EditText pass= (EditText) findViewById(R.id.login_password);

        Button loginbtn= (Button) findViewById(R.id.login_button);
        Button signupbtn= (Button) findViewById(R.id.signup_button);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(!isValidEmail((CharSequence) uname))
//                {
//                    Toast.makeText(LoginActivityCustom.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                                                                                                 //                    Toast.makeText(LoginActivityCustom.this, "Please try again", Toast.LENGTH_SHORT).show();
//                    uname.setText("");
//                    pass.setText("");
//                }
//                if(pass.length()<=6)
//                {
//                    Toast.makeText(LoginActivityCustom.this, "Invalid password", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginActivityCustom.this, "Please try again", Toast.LENGTH_SHORT).show();
//                    pass.setText("");
//                }
//                else
//                {
                    MyDbOpener objforopener=new MyDbOpener(LoginActivityCustom.this);/////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////
                   if(objforopener.matchPass(uname.getText().toString(),pass.getText().toString()))
                   {
                       Intent LoginToNewsfeed=new Intent(LoginActivityCustom.this, NewsfeedActivity.class);
                       startActivity(LoginToNewsfeed);
                   }
                   else
                   {
                       Toast.makeText(LoginActivityCustom.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                   }



            //    }
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToSignUp=new Intent(LoginActivityCustom.this,SignUpActivity.class);
                startActivity(intentToSignUp);


            }
        });











    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Method 2 for email validation
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }


}
