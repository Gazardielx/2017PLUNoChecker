package com.example.nikki.plunochecker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nikki on 15/3/17.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Fresh.db";
    private SQLiteDatabase database;
    private Context context;

    public SQLiteHelper (Context context) {
        super (context, DATABASE_NAME, null , DATABASE_VERSION);
        this.context = context;
    }

    public static final String TABLE_NAME = "FRESH";
    public static final String COLUMN_BRAND = "BRAND";
    public static final String COLUMN_PRODUCTNAME = "PRODUCTNAME";
    public static final String COLUMN_SKU = "SKU";
    public static final String COLUMN_PLU = "PLU";

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("Create Table " + TABLE_NAME + " ( " + COLUMN_BRAND + " VARCHAR, " + COLUMN_PRODUCTNAME + " VARCHAR, " +
                COLUMN_SKU + " VARCHAR PRIMARY KEY, " + COLUMN_PLU + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertRecord(Fresh Product){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BRAND, Product.getBrand());
        contentValues.put(COLUMN_PRODUCTNAME, Product.getProductName());
        contentValues.put(COLUMN_SKU, Product.getSKU());
        contentValues.put(COLUMN_PLU, Product.getPLU());
        long id = database.insert(TABLE_NAME, null , contentValues);

        if (id != -1) {
            Product.setBrand("" + id);
            Toast.makeText(context, "New record inserted with Brand = " + id , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error inserting new record", Toast.LENGTH_SHORT).show();
        }
    database.close();
    }

    public ArrayList <Fresh> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query (TABLE_NAME, null, null, null,  null, null, null);

        ArrayList<Fresh> products = new ArrayList<Fresh>();
        Fresh product;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();

                product = new Fresh();
                product.setBrand(cursor.getString(0));
                product.setProductName(cursor.getString(1));
                product.setSKU(cursor.getString(2));
                product.setPLU(cursor.getString(3));

                products.add(product);
            }
        }
        cursor.close();
        database.close();

        return products;
    }



}
