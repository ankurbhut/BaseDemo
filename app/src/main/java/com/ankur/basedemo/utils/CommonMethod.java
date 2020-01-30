package com.ankur.basedemo.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.ankur.basedemo.R;
import com.google.android.material.snackbar.Snackbar;


public class CommonMethod {

    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void isNetworkSnackbar(Context context, View view, String s) {
        Snackbar snackbar = Snackbar.make(view, s, Snackbar.LENGTH_LONG);
        View sbview = snackbar.getView();
        sbview.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        TextView textView = (TextView) sbview.findViewById(R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        textView.setTextSize(16);
        textView.setAllCaps(true);
        snackbar.show();

    }
    public static void isHideSoftKeyboard(Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }
}