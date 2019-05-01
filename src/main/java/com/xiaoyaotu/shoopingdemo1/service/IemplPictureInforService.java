package com.xiaoyaotu.shoopingdemo1.service;

import com.xiaoyaotu.shoopingdemo1.entity.EmplPictureInforEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Linqi on 2019-04-23.
 */
public interface IemplPictureInforService {

    EmplPictureInforEntity save(EmplPictureInforEntity entity)throws Exception;

    EmplPictureInforEntity update(EmplPictureInforEntity entity)throws Exception;

    void  deleteByid(int id)throws Exception;

    EmplPictureInforEntity findByid(int id)throws Exception;


    List<EmplPictureInforEntity> findAll(EmplPictureInforEntity entity)throws Exception;

    Page<EmplPictureInforEntity> findByEntity(EmplPictureInforEntity entity, int page, int pagesize)throws Exception;

    boolean  existsById(int id)throws Exception;

    Page<EmplPictureInforEntity> findByZjId(int zjid, int page, int pagesize)throws Exception;

    Page<EmplPictureInforEntity> findByXxgzjlId(int xxgzjlid, int page, int pagesize)throws Exception;

    Page<EmplPictureInforEntity> findByYgId(int ygid, int page, int pagesize)throws Exception;


    List<EmplPictureInforEntity> findByZjId(int zjid)throws Exception;

    List<EmplPictureInforEntity> findByXxgzjlId(int xxgzjlid)throws Exception;

    List<EmplPictureInforEntity> findByYgId(int ygid)throws Exception;




}
