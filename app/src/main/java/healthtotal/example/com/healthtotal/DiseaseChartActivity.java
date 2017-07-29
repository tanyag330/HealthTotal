package healthtotal.example.com.healthtotal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import healthtotal.example.com.healthtotal.db.DbTable;
import healthtotal.example.com.healthtotal.db.LoginTable;

public class DiseaseChartActivity extends AppCompatActivity {

    public static final String TAG = "Lists";
public static long diseaseCheckLong=0;
   public static Boolean[] diseaseChecked;
    static ArrayList<diseaseListItemClass> diseaseObjectArrayList = new ArrayList<>();
    public static Boolean[] diseaseBoolArr;
    ListView diseaseListView;
    Button donebtn;

    public ArrayList<diseaseListItemClass> getdiseaseDetail()
    {
        diseaseObjectArrayList.add(new diseaseListItemClass("Low Blood Pressure"));
        diseaseObjectArrayList.add(new diseaseListItemClass("High Blood Pressure"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Acne"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Heart Disease"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Arthritis"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Asthama"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Cancer"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Mushroom Allergy"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Peanut Allergy"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Eye Problems"));
        diseaseObjectArrayList.add(new diseaseListItemClass("Tonsils"));
        return diseaseObjectArrayList;
    }


    public static void initializeDiseaseChecked()
    {

        diseaseChecked=new Boolean [diseaseObjectArrayList.size()];
        for(int i=0;i<diseaseChecked.length;i++)
        {
            diseaseChecked[i]=false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_chart);




        diseaseObjectArrayList = this.getdiseaseDetail();
        diseaseBoolArr=new Boolean[diseaseObjectArrayList.size()];
        for(int i=0;i<diseaseBoolArr.length;i++)
        {
            diseaseBoolArr[i]=false;
        }
        diseaseListView = (ListView) findViewById(R.id.diseaseChartListView);

        DiseasesListAdapter diseasesListAdapter = new DiseasesListAdapter(diseaseObjectArrayList);
        diseaseListView.setAdapter(diseasesListAdapter);





        donebtn= (Button) findViewById(R.id.btntonewsfeed);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for(int i=0;i<diseaseObjectArrayList.size();i++)
                {

                    if(diseaseObjectArrayList.get(i).getStatus())
                    {

                        diseaseBoolArr[i]=true;
                    }
                }
                for(int i=0;i<diseaseBoolArr.length;i++)
                {
                    if(diseaseBoolArr[i])
                    {
                        diseaseCheckLong=diseaseCheckLong*10+1;
                    }
                    else
                    {
                        diseaseCheckLong=diseaseCheckLong*10+2;
                    }
                }
                SQLiteDatabase dbfordiseaseCheck= MyDbOpener.openWritableDatabase(getBaseContext());
                ContentValues values=new ContentValues();
                values.put(LoginTable.Columns.DISEASECHECK,diseaseCheckLong);
                //diseaseCheckLong
//                int id=2222221;
                String emailIdentify=SignUpActivity.signupemail;

                long phnNoIdentify=SignUpActivity.signupPhnno;
                dbfordiseaseCheck.update(LoginTable.TABLE_NAME, values,LoginTable.Columns.PHONENO+"="+phnNoIdentify , null);
                //LoginTable.Columns.EMAILID+"="+emailIdentify

//                SignUpActivity.signupemail


                final SQLiteDatabase myDB = MyDbOpener.openReadableDatabase(DiseaseChartActivity.this);
                Cursor c = myDB.query(

                        LoginTable.TABLE_NAME,
                        LoginTable.projection,
                        null, null, null, null, null
                );
                Log.d("cursor count", "cursor count " + c.getCount());
                while (c.moveToNext()) {
                    String email = c.getString(c.getColumnIndex(LoginTable.Columns.EMAILID));
                    String pass = c.getString(c.getColumnIndex(LoginTable.Columns.PASSWORD));
                    Long checkDis=c.getLong(c.getColumnIndex(LoginTable.Columns.DISEASECHECK));

                    Log.d("hello", "emailid= " + email + " pass= " + pass+"disease check= "+checkDis);
                }
                c.close();


                Intent diseaseCharttoNewsFeed = new Intent(DiseaseChartActivity.this,NewsfeedActivity.class);
                startActivity(diseaseCharttoNewsFeed);
            }
        });






    }


    public class DiseasesListAdapter extends BaseAdapter {

        private ArrayList<diseaseListItemClass> mDiseases;

        class diseaseViewHolder {

          public CheckBox chkbx;
        }

        public DiseasesListAdapter(ArrayList<diseaseListItemClass> mDiseases) {
            this.mDiseases = mDiseases;

        }

        @Override
        public int getCount() {
            return mDiseases.size();
        }

        @Override
        public diseaseListItemClass getItem(int position) {
            return mDiseases.get(position);

        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater li=getLayoutInflater();

            final diseaseViewHolder viewHolder;

            if(convertView==null)
            {
                convertView=li.inflate(R.layout.disease_chart_list_layout, null);
                viewHolder = new diseaseViewHolder();
                viewHolder.chkbx=(CheckBox) convertView.findViewById(R.id.checkListItem);

                convertView.setTag(viewHolder);
                viewHolder.chkbx.setText(getItem(position).diseaseText);
                viewHolder.chkbx.setChecked(getItem(position).getStatus());
                viewHolder.chkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        int getPosition = (Integer) buttonView.getTag(); // Here
                        // we get  the position that we have set for the checkbox using setTag.
                        getItem(getPosition).setStatus(buttonView.isChecked());
                    }
                });
            } else {

                viewHolder = (diseaseViewHolder) convertView.getTag();}

            viewHolder.chkbx.setTag(position); // This line is important.
            viewHolder.chkbx.setText(getItem(position).diseaseText);
            viewHolder.chkbx.setChecked(getItem(position).getStatus());
                return convertView;
            }



        }
}
