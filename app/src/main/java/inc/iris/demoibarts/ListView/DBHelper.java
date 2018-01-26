package inc.iris.demoibarts.ListView;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import inc.iris.demoibarts.R;

/**
 * Created by Sud on 1/23/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION=8;
    private static final String DB_NAME="EmployeeDB";
    private static final String TABLE="Employee";
    private static final String COLUMN_ID="ID";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_POST="Post";
    private static final String COLUMN_DP="DP";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("DBHelper","oncreate start");
        String query= "CREATE TABLE "+TABLE+" ("
                +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_NAME+" TEXT, "
                +COLUMN_POST+" TEXT, "
                +COLUMN_DP+" BLOB );";
        sqLiteDatabase.execSQL(query);
        Log.e("DBHelper","oncreate end");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("DBHelper","upgrade start");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE+";");
        onCreate(sqLiteDatabase);
        Log.e("DBHelper","upgrade end");


    }

    public void addEmp(Info emp) {
        Log.e("DBHelper","add start");

        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME, emp.getName());
        values.put(COLUMN_POST,emp.getPost());
        values.put(COLUMN_DP,emp.getDp());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(DBHelper.TABLE,null,values);
        db.close();
        Log.e("DBHelper","add end");
    }
    public void delete(String name)
    {
        Log.e("DBHelper","delete start");

        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE+" WHERE "+COLUMN_NAME+" =\""+name+"\" ;");
        Log.e("DBHelper","del end");
    }

    public List<Info> getEmpList()
    {
        Log.e("DBHelper","getEmpList start");

        List<Info> list=new ArrayList<>();
        Info emp;
        String name, post;
        byte[] dp;
        SQLiteDatabase db=getWritableDatabase();
        Log.e("DBHelper","getEmpList mid");

        String query= "SELECT * FROM "+TABLE+";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            name=cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            post=cursor.getString(cursor.getColumnIndex(COLUMN_POST));
            dp=cursor.getBlob(cursor.getColumnIndex(COLUMN_DP));
            emp=new Info(name,post,dp);
            list.add(emp);
            cursor.moveToNext();
        }
        Log.e("DBHelper","getEmpList end");
        return list;
    }
}
