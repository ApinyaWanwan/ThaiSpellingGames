package com.project.finalyear.thaispellinggame.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.finalyear.thaispellinggame.model.GameLearnModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Namwan on 2/14/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TFGdatabase.sqlite";
    public static final String DB_LOCATION = "/data/data/com.project.finalyear.thaispellinggame/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mDatabase != null){
            mDatabase.close();
        }
    }

    public List<GameLearnModel> getListGameLearn(){
        GameLearnModel gameLearn = null;
        List<GameLearnModel> gamelearnList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Game_Learn", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            gameLearn = new GameLearnModel(cursor.getString(0), cursor.getString(1));
            gamelearnList.add(gameLearn);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return gamelearnList;
    }

}
