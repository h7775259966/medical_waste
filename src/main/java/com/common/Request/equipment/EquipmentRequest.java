package com.common.Request.equipment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EquipmentRequest {

        @ApiModelProperty("设备编号")
        private String equipmentNum;

        @ApiModelProperty("设备名称")
        private String equipmentName;

        @ApiModelProperty("SIM卡号")
        private String equipmentSIM;

        @ApiModelProperty("设备状态")
        private int status;
    }
