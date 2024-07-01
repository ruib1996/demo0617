package com.siwei.drs.utils;

/**
 * @ClassName: fileUtils
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/18 16:56
 **/

public class fileUtils {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }

    private static String FILE_PATH = "D:\\data";
}
