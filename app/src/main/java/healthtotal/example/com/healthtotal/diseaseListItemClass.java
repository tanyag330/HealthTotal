package healthtotal.example.com.healthtotal;

/**
 * Created by Admin on 8/25/2016.
 */
public class diseaseListItemClass {

    String diseaseText;
    Boolean status;

    public String getDiseaseText() {
        return diseaseText;
    }

    public diseaseListItemClass(String diseaseText) {
        this.diseaseText = diseaseText;
        this.status = false;
    }

    public void setStatus(Boolean newStatus) {

        this.status = newStatus;
    }

    public Boolean getStatus() {
        return status;
    }
}
