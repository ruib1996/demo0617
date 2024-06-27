package com.siwei.drs.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ymlReaderUtils
 * @Description: TODO 初始输入的yml文件的filepath写在了demodFtpConfig中
 * @Author: Rui Bao
 * @Date: 2024/06/17 16:04
 **/
public class ymlReaderUtils {

    /**
     * @param filePath : yml文件路径
     * @Title: allYmlReader
     * @Description: TODO 返回yml文件中所有ftp配置信息（重载方法getFtpInfo）
     * @return: List<Map < String, Object>>
     * @Author: Rui Bao
     * @Date: 2024/06/17 16:07
     **/
    public List<Map<String, Object>> allYmlReader(String filePath) {
        return getFtpInfo(filePath, 0);
    }

    /**
     * @param filePath :  yml文件路径
     * @param index    :  第几个ftp配置信息（从1开始）
     * @Title: indexYmlReader
     * @Description: TODO 返回yml文件中第index个ftp配置信息（封装1层）
     * @return: List<Map < String, Object>>
     * @Author: Rui Bao
     * @Date: 2024/06/17 16:08
     **/
    public List<Map<String, Object>> indexYmlReader(String filePath, int index) {
        return getFtpInfo(filePath, index);
    }

    /**
     * @param filePath : yml文件路径
     * @param index    : 第几个ftp配置信息（从1开始）
     * @Title: getFtpInfo
     * @Description: TODO 获取yml文件中第index个ftp配置信息，当index为0时，返回所有ftp配置信息
     * @return: List<Map < String, Object>>
     * @Author: Rui Bao
     * @Date: 2024/06/17 16:09
     **/
    public List<Map<String, Object>> getFtpInfo(String filePath, int index) {
        // 读取配置文件
        Yaml yaml = new Yaml();
        // 初始化输入流，后续读取的文件内容要通过输入流的方式读取
        InputStream in = null;
        // 创建存储ftp配置信息的列表
        List<Map<String, Object>> ftpInfo = new ArrayList<>();

        try {
            // 读取配置文件的内容为输入流
            in = new FileInputStream(filePath);
            // 解析配置文件内容，将其转换为 Map 类型
            Map<String, Map<String, Map<String, Object>>> data = yaml.load(in);
            if (data == null || !data.containsKey("ftpconfig")) {
                throw new IllegalStateException("013002 FTP配置文件为空或不包含'ftpconfig'字段。");
            }
            // 获取 ftpconfig 下的所有配置信息，可以理解为去掉一层"ftpconfig"的外衣
            Map<String, Map<String, Object>> ftpConfigMap = data.get("ftpconfig");
            // 遍历 ftpConfigMap，将其中的配置信息添加到 ftpInfo 列表中
            if (ftpConfigMap != null) {

                /* 另一种方法，但是低效
                 获取ftpConfigMap的key值集合，也即ftpconfig下一级的所有键值，因为考虑到后续添加FTP服务端，
                 所以先获取所有键值，再根据索引获取对应的 Map
                 Set<String> keys = ftpConfigMap.keySet();
                 遍历 keys，将其对应的 Map 添加到 ftpInfo 列表中
                 for (String keyString : keys) {
                     ftpInfo.add(ftpConfigMap.get(keyString));
                 }
               */

                // 遍历 ftpConfigMap，将其中的配置信息添加到 ftpInfo 列表中
                ftpInfo.addAll(ftpConfigMap.values());
            }
        } catch (FileNotFoundException e) {
            System.out.println("配置文件不存在！");
        } finally {
            if (in != null) {
                try {
                    // 关闭输入流
                    in.close();
                } catch (IOException e) {
                    System.out.println("关闭文件流时出错！");
                }
            }
        }
        // 根据 index 值返回对应的 ftp 配置信息
        if (index == 0) {
            return ftpInfo; // 返回包含所有 Map 的列表
        } else if (index > 0) {
            // index 值大于 0，则返回包含第 index 个 Map 的列表
            // 创建目标FTP服务端的列表
            List<Map<String, Object>> singleftpInfo = new ArrayList<>();
            // 索引从 1 开始，所以减 1，返回包含第 index 个 Map 的列表
            singleftpInfo.add(ftpInfo.get(index - 1));
            return singleftpInfo;
        } else {
            return null; // 如果 index 不在合法范围内，则返回 null
        }
    }
}
