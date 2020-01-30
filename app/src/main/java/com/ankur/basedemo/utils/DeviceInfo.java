package com.ankur.basedemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

public class DeviceInfo {


    public String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public String getDeviceVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getDeviceBrand() {
        return Build.BRAND;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getDevice() {
        return Build.DEVICE;
    }

    public String getDisplay() {
        return Build.DISPLAY;
    }

    public String getBoard() {
        return Build.BOARD;
    }

    public String getHost() {
        return Build.HOST;
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getProduct() {
        return Build.PRODUCT;
    }

    public String getAppVersion(Context context) {
        PackageInfo packageInfo = null;
        {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return packageInfo.versionName;
    }

    public int getversionCode(Context context) {
        PackageInfo packageInfo = null;
        {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return packageInfo.versionCode;
    }

    public String getDeviceToken() {
        String mDeviceToken = "404";
        try {
           // mDeviceToken = FirebaseInstanceId.getInstance().getToken();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (TextUtils.isEmpty(mDeviceToken)){
            mDeviceToken = "404";
        }else if (mDeviceToken.equalsIgnoreCase("null")){
            mDeviceToken = "404";
        }

        return mDeviceToken;
    }
}
