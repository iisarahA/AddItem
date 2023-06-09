package com.example.additem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String STADIUM_TABLE = "STADIUM_TABLE";
    public static final String COLUMN_STADIUM_ID = "ID";
    public static final String COLUMN_STADIUM_NAME = "STADIUM_NAME";
    public static final String COLUMN_SPORT_TYPE = "SPORT_TYPE";
    public static final String COLUMN_STADIUM_LOCATION = "STADIUM_LOCATION";
    public static final String COLUMN_STADIUM_PRICE = "STADIUM_PRICE";
    public static final String COLUMN_PRIVATE_CHECK = "PRIVATE_CHECK";



    public DataBaseHelper(@Nullable Context context) {
        super(context, "STADIUM.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + STADIUM_TABLE + "(" +  COLUMN_STADIUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_STADIUM_NAME + " TEXT ," +COLUMN_SPORT_TYPE + " TEXT," +COLUMN_STADIUM_LOCATION + " TEXT ," +COLUMN_STADIUM_PRICE +  "INT," +COLUMN_PRIVATE_CHECK + " INT )";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addOne(ItemModel itemMod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STADIUM_NAME, itemMod.getName());
        cv.put(COLUMN_SPORT_TYPE ,itemMod.getSportType());
        cv.put(COLUMN_STADIUM_LOCATION ,itemMod.getLocation());
        cv.put(String.valueOf(COLUMN_STADIUM_PRICE),itemMod.getPrice());
        cv.put(String.valueOf(COLUMN_PRIVATE_CHECK),itemMod.isPrivateChecked());

        long insert = db.insert(STADIUM_TABLE , null, cv);

        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }



    public List<ItemModel> getEveryone(){
        List<ItemModel> returnList = new ArrayList<>();
        // get data from database
        String queryString = "Select * from "+ STADIUM_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            // loop through cursor results
            do{
                int SID = cursor.getInt(0); //stadium id
                String SName = cursor.getString(1);
                String Stype = cursor.getString(2);
                String Slocation = cursor.getString(3);
                int Sprice = cursor.getInt(4);
                int privateChecked = cursor.getInt(5);
                ItemModel newStadium = new ItemModel(SName, SID, Stype,Slocation,Sprice,privateChecked);
                returnList.add(newStadium);
            }while (cursor.moveToNext());
        } else{
            // nothing happens. no stadium is added.
        }
        //close
        cursor.close();
        db.close();
        return returnList;
    }


}