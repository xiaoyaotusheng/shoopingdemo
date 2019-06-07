package com.xiaoyaotu.shoopingdemo1.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dictionary", schema = "naogoucms", catalog = "")
public class DictionaryEntity {

    @ApiModelProperty(value = "ID")
    private int id;
    @ApiModelProperty(value = "字典名称")
    private String zdzwm;
    @ApiModelProperty(value = "字典代码")
    private String zdywm;
    @ApiModelProperty(value = "注销标志")
    private String zxbz;
    @ApiModelProperty(value = "字典类型")
    private String zdlx;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "zdlx")
    public String getZdlx() {
        return zdlx;
    }

    public void setZdlx(String zdlx) {
        this.zdlx = zdlx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryEntity that = (DictionaryEntity) o;
        return id == that.id &&
                Objects.equals(zdzwm, that.zdzwm) &&
                Objects.equals(zdywm, that.zdywm) &&
                Objects.equals(zxbz, that.zxbz) &&
                Objects.equals(zdlx, that.zdlx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zdzwm, zdywm, zxbz, zdlx);
    }
}
