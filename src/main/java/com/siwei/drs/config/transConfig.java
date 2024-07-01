package com.siwei.drs.config;

import cn.hutool.setting.Setting;
import com.siwei.drs.utils.settingReaderUtils;

/**
 * @ClassName: transConfig
 * @Description: TODO 错了错了
 * @Author: Rui Bao
 * @Date: 2024/06/28 16:28
 **/

public class transConfig {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        Setting setting = settingReaderUtils.settingInitializer("transConfig");
        System.out.println(setting.getByGroup("destDir", "recvplanftpconfig"));
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }
}
