import java.util.ArrayList;

/**
 * Created by Admin on 10/2/2016.
 */
public class Foods {

        class Nutrient{
            String nutrientname;
            int dv;
            float mgval;

        }
        String foodname;
        long barcodeno;
        ArrayList<Nutrient> nutrients=new ArrayList<>();


    public Foods(String foodname,long barcodeno, ArrayList<Nutrient> nutrients) {
        this.foodname=foodname;
        this.barcodeno = barcodeno;
        this.nutrients = nutrients;
    }

    public String getFoodname() {
        return foodname;
    }
    public long getBarcodeno() {
        return barcodeno;
    }

    public ArrayList<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setBarcodeno(long barcodeno) {
        this.barcodeno = barcodeno;
    }




    public void setNutrients(ArrayList<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }
}





