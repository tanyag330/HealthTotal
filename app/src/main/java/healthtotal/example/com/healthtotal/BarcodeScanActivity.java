package healthtotal.example.com.healthtotal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.io.InputStream;

public class BarcodeScanActivity extends AppCompatActivity {

//    TextView tv_cal= (TextView) findViewById(R.id.calorie);
//    TextView tv_fat= (TextView) findViewById(R.id.fat);
//    TextView tv_cholestrol= (TextView) findViewById(R.id.cholestrol);
//    TextView tv_sodium= (TextView) findViewById(R.id.sodium);
//    TextView tv_carbohydrates= (TextView) findViewById(R.id.carbohydrates);
//    TextView tv_protein= (TextView) findViewById(R.id.protein);
//    TextView tv_vitamin= (TextView) findViewById(R.id.vitamin);

    public static final String KEY_NAME="my_name";
    public static String barCodeStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_display_layout);

        new IntentIntegrator(this).initiateScan();


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {


                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                barCodeStr=result.getContents();
                Intent barcodeResultintent=new Intent(BarcodeScanActivity.this, barCodeResult.class);
                barcodeResultintent.putExtra(KEY_NAME,barCodeStr);
                startActivity(barcodeResultintent);




                ///////////////////////////////////////////////////////////////////////
/*
                if(calfetch<=100)
                {
                    tv_cal.setText("Low calorie");
                }
                else if(calfetch<=400)
                {
                    tv_cal.setText("moderate calorie");
                }
                else
                {
                    tv_cal.setText("High calorie");
                }
                //////////////////////////////////////////////////////////////////////////

                if(fatdvfetch<=5)
                {
                    tv_cal.setText("Low fat");
                }
                else if(fatdvfetch<=20)
                {
                    tv_cal.setText("moderate fat");
                }
                else
                {
                    tv_cal.setText("High fat");
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

                if(cholestroldvfetch<=5)
                {
                    tv_cal.setText("Low cholestrol");
                }
                else if(cholestroldvfetch<=20)
                {
                    tv_cal.setText("moderate cholestrol");
                }
                else
                {
                    tv_cal.setText("High cholestrol");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if(sodiumdvfetch<=5)
                {
                    tv_cal.setText("Low sodium");
                }
                else if(sodiumdvfetch<=20)
                {
                    tv_cal.setText("moderate sodium");
                }
                else
                {
                    tv_cal.setText("High sodium");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if(carbohydratesdvfetch<=5)
                {
                    tv_cal.setText("Low carbohydrates");
                }
                else if(carbohydratesdvfetch<=20)
                {
                    tv_cal.setText("moderate carbohydrates");
                }
                else
                {
                    tv_cal.setText("High carbohydrates");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if(proteindvfetch<=5)
                {
                    tv_cal.setText("Low protein");
                }
                else if(proteindvfetch<=20)
                {
                    tv_cal.setText("moderate protein");
                }
                else
                {
                    tv_cal.setText("High protein");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if(vitamindvfetch<=5)
                {
                    tv_cal.setText("Low vitamin");
                }
                else if(vitamindvfetch<=20)
                {
                    tv_cal.setText("moderate vitamin");
                }
                else
                {
                    tv_cal.setText("High vitamin");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
*/

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
