package com.xiaoyaotu.shoopingdemo1.service.impl;

import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;
import com.xiaoyaotu.shoopingdemo1.repository.DictionaryRepository;
import com.xiaoyaotu.shoopingdemo1.service.IdictionaryService;
import com.xiaoyaotu.shoopingdemo1.utils.StringUtil;
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
 * Created by Linqi on 2019-04-02.
 */
@Service
public class DictionaryServiceImpl implements IdictionaryService  {

      @Resource
      private DictionaryRepository dictionaryRepository;


    @Override
    public DictionaryEntity save(DictionaryEntity entity) {
           entity= defortPramsSet(entity);
        return dictionaryRepository.save(entity);
    }

    @Override
    public DictionaryEntity update(DictionaryEntity entity,DictionaryEntity oldEntity) {
         entity=informationCompletionForEntity(oldEntity,entity);
        return dictionaryRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
             dictionaryRepository.deleteById(id);
    }

    @Override
    public int cancellationById(Integer id) {
        return dictionaryRepository.cancellationById(id);
    }

    @Override
    public int unCancellationById(Integer id) {
        return dictionaryRepository.unCancellationById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return dictionaryRepository.existsById(id);
    }

    /**
     *  判断该字典是否能够操作
     * @param id
     * @return
     */
    @Override
    public boolean isAbleById(Integer id) {

           DictionaryEntity entity= findById(id);
           if(entity==null){
               return false;
           }else {
               String zdlx = entity.getZdlx();
               if ("1".equals(zdlx)) {
                   return false;
               } else if ("0".equals(zdlx)) {
                   return true;
               } else {
                   return false;
               }
           }
    }

    @Override
    public DictionaryEntity findById(Integer id) {
        Optional<DictionaryEntity> entitys = dictionaryRepository.findById(id);
         if(entitys.isPresent()){
             return entitys.get();
         }
        return null;
    }

    @Override
    public DictionaryEntity findZdxxByZdmc(String zdmc) {
        DictionaryEntity entity=new DictionaryEntity();
                         entity.setZdmc(zdmc);
        List<DictionaryEntity> list = queryByEntity(entity, true);
            if(list.size()==0) {
                return null;
            }

        return list.get(0);
    }

    @Override
    public DictionaryEntity findZdxxByZddm(String zddm) {
        DictionaryEntity entity=new DictionaryEntity();
                         entity.setZddm(zddm);
        List<DictionaryEntity> list = queryByEntity(entity, true);
        if(list.size()==0) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public boolean findZdxxByZddmAndZdmc(String zddm, String zdmc) {
        DictionaryEntity entity=null;
            entity =findZdxxByZdmc(zdmc);//先通过字典名称查询
          if(entity ==null){
              entity=findZdxxByZddm(zddm);//再通过字典代码查询
              if(entity ==null){
                  return false;
              }
              return true;
          }else {
              return true;
          }
    }

    @Override
    public List<DictionaryEntity> findAll() {
        DictionaryEntity entity=new DictionaryEntity();
        return queryByEntity(entity,true);
    }

    @Override
    public List<DictionaryEntity> findZdxxByEntity(DictionaryEntity entity) {
        return queryByEntity(entity,true);
    }

    private  DictionaryEntity informationCompletionForEntity( DictionaryEntity oldEntity,DictionaryEntity newEntity){

        if (StringUtil.isNull(newEntity.getZdmc())) {
            newEntity.setZdmc(oldEntity.getZdmc());
        }
        if (StringUtil.isNull(newEntity.getZddm())) {
            newEntity.setZddm(oldEntity.getZddm());
        }
        if(StringUtil.isNull(newEntity.getZdlx())){
            newEntity.setZdlx(oldEntity.getZdlx());
        }
        if(StringUtil.isNull(newEntity.getZxbz())){
            newEntity.setZxbz(oldEntity.getZxbz());
        }

        return newEntity;
    }

    //设置默认值
    private DictionaryEntity defortPramsSet(DictionaryEntity entity){
           if(StringUtil.isNull(entity.getZdlx())){
               entity.setZdlx("0");
           }
           if(StringUtil.isNull(entity.getZxbz())){
               entity.setZxbz("0");
           }

        return entity;
    }

    private List<DictionaryEntity> queryByEntity(DictionaryEntity entity,boolean isSort) {

        Specification querySpecifi= new Specification<DictionaryEntity>() {

            @Override
            public Predicate toPredicate(Root<DictionaryEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates=new ArrayList<>();
                if(StringUtil.isNotNull(entity.getZdmc())){
                    predicates.add(cb.equal(root.get("zdmc"),entity.getZdmc()));
                }
                if(StringUtil.isNotNull(entity.getZddm())){
                    predicates.add(cb.equal(root.get("zddm"),entity.getZddm()));
                }
                if(StringUtil.isNotNull(entity.getZxbz())){
                    predicates.add(cb.equal(root.get("zxbz"),entity.getZxbz()));
                }
                if(StringUtil.isNotNull(entity.getZdlx())){
                    predicates.add(cb.equal(root.get("zdlx"),entity.getZdlx()));
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<DictionaryEntity> list=null ;
        if(isSort){
            Sort sort=new Sort(Sort.Direction.ASC,"zxbz");
            list= dictionaryRepository.findAll(querySpecifi,sort);

        }else{
            list= dictionaryRepository.findAll(querySpecifi);
        }
        return list;
    }
}
