package com.ankur.basedemo.network.apiinterface;

import com.ankur.basedemo.network.model.CGCheckPackingLineResponse;
import com.ankur.basedemo.utils.WebUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET(WebUtils.POST_CG_PACKING_LINE + "{PackingLineID}")
    Call<ArrayList<CGCheckPackingLineResponse>> postCCheckPackLine(@Path("PackingLineID") String userID);


   /* @FormUrlEncoded
    @POST(WebUtils.TOKEN)
    Call<LoginResponse> postLogin(
            @Field(ConstantsUtils.GrantType.GRANT_TYPE) String mGrantType,
            @Field(ConstantsUtils.Login.USER_NAME) String mUserName,
            @Field(ConstantsUtils.Login.PASSWORD) String mPassword);

    @GET(WebUtils.GET_USER_PLANT + "{userID}")
    Call<ArrayList<UserPlantResponse>> getUserPlant(@Path("userID") String userID);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CHECK_QC_BARCODE)
    Call<CheckQCBarcodeResponse> postCheckQCBarcode(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SYNC_CRET_MAPPING)
    Call<StatusResponse> postSyncCretMapping(
            @Body SyncCretMappingResponse mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMIFINISH_CHECK_PALLET_BARCODE)
    Call<CheckPalletBarcodeResponse> postCheckPalletNo(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMIFINISH_CHECK_CRET_BARCODE)
    Call<CheckSemiFinishPalletCretResponse> postSFPCheckCretNo(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMIFINISH_VERIFY_SEMI_FINSH)
    Call<StatusResponse> postSyncSFP(
            @Body SyncSFPResponse response);

    @GET(WebUtils.GET_WARE_HOUSE + "{PlantID}")
    Call<ArrayList<WareHouseResponse>> postWarehouse(
            @Path(value = "PlantID", encoded = true) int parseInt);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_CHECK_LOCATION)
    Call<SFPACheckLocationResponse> postSFPACheckLocation(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_CHECK_LOCATION)
    Call<FGPPACheckLocationResponse> postFGPPACheckLocation(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CMAPPING_VALIDATE_PACKING_LINE)
    Call<CATPLPackingLineResponse> postCATPLPackingLine(
            @Body HashMap<String, String> mBodyMap);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CMAPPING_ASSIGN_CRET)
    Call<StatusResponse> postSyncAssignCATPL(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_GET_PALLET_DETAIL)
    Call<ArrayList<SFPAPalletDetailResponse>> postSFPACheckPalletNo(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_PUT_AWAY)
    Call<SFPASyncResponse> postSFPASync(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_FGPPA)
    Call<SyncFGPPAResponse> postSyncFGPPA(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CRET_CRETFREE)
    Call<CretFreeResponse> postSyncCF(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_KITTING_PROCESS_DETAIL)
    Call<ArrayList<KPDetailsResponse>> postKPDetails(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_KITTING_QC_BARCODE_DETAIL)
    Call<ArrayList<QcBarcodeDetailResponse>> postCheckQCbarcode(
            @Body HashMap<String, String> mBodyMap);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_KITTING_BOM_DETAIL)
    Call<ArrayList<BOMDetailsResponse>> postBOMDetails(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_SFPALLET_PICKING)
    Call<StatusResponse> postPickSFPP(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_SEMI_FINISH_PALLET_DETAILS_FOR_SFPPICKING)
    Call<ArrayList<SFPPDetailsResponse>> postSFPPCheckPalletNo(
            @Body HashMap<String, String> mBodyMap);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_MPOBLG_CHECK_PACKINGLINE)
    Call<MPOBLGPackingLineResponse> postMPOBLGPackingLine(
            @Body HashMap<String, String> mBodyMap);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_KITTING_SYNC_KITTING)
    Call<StatusResponse> postSyncKp(
            @Body SyncKittingResponse response);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_MPOBLG_UPDATE_MATERPACKINGLINE)
    Call<StatusResponse> postUpdatePackingLine(
            @Body HashMap<String, String> mBodyMap);

    @GET(WebUtils.POST_PAI_InvoiceList + "{userID}")
    Call<ArrayList<InvoiceResponse>> getPAIInvoice(@Path("userID") int userID);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_PAI_Invoice_DETAILS)
    Call<ArrayList<PAIInvoiceDetailResponse>> postPAIInvoiceDetails(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_LP_Invoice_DETAILS)
    Call<ArrayList<LPInvoiceDetailResponse>> postLPInvoiceDetails(
            @Body HashMap<String, String> mBodyMap);

    @GET(WebUtils.POST_LP_InvoiceList + "{userID}")
    Call<ArrayList<InvoiceResponse>> getLPInvoice(@Path("userID") int userID);

    @GET(WebUtils.POST_FGPLG_PALLET_TYPE + "{PlantID}")
    Call<ArrayList<FGPLPalletTypeResponse>> postPalletType(
            @Path(value = "PlantID", encoded = true) int parseInt);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_FGPLG_CHK_CART_ON_BARCODE)
    Call<ArrayList<CheckCartonBarcodeResponse>> postCheckCartonBarcode(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_FG_PALLET_GENERATION_SYNC_FG_PALLET)
    Call<StatusResponse> postSyncFGPLG(
            @Body SyncFGPLGResponse response);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_PAI_LOCATION_WISE_ITEMCODE)
    Call<ArrayList<ViewPAIStockResponse>> postPAIViewStock(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_LP_VIEW_STOCK)
    Call<ArrayList<ViewLPStockResponse>> postLPViewStock(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CG_CHECK_QCBARCODE)
    Call<ArrayList<CGCheckQCBarcodeResponse>> postCGCheckQCBarcode(
            @Body HashMap<String, String> mBodyMap);


    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CARTON_GENERATION)
    Call<StatusResponse> postSyncCG(
            @Body SyncCGResponse response);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_FG_PALLET_DETAILS)
    Call<ArrayList<FGPalletResponse>> postFGPPACheckPalletNo(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_QCI_CHECK)
    Call<QCIResponse> postCheckQCI(
            @Body HashMap<String, String> mBodyMap);
*/
    /*@Headers("Content-Type: application/json")
    @POST(WebUtils.POST_PAI_verify_FG_Pallet)
    Call<ArrayList<PAIVerifyFGPalletResponse>> postPAIVerifyFGPallet(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_LP_verify_FG_Pallet)
    Call<ArrayList<LPVerifyFGPalletResponse>> postLPVerifyFGPallet(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_PAI_FG_PALLET_PICKING)
    Call<StatusResponse> postSyncPAI(
            @Body ArrayList<SyncPAIResponse> response);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_LP_FG_PALLET_PICKING)
    Call<StatusResponse> postSyncLP(
            @Body SyncLPResponse response);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_REPACK_FG_PALLET_DETAIL)
    Call<ArrayList<RepackFGPalletResponse>> postFGPalletNo(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_REPACK_UPDATE_CARTON_FOR_REPACKING)
    Call<StatusResponse> postCartonBarcodeRemove(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_ACCESS_RIGHTS)
    Call<ArrayList<UARResponse>> postUAR(
            @Body HashMap<String, String> mBodyMap);

    @Headers("Content-Type: application/json")
    @POST(WebUtils.POST_CRET_REJECTION)
    Call<ArrayList<StatusResponse>> postSyncCR(
            @Body HashMap<String, String> mBodyMap);

    @GET(WebUtils.POST_QC_INSPECTION_DEFECTLIST)
    Call<QCIDefectResponse> postDefect();

    @GET(WebUtils.POST_QC_INSPECTION_DEFECTLIST + "{defectCode}")
    Call<QCISubDefectResponse> postSubDefect(@Path("defectCode") String userID);

    @GET(WebUtils.POST_LP_CHECK_POINT)
    Call<BaseResponse<ArrayList<CheckPointResponse>>> postCheckPoint();*/
}
