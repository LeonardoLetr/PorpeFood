package com.uniso.lpdm.porpefood;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DBPorpeFood";
    private static final int DB_VERSION = 1;

    DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDB(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDB(db, oldVersion, newVersion);
    }

    public static void insertOrder(SQLiteDatabase db, String name, String description, double unit_price, int image_resource_id) {
        ContentValues newRequest = new ContentValues();
        newRequest.put("name", name);
        newRequest.put("description", description);
        newRequest.put("unit_price", unit_price);
        newRequest.put("image_resource_id", image_resource_id);

        db.insert("Request", null, newRequest);
    }

    private void updateDB(SQLiteDatabase db,  int oldVersion, int newVersion) {
        String sql;

        if (oldVersion < 1) {
            sql =   "CREATE TABLE Request (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "description TEXT," +
                    "unit_price REAL," +
                    "image_resource_id INTEGER" +
                    ");";

            db.execSQL(sql);

            insertOrder(db,"Lasanha", "lasanha de carne", 44.99, R.drawable.Lasanha);
            insertOrder(db,"Macarrão", "macarrão a bolonhesa", 38.99, R.drawable.Macarrao);
            insertOrder(db,"Porpeta", "porpeta ao molho", 29.99, R.drawable.Porpeta);
        }
    }
}
