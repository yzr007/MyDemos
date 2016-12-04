package com.yzr.mydemos.utils;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Yangzr on 2016/12/4.
 */

public class StreamUtil {
    public static String inputStream2String(InputStream in){
        Scanner scanner = new Scanner(in, "UTF-8");
        String result = scanner.useDelimiter("\\A").next();
        scanner.close();
        return result;
    }
}
