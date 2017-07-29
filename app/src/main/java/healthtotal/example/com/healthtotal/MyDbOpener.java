package healthtotal.example.com.healthtotal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import healthtotal.example.com.healthtotal.db.LoginTable;
import healthtotal.example.com.healthtotal.models.LoginSignUpDetails;

/**
 * Created by Admin on 8/23/2016.
 */
public class MyDbOpener extends SQLiteOpenHelper{

    public static final String DB_NAME="myDbAnother";
    public static final int DB_VER=1;
    public static MyDbOpener myDbOpener=null;
    static SQLiteDatabase dbanother;


    public static SQLiteDatabase openReadableDatabase(Context c)
    {
        if(myDbOpener==null)
        {
            myDbOpener=new MyDbOpener(c);
        }
        return myDbOpener.getReadableDatabase();
    }
    public static SQLiteDatabase openWritableDatabase(Context c)
    {
        if(myDbOpener==null)
        {
            myDbOpener=new MyDbOpener(c);
        }

        return myDbOpener.getWritableDatabase();
    }


    public MyDbOpener(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(LoginTable.CREATE_CMD);
    }


    public void insertDetails(LoginSignUpDetails detail)
    {

        dbanother=this.getWritableDatabase();
        ContentValues values=new ContentValues();
//String query="select * from "+LoginTable.TABLE_NAME;
//        Cursor c=dbanother.rawQuery(query,null);
//        int count=c.getCount();

        values.put(LoginTable.Columns.USERNAME,detail.getName());
        values.put(LoginTable.Columns.PASSWORD, detail.getPassword());
        values.put(LoginTable.Columns.EMAILID,detail.getEmail());
        values.put(LoginTable.Columns.PHONENO, detail.getPhnno());
        values.put(LoginTable.Columns.ADDRESS,detail.getAddress());
        values.put(LoginTable.Columns.AGE,detail.getAge());
        values.put(LoginTable.Columns.DISEASECHECK,0);

        dbanother.insert(LoginTable.TABLE_NAME, null, values);

    }

    public Boolean existUserName(String uname)
    {

        SQLiteDatabase dbanother;
        dbanother= this.getReadableDatabase();
        String query="select emailid from "+LoginTable.TABLE_NAME;
        Cursor cursor=dbanother.rawQuery(query,null);
        String a;

        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);
                if(a.equals(uname))
                {

                    return true;
                }
            }
            while(cursor.moveToNext());
        }
        return false;
    }
    public Boolean matchPass(String uname, String pass)
    {
        SQLiteDatabase dbanother;
        dbanother= this.getReadableDatabase();
        String query="select emailid, password from logindbwithcheck";
        Cursor cursor=dbanother.rawQuery(query,null);
        String a=null;
        String b=null;


        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    Log.d("in matchpassloop", "matchPass: ");
                    b=cursor.getString(1);
                    if(b.equals(pass))
                    {
                        Log.d("in true loop", "matchPass: ");
                        return true;
                    }

                }
            }
            while(cursor.moveToNext());
        }
        return false;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
