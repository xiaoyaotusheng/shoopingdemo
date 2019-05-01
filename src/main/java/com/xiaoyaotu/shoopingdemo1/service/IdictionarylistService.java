package com.xiaoyaotu.shoopingdemo1.service;

import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;

import java.util.List;

/**
 * Created by Linqi on 2019-04-03.
 */
public interface IdictionarylistService {


    DictionarylistEntity save(DictionarylistEntity entity);

    DictionarylistEntity update(DictionarylistEntity newEntity, DictionarylistEntity oldEntity);


    int   cancellationById(Integer id);

    int   unCancellationById(Integer id);

    boolean existsById(Integer id);

    boolean isAbleById(Integer id);

     int  updateDictxx(String zdmc, String zddm, Integer id);

    DictionarylistEntity findById(Integer id);

    List<DictionarylistEntity>  findCtxxByZdmc(String zdmc);

    List<DictionarylistEntity>  findCtxxByZddm(String zddm);

     List<DictionarylistEntity> findCtxxByZdid(Integer zdid);

    List<DictionarylistEntity> findAll();

    List<DictionarylistEntity>  findCtxxByEntity(DictionarylistEntity entity);

    /**
     * 根据字典名称和词条代码查询词条名称 --用于导出数据时把字典字段的代码转换成中文名
     */
    String  queryCtmcByZdmcAndCtdm(String zdmc, String ctdm);
    /**
     * 根据字典代码和词条代码查询词条名称 --用于导出数据时把字典字段的代码转换成中文名
     */
    String queryCtmcByZddmAndCtdm(String zddm, String ctdm);

    /**
     * 根据字典名称和词条名称查询词条代码 --用于导入数据时把字典字段的词条名称转换成对应的词条代码
     */
    String  queryCtdmByZddmAndCtmc(String zddm, String ctmc);

    /**
     * 根据字典名称和词条名称查询词条代码 --用于导入数据时把字典字段的词条名称转换成对应的词条代码
     */
    String  queryCtdmByZdmcAndCtmc(String zdmc, String ctmc);


}
