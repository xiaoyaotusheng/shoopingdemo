package com.xiaoyaotu.shoopingdemo1.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Linqi on 2019-04-23.
 */
@Entity
@Table(name = "empl_picture_infor", schema = "staffreport", catalog = "")
public class EmplPictureInforEntity {

    @ApiModelProperty(value = "主键")
    private int id ;
    @ApiModelProperty(value = "员工主键")
    private int ygId ;
    @ApiModelProperty(value = "证件主键")
    private int zjid ;
    @ApiModelProperty(value = "学历工作主键")
    private int xxgzjlid ;
    @ApiModelProperty(value = "图片路径")
    private String tpdz ;
    @ApiModelProperty(value = "图片名称")
    private String tpmc ;
    @ApiModelProperty(value = "图片创建时间")
    private Date tpcjsj ;
    @ApiModelProperty(value = "图片修改时间")
    private Date tpgxsj ;
    @ApiModelProperty(value = "备注")
    private String bz ;



}
