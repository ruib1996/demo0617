package com.siwei.drs.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpMode;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileUtils
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/18 16:56
 **/

public class FileUtils {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }

    private static String FILE_PATH = "D:\\data";

    public static String download(String remoteFile,
                                  String localFile,
                                  String ip,
                                  Integer port,
                                  String username,
                                  String password,
                                  FtpMode ftpMode) {
        if (StringUtils.isBlank(localFile)) {
            return "本地保存路径及名称不能为空";
        }
        File lFile = FileUtil.file(localFile);
        Ftp ftp = null;
        try {
            // 匿名登录（无需帐号密码的FTP服务器）
            ftp = new Ftp(ip, port == null ? 21 : port, username, password);
            if (ftpMode != null) {
                ftp.setMode(ftpMode);
            }
            ftp.download(remoteFile, lFile);
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            // 关闭连接
            try {
                if (ftp != null) ftp.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (lFile.exists() && lFile.length() > 0) {
            return "success";
        } else {
            lFile.delete();
            return "download failure," + remoteFile + " maybe not exists !!";
        }
    }

}
