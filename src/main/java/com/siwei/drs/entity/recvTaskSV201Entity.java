package com.siwei.drs.entity;

import cn.hutool.core.date.DateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: recvTaskSV201Entity
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/13 21:07
 **/

@Entity
@Getter
@Setter
public class recvTaskSV201Entity {

    // 计划编号，9位定长
    @Column(name = "PlanID")
    private int planID;

    // 任务编号
    @Id
    @Column(name = "RecvID")
    private int recvID;

    // 卫星进站时间
    @Column(name = "SatArriveTime")
    private DateTime satArriveTime;

    // 卫星出站时间
    @Column(name = "SatLeaveTime")
    private DateTime satLeaveTime;

    // 接收开始时刻（卫星数传开机后用于每次数据下行起始的时间）
    @Column(name = "DataRecBeginTime")
    private DateTime dataRecBeginTime;

    // 接收结束时刻（卫星数传开机后用于每次数据下行结束的时间）
    @Column(name = "DataRecEndTime")
    private DateTime dataRecEndTime;

    // 数传速率
    /*对于SV2-01/02：0-5
        0=2*900M
        1=1 通道900M
        2=2 通道900M
        3=2*450M
        4=1 通道450M
        5=2 通道450M
    对于SVN3-01：600、900、1200*/
    @Column(name = "DownloadSpeed")
    private int downloadSpeed;

    // 传输通道
    /*1：通道1
    2：通道2
    1,2：双通道*/
    @Column(name = "DownloadSpeed")
    private String channelID;

    // 数据创建时间
    @Column(name = "CreateTime")
    private DateTime createTime;

    // 数据最后一次更新时间
    @Column(name = "UpdateTime")
    private DateTime updateTime;
}

