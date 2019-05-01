package com.xiaoyaotu.shoopingdemo1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "empl_picture_infor", schema = "naogoucms", catalog = "")
public class EmplPictureInforEntity {
    private int id;
    private Integer ygzj;
    private Integer zjzj;
    private Integer gzxxjlzj;
    private String tplj;
    private String tpmc;
    private Date tpcjsj;
    private Date tpxgsj;
    private String bz;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "YGZJ")
    public Integer getYgzj() {
        return ygzj;
    }

    public void setYgzj(Integer ygzj) {
        this.ygzj = ygzj;
    }

    @Basic
    @Column(name = "ZJZJ")
    public Integer getZjzj() {
        return zjzj;
    }

    public void setZjzj(Integer zjzj) {
        this.zjzj = zjzj;
    }

    @Basic
    @Column(name = "GZXXJLZJ")
    public Integer getGzxxjlzj() {
        return gzxxjlzj;
    }

    public void setGzxxjlzj(Integer gzxxjlzj) {
        this.gzxxjlzj = gzxxjlzj;
    }

    @Basic
    @Column(name = "TPLJ")
    public String getTplj() {
        return tplj;
    }

    public void setTplj(String tplj) {
        this.tplj = tplj;
    }

    @Basic
    @Column(name = "TPMC")
    public String getTpmc() {
        return tpmc;
    }

    public void setTpmc(String tpmc) {
        this.tpmc = tpmc;
    }

    @Basic
    @Column(name = "TPCJSJ")
    public Date getTpcjsj() {
        return tpcjsj;
    }

    public void setTpcjsj(Date tpcjsj) {
        this.tpcjsj = tpcjsj;
    }

    @Basic
    @Column(name = "TPXGSJ")
    public Date getTpxgsj() {
        return tpxgsj;
    }

    public void setTpxgsj(Date tpxgsj) {
        this.tpxgsj = tpxgsj;
    }

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmplPictureInforEntity that = (EmplPictureInforEntity) o;
        return id == that.id &&
                Objects.equals(ygzj, that.ygzj) &&
                Objects.equals(zjzj, that.zjzj) &&
                Objects.equals(gzxxjlzj, that.gzxxjlzj) &&
                Objects.equals(tplj, that.tplj) &&
                Objects.equals(tpmc, that.tpmc) &&
                Objects.equals(tpcjsj, that.tpcjsj) &&
                Objects.equals(tpxgsj, that.tpxgsj) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ygzj, zjzj, gzxxjlzj, tplj, tpmc, tpcjsj, tpxgsj, bz);
    }
}
