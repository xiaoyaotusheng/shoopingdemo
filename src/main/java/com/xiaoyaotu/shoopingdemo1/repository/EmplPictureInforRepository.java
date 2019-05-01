package com.xiaoyaotu.shoopingdemo1.repository;

import com.xiaoyaotu.shoopingdemo1.entity.EmplPictureInforEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Linqi on 2019-04-23.
 */
public interface EmplPictureInforRepository extends CrudRepository<EmplPictureInforEntity,Integer>, JpaSpecificationExecutor {

    EmplPictureInforEntity save(EmplPictureInforEntity entity);

      List<EmplPictureInforEntity> findAll();

}
