package com.ankur.basedemo.db;

import com.ankur.basedemo.utils.ConstantsUtils;

class DBConstants {


    /*Cret Mapping*/
    static final String USER_ACCESS_RIGHTS =
            "CREATE TABLE " + ConstantsUtils.dbTableName.CREATE_UAR
                    + " (" + ConstantsUtils.Headers.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ConstantsUtils.UserAccessRights.CODE + " TEXT, "
                    + ConstantsUtils.UserAccessRights.NAME + " TEXT );";

    /*Cret Mapping*/
    static final String CREATE_CRET_MAPPING =
            "CREATE TABLE " + ConstantsUtils.dbTableName.CREATE_CM
                    + " (" + ConstantsUtils.Headers.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ConstantsUtils.syncCretMapping.PLANT_ID + " TEXT, "
                    + ConstantsUtils.syncCretMapping.ITEM_CODE + " TEXT, "
                    + ConstantsUtils.syncCretMapping.BATCH + " TEXT, "
                    + ConstantsUtils.syncCretMapping.SO_NO + " TEXT, "
                    + ConstantsUtils.syncCretMapping.CRET_BARCODE + " TEXT, "
                    + ConstantsUtils.syncCretMapping.QC_SERIAL_NO + " TEXT, "
                    + ConstantsUtils.syncCretMapping.FROM_NO + " TEXT, "
                    + ConstantsUtils.syncCretMapping.TO_NO + " TEXT, "
                    + ConstantsUtils.syncCretMapping.TEMP_CRET_NO + " TEXT, "
                    + ConstantsUtils.syncCretMapping.ENTRY_BY + " TEXT ,"
                    + ConstantsUtils.syncCretMapping.Total + " TEXT ,"
                    + ConstantsUtils.syncCretMapping.TOTAL_SCAN + " TEXT ,"
                    + ConstantsUtils.syncCretMapping.TOTAL_PENDING + " TEXT ,"
                    + ConstantsUtils.syncCretMapping.KRETOX_FLAG + " TEXT );";


    /*Carton Generation*/
    static final String CARTON_GENERATION =
            "CREATE TABLE " + ConstantsUtils.dbTableName.CREATE_CG
                    + " (" + ConstantsUtils.Headers.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ConstantsUtils.syncCG.PACKING_LINE_ID + " TEXT, "
                    + ConstantsUtils.syncCG.SO_NO + " TEXT, "
                    + ConstantsUtils.syncCG.ITEM_CODE + " TEXT, "
                    + ConstantsUtils.syncCG.BATCH + " TEXT, "
                    + ConstantsUtils.syncCG.SERIAL_NO + " TEXT, "
                    + ConstantsUtils.syncCG.QC_STOCK_O_ID + " TEXT, "
                    + ConstantsUtils.syncCG.CARTON_SIZE + " TEXT, "
                    + ConstantsUtils.syncCG.TOTAL_SCAN + " TEXT, "
                    + ConstantsUtils.syncCG.TOTAL_PENDING + " TEXT, "
                    + ConstantsUtils.syncCG.CARTON_LENGTH + " TEXT, "
                    + ConstantsUtils.syncCG.CARTON_WIDTH + " TEXT, "
                    + ConstantsUtils.syncCG.CARTON_HEIGHT + " TEXT, "
                    + ConstantsUtils.syncCG.CARTON_VOLUME + " TEXT );";

}
