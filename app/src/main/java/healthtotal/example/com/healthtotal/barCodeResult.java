package healthtotal.example.com.healthtotal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class barCodeResult extends AppCompatActivity {


    public static final String TAG="tag";
    TextView tv_name;
    TextView tv_calories;
    TextView tv_fat;
    TextView tv_cholestrol;
    TextView tv_sodium;
    TextView tv_carbohydrates;
    TextView tv_protein;
    TextView tv_vitamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_result);



        Intent receivedIntent=getIntent();
        String my_name=receivedIntent.getStringExtra(BarcodeScanActivity.KEY_NAME);
        Log.d(TAG, "barCodeResult:barcode is "+my_name);



        Intent serviceIntent=new Intent(this,MyService.class);
        serviceIntent.putExtra(BarcodeScanActivity.KEY_NAME, my_name);
        startService(serviceIntent);
        stopService(serviceIntent);
        tv_name= (TextView) findViewById(R.id.foodname);
        tv_calories= (TextView) findViewById(R.id.tv_calories);
        tv_fat= (TextView) findViewById(R.id.tv_fat);
        tv_cholestrol= (TextView) findViewById(R.id.tv_cholestrol);
        tv_sodium= (TextView) findViewById(R.id.tv_sodium);
        tv_carbohydrates= (TextView) findViewById(R.id.tv_carbohydrates);
        tv_protein= (TextView) findViewById(R.id.tv_protein);
        tv_vitamin= (TextView) findViewById(R.id.tv_vitamin);

      //  Log.d(TAG, "onCreate: "+nutritionFactsClass.nutritionDetail[0].getNutrientId());
//        if(Integer.parseInt(nutritionFactsClass.nutritionDetail.())<=100)
//        {
//            tv_calories.setText("Low calorie");
//        }
//        else if(Integer.parseInt(nutritionFactsClass.nutritionDetail.getNutrientId())<=400)
//        {
//            tv_calories.setText("moderate calorie");
//        }
//        else
//        {
//            tv_calories.setText("High calorie");
//        }



//
//        if(fatdvfetch<=5)
//        {
//            tv_cal.setText("Low fat");
//        }
//        else if(fatdvfetch<=20)
//        {
//            tv_cal.setText("moderate fat");
//        }
//        else
//        {
//            tv_cal.setText("High fat");
//        }
//
//
//
//
//        if(cholestroldvfetch<=5)
//        {
//            tv_cal.setText("Low cholestrol");
//        }
//        else if(cholestroldvfetch<=20)
//        {
//            tv_cal.setText("moderate cholestrol");
//        }
//        else
//        {
//            tv_cal.setText("High cholestrol");
//        }
//
//
//
//        if(sodiumdvfetch<=5)
//        {
//            tv_cal.setText("Low sodium");
//        }
//        else if(sodiumdvfetch<=20)
//        {
//            tv_cal.setText("moderate sodium");
//        }
//        else
//        {
//            tv_cal.setText("High sodium");
//        }
//
//
//
//
//        {
//            tv_cal.setText("Low carbohydrates");
//        }
//        else if(carbohydratesdvfetch<=20)
//        {
//            tv_cal.setText("moderate carbohydrates");
//        }
//        else
//        {
//            tv_cal.setText("High carbohydrates");
//        }
//
//
//
//
//
//        if(proteindvfetch<=5)
//        {
//            tv_cal.setText("Low protein");
//        }
//        else if(proteindvfetch<=20)
//        {
//            tv_cal.setText("moderate protein");
//        }
//        else
//        {
//            tv_cal.setText("High protein");
//        }
//
//
//
//
//        if(vitamindvfetch<=5)
//        {
//            tv_cal.setText("Low vitamin");
//        }
//        else if(vitamindvfetch<=20)
//        {
//            tv_cal.setText("moderate vitamin");
//        }
//        else
//        {
//            tv_cal.setText("High vitamin");
//        }
//
//        tv_name.setText(nutritionFactsClass.foodName);
//









    }
}
