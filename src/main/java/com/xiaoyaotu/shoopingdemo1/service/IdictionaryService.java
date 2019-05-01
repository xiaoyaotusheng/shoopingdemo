package com.xiaoyaotu.shoopingdemo1.service;

import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;

import java.util.List;


/**
 * Created by Linqi on 2019-04-02.
 */
public interface IdictionaryService {


    DictionaryEntity save(DictionaryEntity entity);

    DictionaryEntity update(DictionaryEntity newEntity, DictionaryEntity oldEntity);

        void  deleteById(Integer id);

       int   cancellationById(Integer id);

       int   unCancellationById(Integer id);

      boolean existsById(Integer id);

      boolean isAbleById(Integer id);

     DictionaryEntity findById(Integer id);

     DictionaryEntity  findZdxxByZdmc(String zdmc);

     DictionaryEntity  findZdxxByZddm(String zddm);

      boolean  findZdxxByZddmAndZdmc(String zddm, String zdmc);

     List<DictionaryEntity> findAll();

     List<DictionaryEntity>  findZdxxByEntity(DictionaryEntity entity);

}
