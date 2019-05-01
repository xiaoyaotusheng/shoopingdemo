package com.xiaoyaotu.shoopingdemo1.service;

import com.xiaoyaotu.shoopingdemo1.entity.ParamstypemsEntity;

import java.util.List;

/**
 * Created by Linqi on 2019-04-29.
 */
public interface IparamstypemsService {

    ParamstypemsEntity save(ParamstypemsEntity entity)throws Exception;

    ParamstypemsEntity update(ParamstypemsEntity entity)throws Exception;

    void  deleteByid(int id)throws Exception;

    ParamstypemsEntity findByid(int id)throws Exception;

    boolean  existsById(int id)throws Exception;

    List<ParamstypemsEntity> findBySxlb(int sxlb)throws Exception;

   

}
