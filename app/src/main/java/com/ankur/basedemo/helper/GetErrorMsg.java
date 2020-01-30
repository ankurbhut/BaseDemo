package com.ankur.basedemo.helper;

import android.content.Context;
import android.widget.Toast;

import com.ankur.basedemo.network.model.ErrorResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetErrorMsg {

    public static class massage {
        public massage(Context context, String msg) {
            Gson gson = new GsonBuilder().create();
            ErrorResponse mError = new ErrorResponse();
                mError = gson.fromJson(msg, ErrorResponse.class);
                Toast.makeText(context, mError.getErrorDescription(), Toast.LENGTH_LONG).show();

        }
    }
}
