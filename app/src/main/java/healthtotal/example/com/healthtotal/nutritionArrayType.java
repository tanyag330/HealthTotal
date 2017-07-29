package healthtotal.example.com.healthtotal;

/**
 * Created by Admin on 2/18/2017.
 */
public class nutritionArrayType{


  public String nutrientId;
    public String nutrientName;
    public String unit;
    public String value;
    public String dv;

    public nutritionArrayType() {

    }

    public void setNutrientId(String nutrientId) {
        this.nutrientId = nutrientId;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNutrientId() {
        return nutrientId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public String getDv() {
        return dv;
    }

}