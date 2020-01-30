package com.ankur.basedemo.db.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ankur.basedemo.db.DBHelper;
import com.ankur.basedemo.db.dbmodel.SyncCG;
import com.ankur.basedemo.utils.ConstantsUtils;

import java.util.ArrayList;
import java.util.List;

public class CQueries {

    private final DBHelper dbHelper;
    private Context context;

    public CQueries(Context context) {
        this.context = context;
        this.dbHelper = new DBHelper(context);
    }


    public void insertCG(SyncCG bean) throws SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConstantsUtils.syncCG.PACKING_LINE_ID, String.valueOf(bean.getPackingLineID()));
        values.put(ConstantsUtils.syncCG.SO_NO, String.valueOf(bean.getSoNO()));
        values.put(ConstantsUtils.syncCG.ITEM_CODE, String.valueOf(bean.getItemCode()));
        values.put(ConstantsUtils.syncCG.BATCH, String.valueOf(bean.getBatch()));
        values.put(ConstantsUtils.syncCG.SERIAL_NO, String.valueOf(bean.getSerialNo()));
        values.put(ConstantsUtils.syncCG.QC_STOCK_O_ID, String.valueOf(bean.getqCStockOid()));
        values.put(ConstantsUtils.syncCG.CARTON_SIZE, String.valueOf(bean.getCartonSize()));
        values.put(ConstantsUtils.syncCG.TOTAL_SCAN, String.valueOf(bean.getTotalScan()));
        values.put(ConstantsUtils.syncCG.TOTAL_PENDING, String.valueOf(bean.getTotalPending()));
        values.put(ConstantsUtils.syncCG.CARTON_LENGTH, String.valueOf(bean.getmCartonLength()));
        values.put(ConstantsUtils.syncCG.CARTON_WIDTH, String.valueOf(bean.getmCartonWidth()));
        values.put(ConstantsUtils.syncCG.CARTON_HEIGHT, String.valueOf(bean.getmCartonHeight()));
        values.put(ConstantsUtils.syncCG.CARTON_VOLUME, String.valueOf(bean.getmCartonVolume()));


        db.insert(ConstantsUtils.dbTableName.CREATE_CG, null, values);
        db.close();

    }


    public void updateVolume(SyncCG bean) throws SQLException {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConstantsUtils.syncCG.CARTON_LENGTH, String.valueOf(bean.getmCartonLength()));
        values.put(ConstantsUtils.syncCG.CARTON_WIDTH, String.valueOf(bean.getmCartonWidth()));
        values.put(ConstantsUtils.syncCG.CARTON_HEIGHT, String.valueOf(bean.getmCartonHeight()));
        values.put(ConstantsUtils.syncCG.CARTON_VOLUME, String.valueOf(bean.getmCartonVolume()));

        db.update(ConstantsUtils.dbTableName.CREATE_CG, values, ConstantsUtils.syncCG.CARTON_LENGTH + " = ", new String[]{String.valueOf(bean.getmCartonLength())});
        db.close();
    }

    public void DropTable() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + ConstantsUtils.dbTableName.CREATE_CG);
        db.close();
    }


    public List<SyncCG> getCG() {
        List<SyncCG> CGDBList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + ConstantsUtils.dbTableName.CREATE_CG;

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    SyncCG contact = new SyncCG();
                    contact.setId(cursor.getInt(0));
                    contact.setPackingLineID(cursor.getString(1));
                    contact.setSoNO(cursor.getString(2));
                    contact.setItemCode(cursor.getString(3));
                    contact.setBatch(cursor.getString(4));
                    contact.setSerialNo(cursor.getString(5));
                    contact.setqCStockOid(Integer.parseInt(cursor.getString(6)));
                    contact.setCartonSize(Integer.parseInt(cursor.getString(7)));
                    contact.setTotalScan(Integer.parseInt(cursor.getString(8)));
                    contact.setTotalPending(Integer.parseInt(cursor.getString(9)));
                    contact.setmCartonLength(Double.parseDouble(cursor.getString(10)));
                    contact.setmCartonWidth(Double.parseDouble(cursor.getString(11)));
                    contact.setmCartonHeight(Double.parseDouble(cursor.getString(12)));
                    contact.setmCartonVolume(Double.parseDouble(cursor.getString(13)));


                    CGDBList.add(contact);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
            cursor.close();
        }


        return CGDBList;

    }

}
