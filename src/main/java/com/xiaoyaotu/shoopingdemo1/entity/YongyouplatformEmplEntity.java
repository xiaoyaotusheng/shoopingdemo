package com.xiaoyaotu.shoopingdemo1.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "yongyouplatform_empl", schema = "naogoucms", catalog = "")
public class YongyouplatformEmplEntity {
    private int id;
    private String xw;
    private String nl;
    private String cym;
    private Date csrq;
    private String cssfhdq;
    private String xl;
    private String jddz;
    private String grsf;
    private String byzy;
    private String hyzk;
    private String lxdh;
    private String xm;
    private String mz;
    private String jg;
    private Date cjgzsj;
    private String xb;
    private Date gxsj;
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
