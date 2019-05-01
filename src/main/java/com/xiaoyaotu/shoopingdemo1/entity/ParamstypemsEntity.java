package com.xiaoyaotu.shoopingdemo1.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Linqi on 2019-04-29.
 */
@Entity
@Table(name = "paramstypems", schema = "staffreport", catalog = "")
public class ParamstypemsEntity {
    private int id;
    private String sxywm;
    private String sxzwm;
    private int sxlb;

}
