package com.example.swipepager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "swipePager.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "word";
    private static final String COLUMN_NAME_ID = "id";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_CONTENTS = "contents";
    private static final String COLUMN_NAME_TAGS = "tags";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ( " +
                                                        COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                                                        COLUMN_NAME_NAME + " TEXT, " +
                                                        COLUMN_NAME_CONTENTS + " TEXT, " +
                                                        COLUMN_NAME_TAGS + " TEXT " +
                                                     " )";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME ;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void createTable(SQLiteDatabase db) {
         db.execSQL(SQL_CREATE_ENTRIES);
         // db.execSQL(getInsertStr(1,"Aさん","名言1","怒り"));
         db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(1,'Aさん','名言1', '怒り');");
         db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(2,'Bさん','名言2', '激励');");
    }

    private String getInsertStr(int id, String name, String contents, String tags){
    StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" INSERT INTO " + TABLE_NAME );
        // stringBuilder.append("  ( ");
        // stringBuilder.append(COLUMN_NAME_ID + " ,");
        // stringBuilder.append(COLUMN_NAME_NAME + " ,");
        // stringBuilder.append(COLUMN_NAME_CONTENTS + " ,");
        // stringBuilder.append(COLUMN_NAME_TAGS);
        // stringBuilder.append(" ) ");
        stringBuilder.append(" VALUES ( ");
        stringBuilder.append(id + " ,");
        stringBuilder.append(" " +name + " ,");
        stringBuilder.append(contents + " ,");
        stringBuilder.append(tags);
        stringBuilder.append(" ) ; ");
        return stringBuilder.toString();
    }

    /**
     * This call needs to be made while the mCacheLock is held. The way to
     * ensure this is to get the lock any time a method is called ont the DatabaseHelper
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
        // アップデートの判別
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
