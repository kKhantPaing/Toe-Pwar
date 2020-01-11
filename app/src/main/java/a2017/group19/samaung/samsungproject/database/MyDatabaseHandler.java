package a2017.group19.samaung.samsungproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 10/22/2017.
 */


public class MyDatabaseHandler extends SQLiteOpenHelper {
    public MyDatabaseHandler(Context context) {
        super(context, MyConstant.DATABASE_NAME,null, MyConstant.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String shopTable=
                "create table if not exists "+ MyConstant.TABLE_NAME+"("
//                        +MyConstant.Shop_id+  " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                        + MyConstant.Shop_Name+" text primary key, "
                        + MyConstant.Type+"  text, "
                        + MyConstant.Phone+" text,"
                        + MyConstant.Address+" text, "
                        + MyConstant.Email+" text"
                        +")";
        db.execSQL(shopTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ MyConstant.TABLE_NAME);
        onCreate(db);
    }
}
