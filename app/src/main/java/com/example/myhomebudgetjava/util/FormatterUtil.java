package com.example.myhomebudgetjava.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public final class FormatterUtil {
    private FormatterUtil(){}

    public static NumberFormat formatter = new DecimalFormat("#,###.##");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
}