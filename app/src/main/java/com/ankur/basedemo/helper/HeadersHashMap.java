package com.ankur.basedemo.helper;

import android.content.Context;

import com.rajbarcode.pdtc.R;
import com.rajbarcode.pdtc.session.PrefUtils;
import com.rajbarcode.pdtc.utils.ConstantsUtils;
import com.rajbarcode.pdtc.utils.DeviceInfo;

import java.util.HashMap;

public class HeadersHashMap {

    public static HashMap<String, String> getHeadersMap(Context context) {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(ConstantsUtils.Headers.API_KEY, PrefUtils.getFromPrefs(context, ConstantsUtils.Headers.API_KEY, ""));
        hashMap.put(ConstantsUtils.Headers.DEVICE_ID, new DeviceInfo().getDeviceId(context));
        hashMap.put(ConstantsUtils.Headers.DEVICE_TOKEN, new DeviceInfo().getDeviceToken());
        hashMap.put(ConstantsUtils.Headers.DEVICE_NAME, new DeviceInfo().getDeviceBrand() + "-" + new DeviceInfo().getDeviceModel());
        hashMap.put(ConstantsUtils.Headers.DEVICE_VERSION, new DeviceInfo().getDeviceVersion());
        hashMap.put(ConstantsUtils.Headers.DEVICE_TYPE, context.getString(R.string.device_type));
        hashMap.put(ConstantsUtils.Headers.APP_VERSION, new DeviceInfo().getAppVersion(context));

        return hashMap;
    }
}
