package com.xiaoyaotu.shoopingdemo1.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by Linqi on 2019-04-03.
 */
@Entity
@Table(name = "dictionarylist", schema = "staffreport", catalog = "")
public class DictionarylistEntity {
    private int id;
    @ApiModelProperty(value = "字典ID")
    private int zdid;
    @ApiModelProperty(value = "字典名称")
    private String zdmc;
    @ApiModelProperty(value = "字典代码")
    private String zddm;
    @ApiModelProperty(value = "注销标志")
    private String zxbz;
    @ApiModelProperty(value = "词条代码")
    private String ctdm;
    @ApiModelProperty(value = "词条名称")
    private String ctmc;
    @ApiModelProperty(value = "词条类型")
    private String ctlx;


}
