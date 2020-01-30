package com.ankur.basedemo.utils;


public class ConstantsUtils {

    public static class dbName {
        public static final String PDTS = "PDTS";
    }

    public static class dbTableName {
        public static final String CREATE_UAR = "UAR"; /*User Access Rights*/
        public static final String CREATE_CM = "CM"; /*Cret Mapping*/
        public static final String CREATE_SFP = "SFP"; /*Semi-Finish Palletization*/
        public static final String CREATE_KP = "KP"; /*Kitting Process*/
        public static final String CREATE_FGPLG = "FGPLG"; /*Finished Good Pallet Label Generation*/
        public static final String CREATE_PAI = "PAI"; /*Picking Against Invoice*/
        public static final String CREATE_LP = "LP"; /*Loading Process*/
        public static final String CREATE_CG = "CG"; /*Carton Generation*/
        public static final String CREATE_CP = "CP"; /*Check Point*/
    }

    public static class UserAccessRights {
        public static final String CODE = "Code";
        public static final String NAME = "Name";
    }


    public static class Headers {
        public static final String KEY_ID = "id";
        public static final String API_KEY = "apikey";
        public static final String DEVICE_ID = "deviceid";
        public static final String DEVICE_TOKEN = "devicetoken";
        public static final String DEVICE_TYPE = "devicetype";
        public static final String DEVICE_NAME = "devicename";
        public static final String APP_VERSION = "appversion";
        public static final String DEVICE_VERSION = "deviceversion";
        public static final String TIMES_TAMP = "timestamp";
    }

    public static class Session {
        public static final String LOGIN = "Login";
        public static final String PLANT_ID = "PlantID";
        public static final String O_ID = "Oid";
    }

    public static class syncCretMapping {
        public static final String ID = "ID";
        public static final String QC_BARCODE = "QcBarcode";
        public static final String PLANT_ID = "PlantID";
        public static final String ITEM_CODE = "ItemCode";
        public static final String BATCH = "Batch";
        public static final String SO_NO = "SONO";
        public static final String CRET_BARCODE = "CretID";
        public static final String QC_SERIAL_NO = "QCSerialNo";
        public static final String FROM_NO = "FromNO";
        public static final String TO_NO = "ToNo";
        public static final String TEMP_CRET_NO = "TempCretNO";
        public static final String ENTRY_BY = "EntryBy";
        public static final String Total = "Total";
        public static final String TOTAL_SCAN = "totalScan";
        public static final String TOTAL_PENDING = "totalPending";
        public static final String KRETOX_FLAG = "KretoxSerialNo";
    }

    public static class syncCG {
        public static final String ID = "Id";
        public static final String PACKING_LINE_ID = "PackingLineID";
        public static final String SO_NO = "SONO";
        public static final String ITEM_CODE = "ItemCode";
        public static final String BATCH = "Batch";
        public static final String SERIAL_NO = "SerialNo";
        public static final String QC_STOCK_O_ID = "QCStockOid";
        public static final String CARTON_SIZE = "CartonSize";
        public static final String TOTAL_SCAN = "totalScan";
        public static final String TOTAL_PENDING = "totalPending";
        public static final String CARTON_LENGTH = "CartonLength";
        public static final String CARTON_WIDTH = "CartonWidth ";
        public static final String CARTON_HEIGHT = "CartonHeight";
        public static final String CARTON_VOLUME = "CartonVolume";

    }
}