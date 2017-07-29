package healthtotal.example.com.healthtotal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView nameDisplay;
    TextView emailDisplay;
    TextView phonenoDisplay;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameDisplay= (TextView) findViewById(R.id.full_name_display);
        emailDisplay= (TextView) findViewById(R.id.email_id_display);
        phonenoDisplay= (TextView) findViewById(R.id.phone_no_display);


    }
}
