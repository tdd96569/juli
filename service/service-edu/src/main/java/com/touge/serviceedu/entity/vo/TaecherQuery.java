package com.touge.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author touge
 * @create 2020-08-04 11:22
 */
@ApiModel(value = "Teacher查询对象", description = "讲师查询封装对象")
@Data
public class TaecherQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师名称，模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 8:00:00")
    private String begin; //这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-10-01 8:00:00")
    private String end;
}
