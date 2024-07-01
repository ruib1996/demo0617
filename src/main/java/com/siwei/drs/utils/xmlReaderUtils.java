package com.siwei.drs.utils;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;

/**
 * @ClassName: xmlReaderUtils
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/24 16:53
 **/

public class xmlReaderUtils {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        recvPlanXmlReader("D:\\data\\RECVPLAN\\RECVPLAN_SWSC_SWLGC1_SVN3-01_20240624_181046_001.xml");
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }

    public static void recvPlanXmlReader(String filePath) {
        var clockStart = System.currentTimeMillis();
        Document docResult = XmlUtil.readXML(filePath);
        // do something 1
        Object OrbitID2 = XmlUtil.getByXPath("/interfaceFile/FileBody[1]/RecvTaskList[1]/RecvTask[1]/OrbitID[1]/text()\n", docResult, XPathConstants.STRING);
        System.out.println(OrbitID2);
    }
}
