package healthtotal.example.com.healthtotal.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import healthtotal.example.com.healthtotal.MyDbOpener;
import healthtotal.example.com.healthtotal.models.LoginSignUpDetails;

/**
 * Created by Admin on 8/23/2016.
 */
public class LoginTable extends DbTable {
//    public static final String TABLE_NAME=" logindb";
public static final String TABLE_NAME=" logindbwithcheck";

    public static final String TAG="jhjdc";
public SQLiteDatabase dbanother;
    public interface Columns{

        String USERNAME="username";
        String PASSWORD="password";
        String EMAILID="emailid";
        String PHONENO="phoneno ";
        String BLOODGROUP="bloodgroup";
        String AGE="age";
        String ADDRESS="address";
        String DISEASECHECK="diseaseCheck";


    }

    public static final String CREATE_CMD="create table if not exists"+TABLE_NAME+
            LBR+
            Columns.USERNAME+TYPE_TEXT+COMMA+
            Columns.PASSWORD+TYPE_TEXT+COMMA+
            Columns.EMAILID+TYPE_TEXT_PK+COMMA+
            Columns.PHONENO+TYPE_INT+COMMA+
            Columns.BLOODGROUP+TYPE_TEXT+COMMA+
            Columns.AGE+TYPE_INT+COMMA+
            Columns.ADDRESS+TYPE_TEXT+COMMA+
            Columns.DISEASECHECK+TYPE_BIGINT+RBR + ";";


    public static String[] projection={

            Columns.USERNAME,
            Columns.PASSWORD,
            Columns.DISEASECHECK,
            Columns.EMAILID,
            Columns.PHONENO,
            Columns.ADDRESS,
            Columns.BLOODGROUP,
            Columns.AGE
    };


}
