package com.module.request.equipment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class EquipmentRequest {

        @ApiModelProperty("设备名称")
        private String equipmentName;

        @ApiModelProperty("设备id")
        private String equipmentId;

        @ApiModelProperty("设备编号")
        private Integer equipmentNum;

        @ApiModelProperty("设备SIM卡号")
        private Integer equipmentSIM;

        @ApiModelProperty("设备生产商")
        private String equipmentFirm;

        @ApiModelProperty("设备备注")
        private String equipmentRemark;

        @ApiModelProperty("设备状态")
        private String equipmentStatus;

        @ApiModelProperty("创建时间")
        private Date createdata;

    }
