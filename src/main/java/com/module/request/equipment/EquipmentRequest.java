package com.module.request.equipment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EquipmentRequest {

        @ApiModelProperty("设备编号")
        private Integer equipmentNum;
    }
