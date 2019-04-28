package com.xiaoyaotu.shoopingdemo1.service;


import com.xiaoyaotu.shoopingdemo1.entity.YongyouplatformEmplEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Linqi on 2019-04-27.
 */
public interface IyongyouplatformEmplService {

    YongyouplatformEmplEntity save(YongyouplatformEmplEntity entity)throws Exception;

    YongyouplatformEmplEntity update(YongyouplatformEmplEntity entity)throws Exception;

    YongyouplatformEmplEntity findByid(int id)throws Exception;

    List<YongyouplatformEmplEntity> findAll()throws Exception;

    List<YongyouplatformEmplEntity> findAll(YongyouplatformEmplEntity entiy)throws Exception;

    Page<YongyouplatformEmplEntity> findByEntity(YongyouplatformEmplEntity entiy, int page, int pagesize)throws Exception;

    boolean  existsById(int id)throws Exception;

    void  deleteByid(int id)throws Exception;
}
