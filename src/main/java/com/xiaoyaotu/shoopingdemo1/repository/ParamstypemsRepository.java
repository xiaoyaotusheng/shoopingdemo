package com.xiaoyaotu.shoopingdemo1.repository;

import com.xiaoyaotu.shoopingdemo1.entity.ParamstypemsEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Linqi on 2019-04-29.
 */
public interface ParamstypemsRepository extends CrudRepository<ParamstypemsEntity,Integer>, JpaSpecificationExecutor {

    ParamstypemsEntity save(ParamstypemsEntity entity);

    List<ParamstypemsEntity> findAll();

}
