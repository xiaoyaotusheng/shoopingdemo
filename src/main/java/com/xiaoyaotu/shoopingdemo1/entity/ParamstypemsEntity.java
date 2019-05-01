package com.xiaoyaotu.shoopingdemo1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paramstypems", schema = "naogoucms", catalog = "")
public class ParamstypemsEntity {
    private int id;
    private String sxm;
    private String sxzwzs;
    private int sxsslx;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SXM")
    public String getSxm() {
        return sxm;
    }

    public void setSxm(String sxm) {
        this.sxm = sxm;
    }

    @Basic
    @Column(name = "SXZWZS")
    public String getSxzwzs() {
        return sxzwzs;
    }

    public void setSxzwzs(String sxzwzs) {
        this.sxzwzs = sxzwzs;
    }

    @Basic
    @Column(name = "SXSSLX")
    public int getSxsslx() {
        return sxsslx;
    }

    public void setSxsslx(int sxsslx) {
        this.sxsslx = sxsslx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParamstypemsEntity that = (ParamstypemsEntity) o;
        return id == that.id &&
                sxsslx == that.sxsslx &&
                Objects.equals(sxm, that.sxm) &&
                Objects.equals(sxzwzs, that.sxzwzs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sxm, sxzwzs, sxsslx);
    }
}
