package com.ankur.basedemo.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormatUtil {

    public double volumeCalculated(String Length, String width, String Height) {
        double multiplication = Double.parseDouble(Length) * Double.parseDouble(width) * Double.parseDouble(Height);
        double v = multiplication / 1000000;
        DecimalFormat dFormat = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));
        String fString = dFormat.format(v);

        return Double.parseDouble(fString);
    }

    public double decimalFormat(double s) {
        DecimalFormat dFormat = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));
        String fString = dFormat.format(s);

        return Double.parseDouble(fString);
    }
}
