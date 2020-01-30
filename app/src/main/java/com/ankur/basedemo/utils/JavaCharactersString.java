package com.ankur.basedemo.utils;

public class JavaCharactersString {

    public String charactersString(String toString,int mLength) {

        String mChars = "";
        if (toString.length() > 3) {
            mChars = toString.substring(0, mLength);
        } else {
            mChars = toString;
        }
        return mChars;
    }

}
