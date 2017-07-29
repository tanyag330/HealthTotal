package healthtotal.example.com.healthtotal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MyService extends Service {
   public static nutritionFactsClass obj;
    public static final String TAG="myService";
    public MyService() {



    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: ");
        String name = intent.getExtras().getString(BarcodeScanActivity.KEY_NAME);
        Log.d(TAG, "onStartCommand: name= "+name);


        try {

            InputStream is =  getResources().getAssets().open("NutritionDetail.json");
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));

            StringBuilder sb = new StringBuilder();
            String buffer = "";


            do
            {
                sb.append(buffer);
                buffer = br.readLine();

            }while(buffer!=null);

            String jsonString = sb.toString();

            JSONObject nutriondetails = new JSONObject(jsonString);
            JSONArray foods = nutriondetails.getJSONObject("product").getJSONArray("foods");

            int len = foods.length();
            for (int i = 0; i < len; i++) {
                JSONObject fooddetail=foods.getJSONObject(i);
//                Log.d(TAG, "name"+fooddetail.getString("name"));
//                Log.d(TAG, "intent name"+name);
//                Log.d(TAG, "barcodeno"+fooddetail.getString("barcodeno"));
                boolean bool=fooddetail.getString("barcodeno").equals(name);
                //Log.d(TAG, "bool= "+bool);
                if(bool)
                {
                    Toast.makeText(MyService.this, "match", Toast.LENGTH_SHORT).show();
                    nutritionFactsClass.barcodeNO=fooddetail.getLong("barcodeno");
                    nutritionFactsClass.foodName=fooddetail.getString("name");


                    JSONArray itemNutrients= fooddetail.getJSONArray("nutrients");


                        for (int l = 0; l < itemNutrients.length();l++) {
                            JSONObject nutrientObj = itemNutrients.getJSONObject(l);
                            nutritionArrayType arrobj = new nutritionArrayType();
                            for (int j = 0; j < 5; j++) {
                                if (j == 0) {
                                    Log.d(TAG, "nutrient_id :" + nutrientObj.getString("nutrient_id"));
                                    arrobj.nutrientId=  nutrientObj.getString("nutrient_id");
                                    Log.d(TAG, "id"+arrobj.nutrientId);
                                  //  nutritionFactsClass.nutritionDetail.set(l,nutritionFactsClass.nutritionDetail.get(l).nutrientId = nutrientObj.getString("nutrient_id");

                                } else if (j == 1) {
                                    Log.d(TAG, "nutrient :" + nutrientObj.getString("nutrient"));
                                    arrobj.nutrientName = nutrientObj.getString("nutrient");
                                    Log.d(TAG, "nutrient"+arrobj.nutrientName);
                                } else if (j == 2) {
                                    Log.d(TAG, "unit :" + nutrientObj.getString("unit"));
                                    arrobj.unit = nutrientObj.getString("unit");
                                    Log.d(TAG, "unit"+arrobj.unit);
                                } else if (j == 3) {
                                    Log.d(TAG, "value :" + nutrientObj.getString("value"));
                                  arrobj.value = nutrientObj.getString("value");
                                    Log.d(TAG, "value"+arrobj.value);
                                } else if (j == 4) {
                                    Log.d(TAG, "dv :" + nutrientObj.getString("dv"));
                                    arrobj.dv = nutrientObj.getString("dv");
                                    Log.d(TAG, "dv"+arrobj.dv);

                                }
                            }

                            //nutritionFactsClass.nutritionDetail.add(arrobj);
                        }
                        //obj.setNutritionDetail(arrobj);


                    }
                }

        } catch (IOException|JSONException e) {
            e.printStackTrace();
        }


        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
