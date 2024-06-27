package com.siwei.drs.config;

import com.siwei.drs.utils.ymlReaderUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: demodFtpConfig
 * @Description: TODO 从ftpConfig。yml文件中加载解调器ftp配置项
 * @Author: Rui Bao
 * @Date: 2024/06/14 10:26
 **/

@Getter
@Setter
@Component
public class demodFtpConfig {
    private static final String filePath = "src/main/resources/ftpConfig.yml";
    /**
     * server ip
     */
    private final String server;

    /**
     * 端口
     */
    private final Integer port;

    /**
     * 用户
     */
    private final String user;

    /**
     * 密码
     */
    private final String pwd;

    /**
     * 服务器路径
     */
    private final String destDir;

    /**
     * 本地路径
     */
    private final String localDir;

    /**
     * 休眠时间
     */
    private final Integer sleep;

    /**
     * FTP模式
     */
    private final String mode;

    public demodFtpConfig() {
        List<Map<String, Object>> ymlReader = new ymlReaderUtils().indexYmlReader(filePath, 0);
        Map<String, Object> ftpConfig = ymlReader.getFirst();
        this.server = (String) ftpConfig.get("server");
        this.port = (Integer) ftpConfig.get("port");
        this.user = (String) ftpConfig.get("user");
        this.pwd = (String) ftpConfig.get("pwd");
        this.destDir = (String) ftpConfig.get("destDir");
        this.localDir = (String) ftpConfig.get("localDir");
        this.sleep = (Integer) ftpConfig.get("sleep");
        this.mode = (String) ftpConfig.get("mode");
    }

    public static void main() {
        var clockStart = System.currentTimeMillis();
        demodFtpConfig demodFtpConfig = new demodFtpConfig();
        System.out.println(demodFtpConfig.server);
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);

    }

}