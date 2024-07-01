package com.siwei.drs.utils;

import cn.hutool.setting.Setting;

import java.util.Objects;

/**
 * @ClassName: settingReaderUtils
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/28 15:30
 **/

public class settingReaderUtils {

    private static final String transConfig = "transConfig.setting";
    private static final String recvPlanXpath = "recvPlanXpath.setting";

/*
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        settingInitializer(settingName);
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }
*/

    public static Setting settingInitializer(String settingFileName) {
        Setting setting = null;
        if (Objects.equals(settingFileName, "transConfig")) {
            setting = new Setting(transConfig);
            System.out.println("transConfig.setting loaded!");
        } else if (Objects.equals(settingFileName, "recvPlanXpath")) {
            setting = new Setting(recvPlanXpath);
            System.out.println("recvPlanXpath.setting loaded!");
        } else {
            System.out.println("Setting file not found!");
        }
        return setting;
    }
}


