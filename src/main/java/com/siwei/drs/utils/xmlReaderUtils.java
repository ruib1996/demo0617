package com.siwei.drs.utils;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: xmlReaderUtils
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/24 16:53
 **/

public class xmlReaderUtils {
    // public static void main(String[] args) throws Exception {
    //     var clockStart = System.currentTimeMillis();
    //     // do something
    //     System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    // }

    /**
     * @param filePath :  yml文件路径
     * @Title: indexYmlReader
     * @Description: TODO 返回yml文件中第index个ftp配置信息（封装1层）
     * @return: List<Map < String, Object>>
     * @Author: Rui Bao
     * @Date: 2024/06/17 16:08
     **/
    public List<Map<String, Object>> recvPlanXmlReader(String filePath) {
        return getRecvPlanInfo(filePath);
    }

    public List<Map<String, Object>> getRecvPlanInfo(String filePath) {
        try {
            // 创建FileSystemManager
            FileSystemManager fsManager = VFS.getManager();
            // 使用VFS解析文件
            FileObject file = fsManager.resolveFile(filePath);
            // 读取文件内容
            XPathFactory xpathFactory = XPathFactory.newInstance();
            // 创建XPath实例
            XPath xpath = xpathFactory.newXPath();

            // 建立XPath表达式
            String expression = "/interfaceFile/FileBody/SatelliteID/Title";


        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }


}
