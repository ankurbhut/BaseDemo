package com.ankur.basedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ankur.basedemo.db.DBHelper;
import com.ankur.basedemo.db.queries.CQueries;
import com.ankur.basedemo.helper.GetErrorMsg;
import com.ankur.basedemo.network.model.CGCheckPackingLineResponse;
import com.ankur.basedemo.network.servicecall.ServiceCall;
import com.ankur.basedemo.utils.CommonMethod;
import com.ankur.basedemo.utils.JavaCharactersString;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.ArrayList;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CBarcodeActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = CBarcodeActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private AppBarLayout mAppBar;
    private TextInputEditText mEtBarcode;
    private TextInputLayout mTlBarcode;
    private TextInputEditText mEtPackingLine;
    private TextInputLayout mTlPackingLine;
    private TextInputEditText mEtSoNo;
    private TextInputLayout mTlSoNo;
    private TextInputEditText mEtItemCode;
    private TextInputLayout mTlItemCode;
    private TextInputEditText mEtBatch;
    private TextInputLayout mTlBatch;
    private TextInputEditText mEtItemDescription;
    private TextInputLayout mTlItemDescription;
    private TextView mTvCartonSize;
    private TextView mTvScan;
    private TextView mTvPending;
    private CircularProgressButton mBtnSync;
    private RecyclerView mRvCG;
    private boolean CheckPalletLine = true;
    private SmoothProgressBar mMProgressBar;
    private DBHelper dbHelper;
    private CQueries cQueries;
    private double mCartonLength = 0.0;
    private double mCartonWidth = 0.0;
    private double mCartonHeight = 0.0;
    private double mCartonVolume = 0.0;
    private CQBarcodeAdapter adapter;
    private CircularProgressButton btnSync;
    private BottomSheetDialog dialog;
    private String mCartonType = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(CBarcodeActivity.this);
        cQueries = new CQueries(CBarcodeActivity.this);
        if (!cQueries.getCG().isEmpty() && cQueries.getCG() != null) {
            cQueries.DropTable();
        }

        initView();
        initToolbar();
        barcodeScan();
        initSetData();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        mAppBar = (AppBarLayout) findViewById(R.id.appBar);
        mEtBarcode = (TextInputEditText) findViewById(R.id.etBarcode);
        mTlBarcode = (TextInputLayout) findViewById(R.id.tlBarcode);
        mEtPackingLine = (TextInputEditText) findViewById(R.id.etPackingLine);
        mTlPackingLine = (TextInputLayout) findViewById(R.id.tlPackingLine);
        mEtSoNo = (TextInputEditText) findViewById(R.id.etSoNo);
        mTlSoNo = (TextInputLayout) findViewById(R.id.tlSoNo);
        mEtItemCode = (TextInputEditText) findViewById(R.id.etItemCode);
        mTlItemCode = (TextInputLayout) findViewById(R.id.tlItemCode);
        mEtBatch = (TextInputEditText) findViewById(R.id.etBatch);
        mTlBatch = (TextInputLayout) findViewById(R.id.tlBatch);
        mEtItemDescription = (TextInputEditText) findViewById(R.id.etItemDescription);
        mTlItemDescription = (TextInputLayout) findViewById(R.id.tlItemDescription);
        mTvCartonSize = (TextView) findViewById(R.id.tvCartonSize);
        mTvScan = (TextView) findViewById(R.id.tvScan);
        mTvPending = (TextView) findViewById(R.id.tvPending);
        mBtnSync = (CircularProgressButton) findViewById(R.id.btnSync);
        mBtnSync.setOnClickListener(this);
        mRvCG = (RecyclerView) findViewById(R.id.rvCG);
        mMProgressBar = (SmoothProgressBar) findViewById(R.id.mProgressBar);


    }

    //Toolbar
    private void initToolbar() {
        mToolbar.setTitle("test");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }

    private void initSetData() {
        mRvCG.setNestedScrollingEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CBarcodeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRvCG.setLayoutManager(linearLayoutManager);
        mRvCG.setItemAnimator(new DefaultItemAnimator());

    }

    private void barcodeScan() {
        ((EditText) findViewById(R.id.etBarcode)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        mTlBarcode.setError(null);
                        CommonMethod.isHideSoftKeyboard(CBarcodeActivity.this);

                        if (event == null || !event.isShiftPressed()) {

                            if (CheckPalletLine) {
                                if (String.valueOf(new JavaCharactersString().charactersString(mEtBarcode.getText().toString().trim(), 2)).equalsIgnoreCase("pl")) {
                                    if (CommonMethod.isNetworkAvailable(CBarcodeActivity.this)) {
                                        mEtPackingLine.setText(mEtBarcode.getText().toString().trim());
                                        apiCGCheckPackingLine();
                                    } else {
                                        CommonMethod.isNetworkSnackbar(CBarcodeActivity.this, findViewById(android.R.id.content), getResources().getString(R.string.no_internet_error));
                                    }
                                } else {
                                    mEtBarcode.setText(null);
                                    mTlBarcode.setError("error");
                                }
                            } else {
                                    mTlBarcode.setError("total scan" + " " + mTvCartonSize.getText().toString());
                                    mEtBarcode.setText(null);
                            }


                            return true;
                        }

                        return false;
                    }
                }
        );
    }


    private void apiCGCheckPackingLine() {
        mMProgressBar.setVisibility(View.VISIBLE);
        try {
            ServiceCall.callCGCheckPackingLine(
                    mEtPackingLine.getText().toString().trim(),
                    CBarcodeActivity.this)
                    .enqueue(new Callback<ArrayList<CGCheckPackingLineResponse>>() {
                        @Override
                        public void onResponse(Call<ArrayList<CGCheckPackingLineResponse>> call, Response<ArrayList<CGCheckPackingLineResponse>> response) {
                            mMProgressBar.setVisibility(View.GONE);
                            switch (response.code()) {
                                case 200:
                                    if (response.body().get(0).isSTATUS()) {
                                        mEtBarcode.setText(null);
                                        mTlBarcode.setError(null);

                                        mEtItemCode.setText(String.valueOf(response.body().get(0).getITEMCODE()));
                                        mEtBatch.setText(String.valueOf(response.body().get(0).getBATCH()));
                                        mEtSoNo.setText(String.valueOf(response.body().get(0).getSONO()));
                                        mEtItemDescription.setText(String.valueOf(response.body().get(0).getITEMDESC()));

                                        mTvCartonSize.setText(String.valueOf(response.body().get(0).getCartonPackSize()));

                                        mCartonLength = response.body().get(0).getCartonLength();
                                        mCartonWidth = response.body().get(0).getCartonWidth();
                                        mCartonHeight = response.body().get(0).getCartonHeight();
                                        mCartonVolume = response.body().get(0).getCartonVolume();


                                       // mBtnSync.setBackground(getResources().getDrawable(R.drawable.btn_square_shape_round));
                                        mBtnSync.setEnabled(true);

                                        CheckPalletLine = false;
                                       // mTlBarcode.setHint(getResources().getString(R.string.qc_barcode));


                                    } else {
                                        mEtItemCode.setText(null);
                                        mEtBatch.setText(null);
                                        mEtSoNo.setText(null);
                                        mEtItemDescription.setText(null);
                                        mEtBarcode.setText(null);
                                        CheckPalletLine = true;
                                        mTlBarcode.setError(response.body().get(0).getERRORMSG());
                                    }
                                    break;
                                case 400:

                                    try {
                                        new GetErrorMsg.massage(CBarcodeActivity.this, response.errorBody().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                default:
                                    break;
                            }

                        }

                        @Override
                        public void onFailure(Call<ArrayList<CGCheckPackingLineResponse>> call, Throwable t) {
                            Log.e(TAG, "onFailure---->" + t.getMessage());
                            mMProgressBar.setVisibility(View.GONE);
                            Toast.makeText(CBarcodeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            t.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
