package com.siwei.drs.entity;

import cn.hutool.core.date.DateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class recvPlanEntity {

    // 计划编号，9位定长
    @Column(name = "PlanID", nullable = false)
    private int planID;

    // 卫星代号
    @Column(name = "SatelliteID", nullable = false)
    private String satelliteID;

    // 数据创建时间
    @Column(name = "CreateTime")
    private DateTime createTime;

}

