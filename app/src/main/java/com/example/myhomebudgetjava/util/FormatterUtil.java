package com.example.myhomebudgetjava.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class FormatterUtil {
    private FormatterUtil(){}

    public static NumberFormat formatter = new DecimalFormat("#,###.##");
}