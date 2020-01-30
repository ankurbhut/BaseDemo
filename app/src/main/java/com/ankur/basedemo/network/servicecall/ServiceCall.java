package com.ankur.basedemo.network.servicecall;


import android.content.Context;

import com.ankur.basedemo.network.apiinterface.APIInterface;
import com.ankur.basedemo.network.model.CGCheckPackingLineResponse;
import com.ankur.basedemo.network.remote.APIClient;

import java.util.ArrayList;

import retrofit2.Call;

public class ServiceCall {


/*
    public static Call<LoginResponse> callLogin(
            String mUserName,
            String mPassword,
            Context context) {

        return APIClient.getClient(context).create(APIInterface.class).postLogin(ConstantsUtils.GrantType.PASSWORD, mUserName, mPassword);
    }


    public static Call<ArrayList<UserPlantResponse>> callUserPlant(String userID,Context context) {
        return APIClient.getClient(context).create(APIInterface.class).getUserPlant(userID);
    }


    public static Call<CheckQCBarcodeResponse> callCheckQCBarcode(
            String ItemCode,
            String SONo,
            String CretBarcode,
            String QCSerialNO,
            String Batch,
            Context context) {


        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.ITEM_CODE, ItemCode);
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.BATCH, Batch);
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.SO_NO, SONo);
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.CRET_BARCODE, CretBarcode);
        mBodyMap.put(ConstantsUtils.CheckQCBarcode.QC_SERIAL_NO, QCSerialNO);

        HashMapLog.getHashMapLog("callCheckQCBarcode", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCheckQCBarcode(mBodyMap);
    }


    public static Call<StatusResponse> callSyncCretMapping(
            String CretID,
            String SONO,
            String ItemCode,
            String Batch,
            String FromNO,
            String ToNo,
            String TempCretNO,
            List<String> QCSerialNo,
            Context context) {


        SyncCretMappingResponse response = new SyncCretMappingResponse();
        response.setPlantID(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        response.setItemCode(ItemCode);
        response.setBatch(Batch);
        response.setSONO(SONO);
        response.setCretID(CretID);
        response.setFromNO(FromNO);
        response.setToNo(ToNo);
        response.setEntryBy(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, ""));
        response.setTempCretNO(TempCretNO);
        response.setQCSerialNo(QCSerialNo);

        return APIClient.getClient(context).create(APIInterface.class).postSyncCretMapping(response);

    }

    public static Call<CheckPalletBarcodeResponse> callSFPCheckPalletNo(
            String palletBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PALLET_ID, palletBarcode);

        HashMapLog.getHashMapLog("callSFPCheckPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCheckPalletNo(mBodyMap);
    }

    public static Call<CheckSemiFinishPalletCretResponse> callSFPCheckCretNo(
            String cretBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckSemiFinishPalletCret.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CheckSemiFinishPalletCret.CRET_ID, cretBarcode);

        HashMapLog.getHashMapLog("callSFPCheckCretNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSFPCheckCretNo(mBodyMap);
    }

    public static Call<StatusResponse> callSyncSFP(
            List<SyncSFP> syncSFPSList,
            List<String> cretBarcodeList,
            Context context) {

        SyncSFP db = syncSFPSList.get(0);
        SyncSFPResponse response = new SyncSFPResponse();

        response.setPlantID(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
        response.setSFPalletID(db.getSFPalletID());
        response.setCretBrCode(cretBarcodeList);
        response.setSONO(Integer.parseInt(db.getSONO()));
        response.setTotalCret(syncSFPSList.size());
        response.setAvaiCret(String.valueOf(syncSFPSList.size()));
        response.setEntryBy(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, "")));

        return APIClient.getClient(context).create(APIInterface.class).postSyncSFP(response);

    }

    public static Call<ArrayList<WareHouseResponse>> callWarehouse(
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).postWarehouse(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
    }

    public static Call<SFPACheckLocationResponse> callSFPACheckLocation(
            String mWareHouseId,
            String barcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckLocation.WH_ID, mWareHouseId);
        mBodyMap.put(ConstantsUtils.CheckLocation.LOCATION_CODE, barcode);

        HashMapLog.getHashMapLog("callSFPACheckLocation", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSFPACheckLocation(mBodyMap);
    }

    public static Call<FGPPACheckLocationResponse> callFGPPACheckLocation(
            String mWareHouseId,
            String barcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckLocation.WH_ID, mWareHouseId);
        mBodyMap.put(ConstantsUtils.CheckLocation.LOCATION_CODE, barcode);

        HashMapLog.getHashMapLog("callFGPPACheckLocation", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postFGPPACheckLocation(mBodyMap);
    }

    public static Call<CATPLPackingLineResponse> callCATPLPackingLine(
            String mPackingLine,
            String mCret,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CATPLPackingLine.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CATPLPackingLine.PACKING_LINE_ID, mPackingLine);
        mBodyMap.put(ConstantsUtils.CATPLPackingLine.CRET_ID, mCret);

        HashMapLog.getHashMapLog("callCATPLPackingLine", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCATPLPackingLine(mBodyMap);
    }

    public static Call<StatusResponse> callSyncAssignCATPL(
            String mEtPackingLine,
            String mEtCret,
            String mEtItemCode,
            String mEtBatch,
            String mEtPalletNo,
            String mEtNoOfBox,
            String mEtSoNo,
            String mEtItemDescription,
            boolean isOBP,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.PACKING_LINE_ID, mEtPackingLine);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.CRET_ID, mEtCret);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.PALLET_ID, mEtPalletNo);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.SONO, mEtSoNo);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.ITEM_CODE, mEtItemCode);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.BATCH, mEtBatch);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.TOTAL_QTY, mEtNoOfBox);
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.OUTER_PRINT, String.valueOf(isOBP));
        mBodyMap.put(ConstantsUtils.CATPLAssignCret.ASSIGN_BY, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, ""));


        HashMapLog.getHashMapLog("callSyncAssignCATPL", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSyncAssignCATPL(mBodyMap);
    }

    public static Call<ArrayList<SFPAPalletDetailResponse>> callSFPACheckPalletNo(
            String palletBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PALLET_ID, palletBarcode);

        HashMapLog.getHashMapLog("callSFPACheckPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSFPACheckPalletNo(mBodyMap);
    }

    public static Call<ArrayList<FGPalletResponse>> callFGPPACheckPalletNo(
            String palletBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.FGPPACheckPalletNo.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.FGPPACheckPalletNo.FG_BARCODE, palletBarcode);

        HashMapLog.getHashMapLog("callFGPPACheckPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postFGPPACheckPalletNo(mBodyMap);
    }

    public static Call<SFPASyncResponse> callSFPASync(
            String mLocationBarcode,
            String mPalletNo,
            int mPutAwayBy,
            String mWareHouseId,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.SFPASync.PUT_AWAY_BY, String.valueOf(mPutAwayBy));
        mBodyMap.put(ConstantsUtils.SFPASync.LOCATION_ID, mLocationBarcode);
        mBodyMap.put(ConstantsUtils.SFPASync.SF_PALLET_ID, mPalletNo);
        mBodyMap.put(ConstantsUtils.SFPASync.WH_ID, mWareHouseId);

        HashMapLog.getHashMapLog("callSFPASync", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSFPASync(mBodyMap);
    }

    public static Call<SyncFGPPAResponse> callSyncFGPPA(
            String mLocationBarcode,
            String mPalletNo,
            int mPutAwayBy,
            String mWareHouseId,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.FGPPASync.FG_PALLET_ID, String.valueOf(mPalletNo));
        mBodyMap.put(ConstantsUtils.FGPPASync.LOCATION_ID, mLocationBarcode);
        mBodyMap.put(ConstantsUtils.FGPPASync.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.FGPPASync.WH_ID, mWareHouseId);
        mBodyMap.put(ConstantsUtils.FGPPASync.PUT_AWAY_BY, String.valueOf(mPutAwayBy));

        HashMapLog.getHashMapLog("callSyncFGPPA", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSyncFGPPA(mBodyMap);
    }

    public static Call<CretFreeResponse> callSyncCF(
            String mCretBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CretFree.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CretFree.CRET_ID, mCretBarcode);

        HashMapLog.getHashMapLog("callSyncCF", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSyncCF(mBodyMap);
    }

    public static Call<ArrayList<KPDetailsResponse>> callKPDetails(
            String sono,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.KPDetails.SO_NO, sono);

        HashMapLog.getHashMapLog("callKPDetails", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postKPDetails(mBodyMap);
    }

    public static Call<ArrayList<QcBarcodeDetailResponse>> callCheckQCbarcode(
            String qc,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.QCBarcodeDetail.BARCODE, qc);

        HashMapLog.getHashMapLog("CheckQCbarcode", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCheckQCbarcode(mBodyMap);
    }

    public static Call<ArrayList<BOMDetailsResponse>> callBOMDetails(
            String item_code,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.BOMDetail.ITEM_CODE, item_code);

        HashMapLog.getHashMapLog("BOMDetails", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postBOMDetails(mBodyMap);
    }

    public static Call<StatusResponse> callPickSFPP(
            String SFPalletID,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.sfPalletPicking.ENTRY_BY, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, ""));
        mBodyMap.put(ConstantsUtils.sfPalletPicking.SF_PALLET_ID, SFPalletID);

        HashMapLog.getHashMapLog("callPickSFPP", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postPickSFPP(mBodyMap);
    }

    public static Call<ArrayList<SFPPDetailsResponse>> callSFPPCheckPalletNo(
            String palletBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CheckPalletBarcode.PALLET_ID, palletBarcode);

        HashMapLog.getHashMapLog("callSFPPCheckPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSFPPCheckPalletNo(mBodyMap);
    }

    public static Call<MPOBLGPackingLineResponse> callMPOBLGPackingLine(
            String pakingLine,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.checkPackingLine.PACKING_LINE_ID, pakingLine);

        HashMapLog.getHashMapLog("callMPOBLGPackingLine", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postMPOBLGPackingLine(mBodyMap);
    }

    public static Call<StatusResponse> callSyncKp(
            String SONo,
            String ItemCode,
            String Batch,
            List<String> qcBarcodeList,
            Context context) {


        SyncKittingResponse response = new SyncKittingResponse();
        response.setPlantID(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
        response.setItemCode(ItemCode);
        response.setBatch(Batch);
        response.setSONo(Integer.parseInt(SONo));
        response.setKretoxFlag(false);
        response.setIsParrent(true);
        response.setPrintBy(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, "")));
        response.setBarcode(qcBarcodeList);

        return APIClient.getClient(context).create(APIInterface.class).postSyncKp(response);

    }

    public static Call<StatusResponse> callUpdatePackingLine(
            long WIPPackingLineOid,
            String mPackingLine,
            String mEcBarcode,
            String printerIP,
            boolean isOutBoxPrint,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.WIP_PACKING_LINE_OID, String.valueOf(WIPPackingLineOid));
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.PACKING_LINE, mPackingLine);
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.BARCODE, mEcBarcode);
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.PRINTER_IP, printerIP);
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.OUTER_PRINT, String.valueOf(isOutBoxPrint));
        mBodyMap.put(ConstantsUtils.UpdatePackingLine.SCAN_BY, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callUpdatePackingLine", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postUpdatePackingLine(mBodyMap);
    }

    public static Call<ArrayList<InvoiceResponse>> callPAIInvoice(
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).getPAIInvoice(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
    }

    public static Call<ArrayList<PAIInvoiceDetailResponse>> callPAIInvoiceDetails(
            String strInvoiceNo,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.InvoiceDetail.STR_INVOICENO, strInvoiceNo);
        mBodyMap.put(ConstantsUtils.InvoiceDetail.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callPAIInvoiceDetails", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postPAIInvoiceDetails(mBodyMap);
    }
    public static Call<ArrayList<LPInvoiceDetailResponse>> callLPInvoiceDetails(
            String strInvoiceNo,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.InvoiceDetail.STR_INVOICENO, strInvoiceNo);
        mBodyMap.put(ConstantsUtils.InvoiceDetail.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callPAIInvoiceDetails", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postLPInvoiceDetails(mBodyMap);
    }

    public static Call<ArrayList<InvoiceResponse>> callLPInvoice(
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).getLPInvoice(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
    }

    public static Call<ArrayList<FGPLPalletTypeResponse>> callPalletType(
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).postPalletType(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
    }

    public static Call<ArrayList<CheckCartonBarcodeResponse>> callCheckCartonBarcode(
            String qc,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CheckCartonBarcode.CART_ON_BARCODE, qc);
        mBodyMap.put(ConstantsUtils.CheckCartonBarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callCheckCartonBarcode", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCheckCartonBarcode(mBodyMap);
    }

    public static Call<StatusResponse> callSyncFGPLG(
            String mPalletLength,
            String mPalletWidth,
            String mPalletHeight,
            String mGrossWeight,
            String mPalletVolume,
            String mPalletType,
            String SONo,
            String ItemCode,
            String Batch,
            String printerIP,
            String heatNumber,
            List<String> cartonBarcodeList,
            Context context) {


        SyncFGPLGResponse response = new SyncFGPLGResponse();
        response.setPlantID(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
        response.setItemCode(ItemCode);
        response.setBatch(Batch);
        response.setSONo(Integer.parseInt(SONo));
        response.setPrintBy(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, "")));
        response.setCreatedBy(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, "")));
        response.setPalletLength(Double.parseDouble(mPalletLength));
        response.setPalletWidth(Double.parseDouble(mPalletWidth));
        response.setPalletHeight(Double.parseDouble(mPalletHeight));
        response.setFGPalletGrossWt(Double.parseDouble(mGrossWeight));
        response.setFGPalletVolume(Double.parseDouble(mPalletVolume));
        response.setFGPalletType(mPalletType);
        response.setCartonBarcode(cartonBarcodeList);
        response.setPrinterIP(printerIP);
        response.setHeatNo(heatNumber);
        response.setScannerID(new DeviceInfo().getDeviceId(context));

        return APIClient.getClient(context).create(APIInterface.class).postSyncFGPLG(response);

    }

    public static Call<ArrayList<ViewPAIStockResponse>> callPAIViewStock(
            String itemCode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.PAIViewStock.ITEM_CODE, itemCode);
        mBodyMap.put(ConstantsUtils.PAIViewStock.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callPAIViewStock", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postPAIViewStock(mBodyMap);
    }

    public static Call<ArrayList<ViewLPStockResponse>> callLPViewStock(
            String invoice,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.LPViewStock.STR_INVOICE_NO, invoice);
        mBodyMap.put(ConstantsUtils.LPViewStock.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callLPViewStock", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postLPViewStock(mBodyMap);
    }

*/

    public static Call<ArrayList<CGCheckPackingLineResponse>> callCGCheckPackingLine(
            String pakingLine,
            Context context) {

        return APIClient.getClient(context).create(APIInterface.class).postCCheckPackLine(pakingLine);
    }


  /*  public static Call<ArrayList<CGCheckQCBarcodeResponse>> callCGCheckQCBarcode(
            String mPackingLineID,
            String mSoNo,
            String mItemCode,
            String mBatch,
            String mSerialNo,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.PACKING_LINE_ID, mPackingLineID);
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.ITEM_CODE, mItemCode);
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.BATCH, mBatch);
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.SONO, mSoNo);
        mBodyMap.put(ConstantsUtils.CGCheckQcbarcode.SERIAL_NO, mSerialNo);

        HashMapLog.getHashMapLog("callCGCheckQCBarcode", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCGCheckQCBarcode(mBodyMap);
    }

    public static Call<StatusResponse> callSyncCG(
            String packingLineID,
            String soNO,
            String itemCode,
            String batch,
            String serialNo,
            int cartonSize,
            int totalScan,
            int totalPending,
            double getmCartonLength,
            double getmCartonWidth,
            double getmCartonHeight,
            double getmCartonVolume,
            String mCartonType,
            List<Integer> qCStockOidList,
            Context context) {


        SyncCGResponse response = new SyncCGResponse();
        response.setPlantID(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));
        response.setItemCode(itemCode);
        response.setProPlanDetlOid(0);
        response.setBatch(batch);
        response.setSONo(Integer.parseInt(soNO));
        response.setCreatedBy(Integer.parseInt(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, "")));
        response.setScannerID(new DeviceInfo().getDeviceId(context));
        response.setCartonType(mCartonType);
        response.setCartonLength(getmCartonLength);
        response.setCartonWidth(getmCartonWidth);
        response.setCartonHeight(getmCartonHeight);
        response.setCartonVolume(getmCartonVolume);
        response.setQCStockOid(qCStockOidList);

        return APIClient.getClient(context).create(APIInterface.class).postSyncCG(response);

    }

    public static Call<QCIResponse> callCheckQCI(
            String qcBarcode,
            boolean isCheckFlag,
            List<String> defectNameList,
            Context context) {


        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.QCICheck.BARCODE, qcBarcode);
        mBodyMap.put(ConstantsUtils.QCICheck.QC_INSPECTION, String.valueOf(isCheckFlag));
        mBodyMap.put(ConstantsUtils.QCICheck.DEFECT_NAME,  TextUtils.join(", ", defectNameList));

        HashMapLog.getHashMapLog("callCheckQCI", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCheckQCI(mBodyMap);
    }

    public static Call<ArrayList<PAIVerifyFGPalletResponse>> callPAIVerifyFGPallet(
            String barcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.PAIVerifyFGPallet.BARCODE, barcode);
        mBodyMap.put(ConstantsUtils.PAIVerifyFGPallet.PLANT_ID, String.valueOf(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));

        HashMapLog.getHashMapLog("callPAIVerifyFGPallet", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postPAIVerifyFGPallet(mBodyMap);
    }

    public static Call<ArrayList<LPVerifyFGPalletResponse>> callLPVerifyFGPallet(
            String barcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.LPVerifyFGPallet.BARCODE, barcode);
        mBodyMap.put(ConstantsUtils.LPVerifyFGPallet.PLANT_ID, String.valueOf(PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, "")));

        HashMapLog.getHashMapLog("callLPVerifyFGPallet", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postLPVerifyFGPallet(mBodyMap);
    }

    public static Call<StatusResponse> callSyncPAI(
            ArrayList<SyncPAIResponse> barcodeList,
            Context context) {

        return APIClient.getClient(context).create(APIInterface.class).postSyncPAI(barcodeList);

    }


    public static Call<StatusResponse> callSyncLP(
            SyncLPResponse response,
            Context context) {

        return APIClient.getClient(context).create(APIInterface.class).postSyncLP(response);

    }

    public static Call<ArrayList<RepackFGPalletResponse>> callFGPalletNo(
            String palletBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.RepackFGPallet.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.RepackFGPallet.FG_BARCODE, palletBarcode);

        HashMapLog.getHashMapLog("callFGPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postFGPalletNo(mBodyMap);
    }

    public static Call<StatusResponse> callCartonBarcodeRemove(
            String cartonBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CartonForRepacking.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CartonForRepacking.CARTON_BARCODE, cartonBarcode);

        HashMapLog.getHashMapLog("callFGPalletNo", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postCartonBarcodeRemove(mBodyMap);
    }

    public static Call<ArrayList<UARResponse>> callUAR(
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.UAR.ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.O_ID, ""));
        mBodyMap.put(ConstantsUtils.UAR.PLANT_O_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));

        HashMapLog.getHashMapLog("callUAR", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postUAR(mBodyMap);
    }

    public static Call<ArrayList<StatusResponse>> callSyncCR(
            String mCretBarcode,
            Context context) {

        HashMap<String, String> mBodyMap = new HashMap<String, String>();
        mBodyMap.put(ConstantsUtils.CretRejection.PLANT_ID, PrefUtils.getFromPrefs(context, ConstantsUtils.Session.PLANT_ID, ""));
        mBodyMap.put(ConstantsUtils.CretRejection.CRET_ID, mCretBarcode);

        HashMapLog.getHashMapLog("callSyncCR", mBodyMap);

        return APIClient.getClient(context).create(APIInterface.class).postSyncCR(mBodyMap);
    }

    public static Call<QCIDefectResponse> callDefect(
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).postDefect();
    }

    public static Call<QCISubDefectResponse> callSubDefect(
            String mDefectID,
            Context context) {
        return APIClient.getClient(context).create(APIInterface.class).postSubDefect(mDefectID);
    }


    public static Call<BaseResponse<ArrayList<CheckPointResponse>>> callCheckPoint(Context context) {
        return APIClient.getClient(context).create(APIInterface.class).postCheckPoint();
    }*/
}
