package com.xiaoyaotu.shoopingdemo1.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


/**
 * Created by Linqi on 2019-04-02.
 */
@Entity
@Table(name = "dictionary", schema = "staffreport", catalog = "")
public class DictionaryEntity {
    private Integer id;
    @ApiModelProperty(value = "字典名称")
    private String zdmc;
    @ApiModelProperty(value = "字典代码")
    private String zddm;
    @ApiModelProperty(value = "注销标志")
    private String zxbz;
    @ApiModelProperty(value = "字典类型")
    private String zdlx;


}
