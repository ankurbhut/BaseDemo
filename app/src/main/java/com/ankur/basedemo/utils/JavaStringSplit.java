package com.ankur.basedemo.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

public class JavaStringSplit {

    public int splitGetLength(String toString) {

        String[] split = toString.split(Pattern.quote("|"));

        return split.length;
    }

    public String[] splitUsingPipe(String toString) throws Exception {
        String[] split = new String[0];
        if (!TextUtils.isEmpty(toString)) {
            split = toString.split(Pattern.quote("|"));
        }
        return split;
    }
}