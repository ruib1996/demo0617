package com.siwei.drs.config;

import com.siwei.drs.utils.ymlReaderUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: recvPlanFtpConfig
 * @Description: TODO 从ftpConfig。yml文件中加载接收计划的ftp配置项
 * @Author: Rui Bao
 * @Date: 2024/06/14 11:42
 **/

@Getter
@Setter
public class recvPlanFtpConfig {
    public final String filePath = "src/main/resources/ftpConfig.yml";
    /**
     * server ip
     */
    public final String server;

    /**
     * 端口
     */
    public final Integer port;

    /**
     * 用户
     */
    public final String user;

    /**
     * 密码
     */
    public final String pwd;

    /**
     * 服务器路径
     */
    public final String destDir;

    /**
     * 本地路径
     */
    public final String localDir;

    /**
     * 休眠时间
     */
    public final Integer sleep;

    /**
     * FTP模式
     */
    private final String mode;

    /**
     * @Title: recvPlanFtpConfig
     * @Description: TODO 将ftpConfig.yml文件中的配置项加载到recvPlanFtpConfig类中
     * @return: null
     * @Author: Rui Bao
     * @Date: 2024/06/17 16:02
     **/
    public recvPlanFtpConfig() {
        List<Map<String, Object>> ymlReader = new ymlReaderUtils().indexYmlReader(filePath, 1);
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

    public static void main(String[] args) {
        var clockStart = System.currentTimeMillis();
        recvPlanFtpConfig recvPlanFtpConfig = new recvPlanFtpConfig();
        System.out.println(recvPlanFtpConfig.server);
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }
}
