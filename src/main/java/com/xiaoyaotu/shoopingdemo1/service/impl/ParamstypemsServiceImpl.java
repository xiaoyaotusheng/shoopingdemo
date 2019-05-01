package com.xiaoyaotu.shoopingdemo1.service.impl;

import com.xiaoyaotu.shoopingdemo1.entity.ParamstypemsEntity;
import com.xiaoyaotu.shoopingdemo1.repository.ParamstypemsRepository;
import com.xiaoyaotu.shoopingdemo1.service.IparamstypemsService;
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
 * Created by Linqi on 2019-04-29.
 */
@Service
public class ParamstypemsServiceImpl implements IparamstypemsService {

    @Resource
    private ParamstypemsRepository paramstypemsRepository;

    @Override
    public ParamstypemsEntity save(ParamstypemsEntity entity) throws Exception {
        entity= setDefultParams(entity);
        return paramstypemsRepository.save(entity);
    }

    @Override
    public ParamstypemsEntity update(ParamstypemsEntity entity) throws Exception {
        if (null == (Integer) entity.getId() || entity.getId() == 0) {
            return null;
        }
        entity= setDefultParams(entity);
        return paramstypemsRepository.save(entity);
    }

    @Override
    public ParamstypemsEntity findByid(int id) throws Exception {
        Optional<ParamstypemsEntity> option = paramstypemsRepository.findById(id);
        if (option.isPresent()) {
            return option.get();
        }
        return null;
    }

    @Override
    public boolean existsById(int id) throws Exception {
        return paramstypemsRepository.existsById(id);
    }


    @Override
    public List<ParamstypemsEntity> findBySxlb(int sxlb) throws Exception {
        ParamstypemsEntity entity =new ParamstypemsEntity();
         entity.setSxsslx(sxlb);
        return queryByEntity(entity);
    }


    @Override
    public void deleteByid(int id) throws Exception {
        paramstypemsRepository.deleteById(id);
    }


    private List<ParamstypemsEntity> queryByEntity(ParamstypemsEntity entity) throws Exception {
        Specification querySpecifi = queryParams(entity);
        List<ParamstypemsEntity> list = null;
            list = paramstypemsRepository.findAll(querySpecifi);
        return list;
    }

    private Specification queryParams(ParamstypemsEntity entity) {
        Specification querySpecifi = new Specification<ParamstypemsEntity>() {
            @Override
            public Predicate toPredicate(Root<ParamstypemsEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if( 0!=entity.getSxsslx()){
                    predicates.add(cb.equal(root.get("sxlb"),entity.getSxsslx()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return querySpecifi;
    }



    private ParamstypemsEntity setDefultParams(ParamstypemsEntity entity){

        return  entity;
    }  
}
