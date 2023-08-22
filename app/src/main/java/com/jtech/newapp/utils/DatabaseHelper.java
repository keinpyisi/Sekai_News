package com.jtech.newapp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jtech.newapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;




public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "tarot.db";
    private static String DB_PATH = "/data/data/com.jtech.newapp/databases/";
    private SQLiteDatabase myDataBase;
    private Context myContext = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database does't exist yet.
            e.printStackTrace();
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
            //do nothing - database already exist
            openDataBase();
        } else {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            this.close();
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = myContext.getResources().openRawResource(R.raw.tarot);
        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
        openDataBase();

    }

    public ArrayList getAllData(String name) {
        openDataBase();
        ArrayList data = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "Majorarcana" + " Where Name = '" + name + "'";
        // SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
                data.add(cursor.getString(1));
                data.add(cursor.getString(2));
                data.add(cursor.getString(3));
                data.add(cursor.getString(4));
                data.add(cursor.getString(5));
                data.add(cursor.getString(6));
                data.add(cursor.getString(7));
                data.add(cursor.getString(8));
            } while (cursor.moveToNext());
        }
        return data;
    }

    public ArrayList getMinorAllData(String name) {
        openDataBase();
        ArrayList data = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "Minorarcana" + " Where Name = '" + name + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
                data.add(cursor.getString(1));
                data.add(cursor.getString(2));
                data.add(cursor.getString(3));
                data.add(cursor.getString(4));
                data.add(cursor.getString(5));
                data.add(cursor.getString(6));
                data.add(cursor.getString(7));
                data.add(cursor.getString(8));
            } while (cursor.moveToNext());
        }
        return data;
    }

    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null){
            myDataBase.close();
        }
        super.close();
     }

    public int getMajorCount() {
        String countQuery = "SELECT  * FROM " + "Majorarcana";
        Cursor cursor = myDataBase.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}