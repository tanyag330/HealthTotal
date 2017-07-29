package healthtotal.example.com.healthtotal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeToLogin=new Intent(MainActivity.this, LoginActivityCustom.class);
                startActivity(homeToLogin);

             //   Intent homeToLogin=new Intent(MainActivity.this, DiseaseChartActivity.class);
               // startActivity(homeToLogin);


                finish();
            }
        }, 1000);



        




    }
}
