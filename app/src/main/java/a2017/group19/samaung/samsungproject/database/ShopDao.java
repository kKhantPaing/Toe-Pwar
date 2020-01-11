package a2017.group19.samaung.samsungproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class ShopDao extends MyDatabaseHandler {
    public ShopDao(Context context) {
        super(context);
    }
    public void addShop(ShopClass shop){
        SQLiteDatabase myDB=this.getWritableDatabase();

        ContentValues myCV=new ContentValues();
        myCV.put(MyConstant.Shop_Name,shop.getShopName());
        myCV.put(MyConstant.Type,shop.getType());
        myCV.put(MyConstant.Phone,shop.getPhone());
        myCV.put(MyConstant.Address ,shop.getAddress() );
        myCV.put(MyConstant.Email,shop.getEmail());

        long i=myDB.insert(MyConstant.TABLE_NAME,null,myCV);
        Log.i("Save-->",i+"");
        myDB.close();
    }
    public List<ShopClass> getAllShop(){
        List<ShopClass> myPL=new ArrayList<ShopClass>();
        SQLiteDatabase myDB=this.getReadableDatabase();
        String myQuery="select * from "+ MyConstant.TABLE_NAME;
        Cursor myCursor=myDB.rawQuery(myQuery,null);
        if(myCursor.moveToFirst()){
            do{
                ShopClass shop=new ShopClass();
                shop.setShopName(myCursor.getString(0));
                shop.setType(myCursor.getString(1));
                shop.setPhone(myCursor.getString(2));
                shop.setAddress(myCursor.getString(3));
                shop.setEmail(myCursor.getString(4));

                myPL.add(shop);
            }while(myCursor.moveToNext());
        }
        myDB.close();
        return myPL==null || myPL.isEmpty() ? null : myPL;
    }
}
