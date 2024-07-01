package com.siwei.drs.config;

import cn.hutool.setting.Setting;
import com.siwei.drs.utils.settingReaderUtils;

/**
 * @ClassName: recvPlanXpathConfig
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/28 18:25
 **/

public class recvPlanXpathConfig {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        Setting setting = settingReaderUtils.settingInitializer("recvPlanXpath");
        System.out.println(setting.getByGroup("SatLeaveTime", "RecvTask"));
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }
}
