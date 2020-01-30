package com.ankur.basedemo.helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapLog {

    private static String TAG = HashMapLog.class.getSimpleName();

    public static void getHashMapLog(String tag, HashMap<String, String> mBodyMap) {


        Set<Entry<String, String>> entrySet = mBodyMap.entrySet();
        ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String, String>>(entrySet);

        for (Entry<String, String> entry : listOfEntry) {
            Log.v(TAG, "  " + tag + " --- > " + entry.getKey() + " : " + entry.getValue());
        }
    }
}
