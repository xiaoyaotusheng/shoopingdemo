package com.xiaoyaotu.shoopingdemo1.service.impl;

import com.xiaoyaotu.shoopingdemo1.entity.EmplPictureInforEntity;
import com.xiaoyaotu.shoopingdemo1.repository.EmplPictureInforRepository;
import com.xiaoyaotu.shoopingdemo1.service.IemplPictureInforService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Linqi on 2019-04-23.
 */
@Service
public class EmplPictureInforServiceImpl implements IemplPictureInforService {
    @Resource
    private EmplPictureInforRepository emplPictureInforRepository;

    @Override
    public EmplPictureInforEntity save(EmplPictureInforEntity entity) throws Exception {

        entity= setDefultParams(entity);
        return emplPictureInforRepository.save(entity);
    }

    @Override
    public EmplPictureInforEntity update(EmplPictureInforEntity entity) throws Exception {
        if (null == (Integer) entity.getId() || entity.getId() == 0) {
            return null;
        }
        entity= setDefultParams(entity);
        return emplPictureInforRepository.save(entity);
    }

    @Override
    public EmplPictureInforEntity findByid(int id) throws Exception {

        Optional<EmplPictureInforEntity> option = emplPictureInforRepository.findById(id);
        if (option.isPresent()) {
            return option.get();
        }
        return null;
    }

    @Override
    public boolean existsById(int id) throws Exception {

        return emplPictureInforRepository.existsById(id);
    }

    @Override
    public List<EmplPictureInforEntity> findAll(EmplPictureInforEntity entity) throws Exception {

        return queryByEntity(entity,true);
    }

    @Override
    public Page<EmplPictureInforEntity> findByEntity(EmplPictureInforEntity entity, int page, int pagesize) throws Exception {

        return queryPageByEntity(entity,page,pagesize,true);
    }


    @Override
    public Page<EmplPictureInforEntity> findByZjId(int zjid, int page, int pagesize) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
                 entity.setZjid(zjid);

        return queryPageByEntity(entity,page,pagesize,true);
    }

    @Override
    public Page<EmplPictureInforEntity> findByXxgzjlId(int xxgzjlid, int page, int pagesize) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
                 entity.setXxgzjlid(xxgzjlid);

        return queryPageByEntity(entity,page,pagesize,true);
    }

    @Override
    public Page<EmplPictureInforEntity> findByYgId(int ygid, int page, int pagesize) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
         entity.setYgId(ygid);

        return queryPageByEntity(entity,page,pagesize,true);
    }

    @Override
    public List<EmplPictureInforEntity> findByZjId(int zjid) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
        entity.setZjid(zjid);
        return queryByEntity(entity,true);
    }

    @Override
    public List<EmplPictureInforEntity> findByXxgzjlId(int xxgzjlid) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
        entity.setXxgzjlid(xxgzjlid);
        return queryByEntity(entity,true);
    }

    @Override
    public List<EmplPictureInforEntity> findByYgId(int ygid) throws Exception {
        EmplPictureInforEntity entity =new EmplPictureInforEntity();
        entity.setYgId(ygid);
        return queryByEntity(entity,true);
    }

    @Override
    public void deleteByid(int id) throws Exception {
        emplPictureInforRepository.deleteById(id);
    }



    private List<EmplPictureInforEntity> queryByEntity(EmplPictureInforEntity entity, boolean isSort) throws Exception {
        if(entity.getYgId()==0){
            entity.setYgId(0);
        }
        if(entity.getXxgzjlid()==0){
            entity.setXxgzjlid(0);
        }
        if(entity.getZjid()==0){
            entity.setZjid(0);
        }
        Specification querySpecifi = queryParams(entity);

        List<EmplPictureInforEntity> list = null;
        if (isSort) {
            Sort sort = new Sort(Sort.Direction.DESC, "tpcjsj");
            list = emplPictureInforRepository.findAll(querySpecifi, sort);
        } else {
            list = emplPictureInforRepository.findAll(querySpecifi);
        }

        return list;
    }

    private Specification queryParams(EmplPictureInforEntity entity) {
        Specification querySpecifi = new Specification<EmplPictureInforEntity>() {
            @Override
            public Predicate toPredicate(Root<EmplPictureInforEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if( 0!=entity.getYgId()){
                    predicates.add(cb.equal(root.get("ygId"),entity.getYgId()));
                }
                if( 0!=entity.getXxgzjlid()){
                    predicates.add(cb.equal(root.get("xxgzjlid"),entity.getXxgzjlid()));
                }
                if( 0!=entity.getZjid()){
                    predicates.add(cb.equal(root.get("zjid"),entity.getZjid()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return querySpecifi;
    }

    private Page<EmplPictureInforEntity> queryPageByEntity(EmplPictureInforEntity entity, int page, int pagesize, boolean isSort) throws Exception {
                if(entity.getYgId()==0){
                    entity.setYgId(0);
                }
                if(entity.getXxgzjlid()==0){
                    entity.setXxgzjlid(0);
                }
                if(entity.getZjid()==0){
                    entity.setZjid(0);
                }
        Specification querySpecifi = queryParams(entity);
        Page<EmplPictureInforEntity> list = null;
        Pageable pageable = null;
        if (isSort) {
            pageable = PageRequest.of(page - 1, pagesize, Sort.by(new Sort.Order(Sort.Direction.DESC, "tpcjsj")));
        } else {
            pageable = PageRequest.of(page - 1, pagesize);
        }
        list = emplPictureInforRepository.findAll(querySpecifi, pageable);


        return list;
    }


    private EmplPictureInforEntity setDefultParams(EmplPictureInforEntity entity){

        return  entity;
    }
}
