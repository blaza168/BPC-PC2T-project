package com.blaazha.database.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLDateUtil {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String toSqlFormat(Date date) {
        return dateFormat.format(date);
    }
}
