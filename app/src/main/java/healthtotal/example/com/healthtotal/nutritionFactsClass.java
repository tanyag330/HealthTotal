package healthtotal.example.com.healthtotal;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Admin on 10/2/2016.
 */
public class nutritionFactsClass {



   public static  long barcodeNO;
    public static  String foodName;
    public static ArrayList<nutritionArrayType> nutritionDetail;
    public nutritionFactsClass(long barcodeNO, String foodName) {

        this.barcodeNO = barcodeNO;
        nutritionDetail = new  ArrayList<nutritionArrayType>();;
        this.foodName = foodName;
        //this.nutritionDetail = nutritionDetail;
}

    public long getBarcodeNO() {
        return barcodeNO;
    }

    public String getFoodName() {
        return foodName;
    }


    public void setNutritionDetail( ArrayList<nutritionArrayType> nutritionDetail) {
        this.nutritionDetail = nutritionDetail;
    }

    public  ArrayList<nutritionArrayType> getNutritionDetail() {
        return nutritionDetail;
    }
//    public nutritionFactsClass returnobj()
//    {
//        return this;
//    }
}

