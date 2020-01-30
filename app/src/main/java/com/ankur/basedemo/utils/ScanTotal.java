package com.ankur.basedemo.utils;

public class ScanTotal {

    public int total(String from, String to) {
        return (Integer.parseInt(to) - Integer.parseInt(from)) + 1;
    }

    public int scan(String scan) {
        return Integer.parseInt(scan) + 1;
    }

    public int pending(String total, String scan) {
        return Integer.parseInt(total) - Integer.parseInt(scan);
    }

    public int totalQty(String scan, int requiredQty) {
        return Integer.parseInt(scan) + requiredQty;
    }
}
