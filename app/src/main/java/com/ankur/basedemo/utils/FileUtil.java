package com.ankur.basedemo.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.ankur.basedemo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileUtil {
    private String TAG = FileUtil.class.getSimpleName();

    /*public void writeFile(Context context) {

        try {
            File root = new File(Environment.getExternalStorageDirectory(), context.getResources().getString(R.string.app_name));
            if (!root.exists()) {
                root.mkdirs();
            }
            File file = new File(root, "config.txt");
            if (!file.exists()) {
                FileWriter writer = new FileWriter(file);
                writer.append(BuildConfig.SERVER_URL);
                writer.flush();
                writer.close();
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }*/

    public String readFile(Context context) {
        String line = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory() +"/"+ context.getResources().getString(R.string.app_name) + "/config.txt"));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + System.getProperty("line.separator"));
            }
            fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Log.e(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage());
        }
        return line;
    }

}
