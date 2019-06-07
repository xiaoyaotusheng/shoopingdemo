package com.xiaoyaotu.shoopingdemo1.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dictionarylist", schema = "naogoucms", catalog = "")
public class DictionarylistEntity {
    @ApiModelProperty(value = "主键")
    private int id;
@ApiModelProperty(value = "字典名表主键（外键）")
    private int zdid;
@ApiModelProperty(value = "字典中文名")
    private String zdzwm;
@ApiModelProperty(value = "字典英文名")
    private String zdywm;
@ApiModelProperty(value = "注销标志")
    private String zxbz;
@ApiModelProperty(value = "词条代码")
    private String ctdm;
@ApiModelProperty(value = "词条名称")
    private String ctmc;
@ApiModelProperty(value = "词条类型")
    private String ctlx;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "zdid")
    public int getZdid() {
        return zdid;
    }

    public void setZdid(int zdid) {
        this.zdid = zdid;
    }

    @Basic
    @Column(name = "zdzwm")
    public String getZdzwm() {
        return zdzwm;
    }

    public void setZdzwm(String zdzwm) {
        this.zdzwm = zdzwm;
    }

    @Basic
    @Column(name = "zdywm")
    public String getZdywm() {
        return zdywm;
    }

    public void setZdywm(String zdywm) {
        this.zdywm = zdywm;
    }

    @Basic
    @Column(name = "zxbz")
    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    @Basic
    @Column(name = "ctdm")
    public String getCtdm() {
        return ctdm;
    }

    public void setCtdm(String ctdm) {
        this.ctdm = ctdm;
    }

    @Basic
    @Column(name = "ctmc")
    public String getCtmc() {
        return ctmc;
    }

    public void setCtmc(String ctmc) {
        this.ctmc = ctmc;
    }

    @Basic
    @Column(name = "ctlx")
    public String getCtlx() {
        return ctlx;
    }

    public void setCtlx(String ctlx) {
        this.ctlx = ctlx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionarylistEntity that = (DictionarylistEntity) o;
        return id == that.id &&
                zdid == that.zdid &&
                Objects.equals(zdzwm, that.zdzwm) &&
                Objects.equals(zdywm, that.zdywm) &&
                Objects.equals(zxbz, that.zxbz) &&
                Objects.equals(ctdm, that.ctdm) &&
                Objects.equals(ctmc, that.ctmc) &&
                Objects.equals(ctlx, that.ctlx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zdid, zdzwm, zdywm, zxbz, ctdm, ctmc, ctlx);
    }
}
