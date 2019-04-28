package com.xiaoyaotu.shoopingdemo1.repository;

import com.xiaoyaotu.shoopingdemo1.entity.YongyouplatformEmplEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Linqi on 2019-04-27.
 */
public interface YongyouplatformEmplRepository extends CrudRepository<YongyouplatformEmplEntity,Integer>, JpaSpecificationExecutor {

    YongyouplatformEmplEntity save(YongyouplatformEmplEntity entity);

    List<YongyouplatformEmplEntity> findAll();


}