package com.xiaoyaotu.shoopingdemo1.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * Created by Linqi on 2019-04-23.
 */
public class FileVo {

    @ApiModelProperty(value = "员工主键")
    private int ygid ;
    @ApiModelProperty(value = "证件主键")
    private int zjid ;
    @ApiModelProperty(value = "学历工作主键")
    private int xxgzjlid ;
    @ApiModelProperty(value = "备注")
    private  String bz;

    public int getYgid() {
        return ygid;
    }

    public void setYgid(int ygid) {
        this.ygid = ygid;
    }

    public int getZjid() {
        return zjid;
    }

    public void setZjid(int zjid) {
        this.zjid = zjid;
    }

    public int getXxgzjlid() {
        return xxgzjlid;
    }

    public void setXxgzjlid(int xxgzjlid) {
        this.xxgzjlid = xxgzjlid;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileVo)) return false;
        FileVo fileVo = (FileVo) o;
        return ygid == fileVo.ygid &&
                zjid == fileVo.zjid &&
                xxgzjlid == fileVo.xxgzjlid &&
                bz.equals(fileVo.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ygid, zjid, xxgzjlid, bz);
    }

    @Override
    public String toString() {
        return "FileVo{" +
                "ygid=" + ygid +
                ", zjid=" + zjid +
                ", xxgzjlid=" + xxgzjlid +
                ", bz='" + bz + '\'' +
                '}';
    }
}
