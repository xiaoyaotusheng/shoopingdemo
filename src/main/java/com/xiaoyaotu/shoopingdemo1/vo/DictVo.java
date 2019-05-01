package com.xiaoyaotu.shoopingdemo1.vo;

import java.util.List;
import java.util.Objects;

/**
 * Created by Linqi on 2019-04-19.
 */
public class DictVo {

    private  String  label;
    private  String  value;
    private List<DictVo>  children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DictVo> getChildren() {
        return children;
    }

    public void setChildren(List<DictVo> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictVo)) return false;
        DictVo dictVo = (DictVo) o;
        return label.equals(dictVo.label) &&
                value.equals(dictVo.value) &&
                children.equals(dictVo.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, children);
    }

    @Override
    public String toString() {
        return "DictVo{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", children=" + children +
                '}';
    }
}
