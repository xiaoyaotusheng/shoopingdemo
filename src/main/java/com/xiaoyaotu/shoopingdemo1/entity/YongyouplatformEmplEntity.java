package com.xiaoyaotu.shoopingdemo1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "yongyouplatform_empl", schema = "naogoucms", catalog = "")
public class YongyouplatformEmplEntity {
    @ApiModelProperty(value = "主键")
    private int id;
@ApiModelProperty(value = "学位")
    private String xw;
@ApiModelProperty(value = "年龄")
    private String nl;
@ApiModelProperty(value = "曾用名")
    private String cym;
@ApiModelProperty(value = "出生日期")
@JsonFormat(pattern = "yyyy-MM-dd")
    private Date csrq;
@ApiModelProperty(value = "出生省份和地区")
    private String cssfhdq;
@ApiModelProperty(value = "学历")
    private String xl;
@ApiModelProperty(value = "家庭地址")
    private String jddz;
@ApiModelProperty(value = "个人身份")
    private String grsf;
@ApiModelProperty(value = "毕业专业")
    private String byzy;
@ApiModelProperty(value = "婚烟状况")
    private String hyzk;
@ApiModelProperty(value = "联系电话")
    private String lxdh;
@ApiModelProperty(value = "姓名")
    private String xm;
@ApiModelProperty(value = "民族")
    private String mz;
@ApiModelProperty(value = "籍贯")
    private String jg;
@ApiModelProperty(value = "参加工作日期")
@JsonFormat(pattern = "yyyy-MM-dd")
    private Date cjgzsj;
@ApiModelProperty(value = "性别")
    private String xb;
@ApiModelProperty(value = "更新时间")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gxsj;
@ApiModelProperty(value = "填表时间")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tjsj;


    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "XW")
    public String getXw() {
        return xw;
    }

    public void setXw(String xw) {
        this.xw = xw;
    }

    @Basic
    @Column(name = "NL")
    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    @Basic
    @Column(name = "CYM")
    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    @Basic
    @Column(name = "CSRQ")
    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    @Basic
    @Column(name = "CSSFHDQ")
    public String getCssfhdq() {
        return cssfhdq;
    }

    public void setCssfhdq(String cssfhdq) {
        this.cssfhdq = cssfhdq;
    }

    @Basic
    @Column(name = "XL")
    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    @Basic
    @Column(name = "JDDZ")
    public String getJddz() {
        return jddz;
    }

    public void setJddz(String jddz) {
        this.jddz = jddz;
    }

    @Basic
    @Column(name = "GRSF")
    public String getGrsf() {
        return grsf;
    }

    public void setGrsf(String grsf) {
        this.grsf = grsf;
    }

    @Basic
    @Column(name = "BYZY")
    public String getByzy() {
        return byzy;
    }

    public void setByzy(String byzy) {
        this.byzy = byzy;
    }

    @Basic
    @Column(name = "HYZK")
    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    @Basic
    @Column(name = "LXDH")
    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Basic
    @Column(name = "XM")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "MZ")
    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    @Basic
    @Column(name = "JG")
    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    @Basic
    @Column(name = "CJGZSJ")
    public Date getCjgzsj() {
        return cjgzsj;
    }

    public void setCjgzsj(Date cjgzsj) {
        this.cjgzsj = cjgzsj;
    }

    @Basic
    @Column(name = "XB")
    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    @Basic
    @Column(name = "GXSJ")
    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    @Basic
    @Column(name = "TJSJ")
    public Date getTjsj() {
        return tjsj;
    }

    public void setTjsj(Date tjsj) {
        this.tjsj = tjsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YongyouplatformEmplEntity that = (YongyouplatformEmplEntity) o;
        return id == that.id &&
                Objects.equals(xw, that.xw) &&
                Objects.equals(nl, that.nl) &&
                Objects.equals(cym, that.cym) &&
                Objects.equals(csrq, that.csrq) &&
                Objects.equals(cssfhdq, that.cssfhdq) &&
                Objects.equals(xl, that.xl) &&
                Objects.equals(jddz, that.jddz) &&
                Objects.equals(grsf, that.grsf) &&
                Objects.equals(byzy, that.byzy) &&
                Objects.equals(hyzk, that.hyzk) &&
                Objects.equals(lxdh, that.lxdh) &&
                Objects.equals(xm, that.xm) &&
                Objects.equals(mz, that.mz) &&
                Objects.equals(jg, that.jg) &&
                Objects.equals(cjgzsj, that.cjgzsj) &&
                Objects.equals(xb, that.xb) &&
                Objects.equals(gxsj, that.gxsj) &&
                Objects.equals(tjsj, that.tjsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xw, nl, cym, csrq, cssfhdq, xl, jddz, grsf, byzy, hyzk, lxdh, xm, mz, jg, cjgzsj, xb, gxsj, tjsj);
    }
}
