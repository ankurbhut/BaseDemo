package com.ankur.basedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ankur.basedemo.BuildConfig;
import com.ankur.basedemo.utils.ConstantsUtils;


public class DBHelper extends SQLiteOpenHelper {
    private String TAG = DBHelper.class.getSimpleName();

    private static final String DB_NAME = ConstantsUtils.dbName.ANKUR;
    private static final int DB_VERSION = BuildConfig.VERSION_CODE;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstants.USER_ACCESS_RIGHTS);
        db.execSQL(DBConstants.CREATE_CRET_MAPPING);
        db.execSQL(DBConstants.CARTON_GENERATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantsUtils.dbTableName.CREATE_CG);
        onCreate(db);
    }


}
