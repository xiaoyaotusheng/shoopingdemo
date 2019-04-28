package com.xiaoyaotu.shoopingdemo1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Linqi on 2019-04-27.
 */
@Entity
@Table(name = "yongyouplatform_empl", schema = "staffreport", catalog = "")
public class YongyouplatformEmplEntity {
    private int id;
    private String xw;
    private String hkxz;
    private String nl;
    private String cym;
    private Date csrq;
    private String xx;
    private String cssfhdq;
    private String zjlx;
    private String xl;
    private String crzh;
    private String rzly;
    private String hdlyrybh;
    private String jkzk;
    private String jtdz;
    private String zjhm;
    private String grsf;
    private String gszxkcjxjy;
    private String gszxkcsylr;
    private String gszxkczfdk;
    private String gszxkczfzj;
    private String gszxkcznjy;
    private String byzy;
    private String hyzk;
    private String sj;
    private String xm;
    private String mz;
    private String jg;
    private String bgdh;
    private Date cjgzrq;
    private String hjdz;
    private String zzmm;
    private String cyrylb;
    private String zyzg;
    private String zhuanyjsjb;
    private String hkszd;
    private String gl;
    private Date glny;
    private String xb;
    private String zyjszw;
    private String byyx;
    private String zhiyjsjb;
    private String zgfl;
    private int ygid;
    private Date  gxsj;

    @Basic
    @Column(name = "GXSJ")
    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    @Basic
    @Column(name = "YGID")
    public int getYgid() {
        return ygid;
    }

    public void setYgid(int ygid) {
        this.ygid = ygid;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACADEMIC_DEGREE")
    public String getXw() {
        return xw;
    }

    public void setXw(String xw) {
        this.xw = xw;
    }

    @Basic
    @Column(name = "ACCOUNT_CHARACTER")
    public String getHkxz() {
        return hkxz;
    }

    public void setHkxz(String hkxz) {
        this.hkxz = hkxz;
    }

    @Basic
    @Column(name = "AGE")
    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    @Basic
    @Column(name = "BEFORE_NAME")
    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    @Basic
    @Column(name = "BIRTH_DATE")
    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    @Basic
    @Column(name = "BLOOD_TYPE")
    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    @Basic
    @Column(name = "BORN_PROVINCES_AND_REGIONS")
    public String getCssfhdq() {
        return cssfhdq;
    }

    public void setCssfhdq(String cssfhdq) {
        this.cssfhdq = cssfhdq;
    }

    @Basic
    @Column(name = "DOCUMENT_TYPE")
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    @Basic
    @Column(name = "EDUCATION")
    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    @Basic
    @Column(name = "ENTRY_CARD_NUMBER")
    public String getCrzh() {
        return crzh;
    }

    public void setCrzh(String crzh) {
        this.crzh = crzh;
    }

    @Basic
    @Column(name = "ENTRY_SOURCE")
    public String getRzly() {
        return rzly;
    }

    public void setRzly(String rzly) {
        this.rzly = rzly;
    }

    @Basic
    @Column(name = "HDLY_PERSONNEL_NUMBER")
    public String getHdlyrybh() {
        return hdlyrybh;
    }

    public void setHdlyrybh(String hdlyrybh) {
        this.hdlyrybh = hdlyrybh;
    }

    @Basic
    @Column(name = "HEALTH")
    public String getJkzk() {
        return jkzk;
    }

    public void setJkzk(String jkzk) {
        this.jkzk = jkzk;
    }

    @Basic
    @Column(name = "HOME_ADDRESS")
    public String getJtdz() {
        return jtdz;
    }

    public void setJtdz(String jtdz) {
        this.jtdz = jtdz;
    }

    @Basic
    @Column(name = "ID_NUMBER")
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    @Basic
    @Column(name = "IDENTITY")
    public String getGrsf() {
        return grsf;
    }

    public void setGrsf(String grsf) {
        this.grsf = grsf;
    }

    @Basic
    @Column(name = "INDIVIDUAL_TAX_DEDUCTION_JXJY")
    public String getGszxkcjxjy() {
        return gszxkcjxjy;
    }

    public void setGszxkcjxjy(String gszxkcjxjy) {
        this.gszxkcjxjy = gszxkcjxjy;
    }

    @Basic
    @Column(name = "INDIVIDUAL_TAX_DEDUCTION_SYLR")
    public String getGszxkcsylr() {
        return gszxkcsylr;
    }

    public void setGszxkcsylr(String gszxkcsylr) {
        this.gszxkcsylr = gszxkcsylr;
    }

    @Basic
    @Column(name = "INDIVIDUAL_TAX_DEDUCTION_ZFDK")
    public String getGszxkczfdk() {
        return gszxkczfdk;
    }

    public void setGszxkczfdk(String gszxkczfdk) {
        this.gszxkczfdk = gszxkczfdk;
    }

    @Basic
    @Column(name = "INDIVIDUAL_TAX_DEDUCTION_ZFZJ")
    public String getGszxkczfzj() {
        return gszxkczfzj;
    }

    public void setGszxkczfzj(String gszxkczfzj) {
        this.gszxkczfzj = gszxkczfzj;
    }

    @Basic
    @Column(name = "INDIVIDUAL_TAX_DEDUCTION_ZN")
    public String getGszxkcznjy() {
        return gszxkcznjy;
    }

    public void setGszxkcznjy(String gszxkcznjy) {
        this.gszxkcznjy = gszxkcznjy;
    }

    @Basic
    @Column(name = "MAJOR")
    public String getByzy() {
        return byzy;
    }

    public void setByzy(String byzy) {
        this.byzy = byzy;
    }

    @Basic
    @Column(name = "MARITAL_STATUS")
    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    @Basic
    @Column(name = "MOBILEPHONE")
    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    @Basic
    @Column(name = "NAME")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "NATION")
    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    @Basic
    @Column(name = "NATIVEPLACE")
    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    @Basic
    @Column(name = "OFFICEPHONE")
    public String getBgdh() {
        return bgdh;
    }

    public void setBgdh(String bgdh) {
        this.bgdh = bgdh;
    }

    @Basic
    @Column(name = "PARTICIPATION_DATE")
    public Date getCjgzrq() {
        return cjgzrq;
    }

    public void setCjgzrq(Date cjgzrq) {
        this.cjgzrq = cjgzrq;
    }

    @Basic
    @Column(name = "PERMANENT_ADDRESS")
    public String getHjdz() {
        return hjdz;
    }

    public void setHjdz(String hjdz) {
        this.hjdz = hjdz;
    }

    @Basic
    @Column(name = "POLITICAL_OUTLOOK")
    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    @Basic
    @Column(name = "PRACTITIONERS_CATEGORY")
    public String getCyrylb() {
        return cyrylb;
    }

    public void setCyrylb(String cyrylb) {
        this.cyrylb = cyrylb;
    }

    @Basic
    @Column(name = "PROFESSIONAL_QUALIFICATION")
    public String getZyzg() {
        return zyzg;
    }

    public void setZyzg(String zyzg) {
        this.zyzg = zyzg;
    }

    @Basic
    @Column(name = "PROFESSIONAL_TECHNICAL_LEVEL")
    public String getZhuanyjsjb() {
        return zhuanyjsjb;
    }

    public void setZhuanyjsjb(String zhuanyjsjb) {
        this.zhuanyjsjb = zhuanyjsjb;
    }

    @Basic
    @Column(name = "REGISTERED_RESIDENCE")
    public String getHkszd() {
        return hkszd;
    }

    public void setHkszd(String hkszd) {
        this.hkszd = hkszd;
    }

    @Basic
    @Column(name = "SENIORITY")
    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    @Basic
    @Column(name = "SENIORITY_DATE")
    public Date getGlny() {
        return glny;
    }

    public void setGlny(Date glny) {
        this.glny = glny;
    }

    @Basic
    @Column(name = "SEX")
    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    @Basic
    @Column(name = "TECHNICAL_POSITION")
    public String getZyjszw() {
        return zyjszw;
    }

    public void setZyjszw(String zyjszw) {
        this.zyjszw = zyjszw;
    }

    @Basic
    @Column(name = "UNIVERSITIES_AND_COLLEGES")
    public String getByyx() {
        return byyx;
    }

    public void setByyx(String byyx) {
        this.byyx = byyx;
    }

    @Basic
    @Column(name = "VOCATIONAL_TECHNICAL_LEVEL")
    public String getZhiyjsjb() {
        return zhiyjsjb;
    }

    public void setZhiyjsjb(String zhiyjsjb) {
        this.zhiyjsjb = zhiyjsjb;
    }

    @Basic
    @Column(name = "WORKERS_CLASSIFICATION")
    public String getZgfl() {
        return zgfl;
    }

    public void setZgfl(String zgfl) {
        this.zgfl = zgfl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YongyouplatformEmplEntity that = (YongyouplatformEmplEntity) o;
        return id == that.id &&
                ygid==that.ygid&&
                Objects.equals(xw, that.xw) &&
                Objects.equals(hkxz, that.hkxz) &&
                Objects.equals(nl, that.nl) &&
                Objects.equals(cym, that.cym) &&
                Objects.equals(csrq, that.csrq) &&
                Objects.equals(gxsj,that.gxsj)&&
                Objects.equals(xx, that.xx) &&
                Objects.equals(cssfhdq, that.cssfhdq) &&
                Objects.equals(zjlx, that.zjlx) &&
                Objects.equals(xl, that.xl) &&
                Objects.equals(crzh, that.crzh) &&
                Objects.equals(rzly, that.rzly) &&
                Objects.equals(hdlyrybh, that.hdlyrybh) &&
                Objects.equals(jkzk, that.jkzk) &&
                Objects.equals(jtdz, that.jtdz) &&
                Objects.equals(zjhm, that.zjhm) &&
                Objects.equals(grsf, that.grsf) &&
                Objects.equals(gszxkcjxjy, that.gszxkcjxjy) &&
                Objects.equals(gszxkcsylr, that.gszxkcsylr) &&
                Objects.equals(gszxkczfdk, that.gszxkczfdk) &&
                Objects.equals(gszxkczfzj, that.gszxkczfzj) &&
                Objects.equals(gszxkcznjy, that.gszxkcznjy) &&
                Objects.equals(byzy, that.byzy) &&
                Objects.equals(hyzk, that.hyzk) &&
                Objects.equals(sj, that.sj) &&
                Objects.equals(xm, that.xm) &&
                Objects.equals(mz, that.mz) &&
                Objects.equals(jg, that.jg) &&
                Objects.equals(bgdh, that.bgdh) &&
                Objects.equals(cjgzrq, that.cjgzrq) &&
                Objects.equals(hjdz, that.hjdz) &&
                Objects.equals(zzmm, that.zzmm) &&
                Objects.equals(cyrylb, that.cyrylb) &&
                Objects.equals(zyzg, that.zyzg) &&
                Objects.equals(zhuanyjsjb, that.zhuanyjsjb) &&
                Objects.equals(hkszd, that.hkszd) &&
                Objects.equals(gl, that.gl) &&
                Objects.equals(glny, that.glny) &&
                Objects.equals(xb, that.xb) &&
                Objects.equals(zyjszw, that.zyjszw) &&
                Objects.equals(byyx, that.byyx) &&
                Objects.equals(zhiyjsjb, that.zhiyjsjb) &&
                Objects.equals(zgfl, that.zgfl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xw, hkxz, nl, cym, csrq, xx, cssfhdq, zjlx, xl, crzh, rzly, hdlyrybh, jkzk, jtdz, zjhm, grsf, gszxkcjxjy, gszxkcsylr, gszxkczfdk, gszxkczfzj, gszxkcznjy, byzy, hyzk, sj, xm, mz, jg, bgdh, cjgzrq, hjdz, zzmm, cyrylb, zyzg, zhuanyjsjb, hkszd, gl, glny, xb, zyjszw, byyx, zhiyjsjb, zgfl,ygid,gxsj);
    }

    @Override
    public String toString() {
        return "YongyouplatformEmplEntity{" +
                "id=" + id +
                ", xw='" + xw + '\'' +
                ", hkxz='" + hkxz + '\'' +
                ", nl='" + nl + '\'' +
                ", cym='" + cym + '\'' +
                ", csrq=" + csrq +
                ", xx='" + xx + '\'' +
                ", cssfhdq='" + cssfhdq + '\'' +
                ", zjlx='" + zjlx + '\'' +
                ", xl='" + xl + '\'' +
                ", crzh='" + crzh + '\'' +
                ", rzly='" + rzly + '\'' +
                ", hdlyrybh='" + hdlyrybh + '\'' +
                ", jkzk='" + jkzk + '\'' +
                ", jtdz='" + jtdz + '\'' +
                ", zjhm='" + zjhm + '\'' +
                ", grsf='" + grsf + '\'' +
                ", gszxkcjxjy='" + gszxkcjxjy + '\'' +
                ", gszxkcsylr='" + gszxkcsylr + '\'' +
                ", gszxkczfdk='" + gszxkczfdk + '\'' +
                ", gszxkczfzj='" + gszxkczfzj + '\'' +
                ", gszxkcznjy='" + gszxkcznjy + '\'' +
                ", byzy='" + byzy + '\'' +
                ", hyzk='" + hyzk + '\'' +
                ", sj='" + sj + '\'' +
                ", xm='" + xm + '\'' +
                ", mz='" + mz + '\'' +
                ", jg='" + jg + '\'' +
                ", bgdh='" + bgdh + '\'' +
                ", cjgzrq=" + cjgzrq +
                ", hjdz='" + hjdz + '\'' +
                ", zzmm='" + zzmm + '\'' +
                ", cyrylb='" + cyrylb + '\'' +
                ", zyzg='" + zyzg + '\'' +
                ", zhuanyjsjb='" + zhuanyjsjb + '\'' +
                ", hkszd='" + hkszd + '\'' +
                ", gl='" + gl + '\'' +
                ", glny=" + glny +
                ", xb='" + xb + '\'' +
                ", zyjszw='" + zyjszw + '\'' +
                ", byyx='" + byyx + '\'' +
                ", zhiyjsjb='" + zhiyjsjb + '\'' +
                ", zgfl='" + zgfl + '\'' +
                ", ygid=" + ygid +
                ", gxsj="+gxsj+
                '}';
    }
}
