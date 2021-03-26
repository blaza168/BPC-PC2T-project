package com.blaazha.UI.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ScreenUtil {
    private final static Logger log = LoggerFactory.getLogger(ScreenUtil.class);

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            log.error("Clear screen error", e);
            //throw e; psssst :-)
        }
    }
}
