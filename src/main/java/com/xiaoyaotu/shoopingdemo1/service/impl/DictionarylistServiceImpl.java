package com.xiaoyaotu.shoopingdemo1.service.impl;

import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;
import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;
import com.xiaoyaotu.shoopingdemo1.repository.DictionaryRepository;
import com.xiaoyaotu.shoopingdemo1.repository.DictionarylistRepository;
import com.xiaoyaotu.shoopingdemo1.service.IdictionarylistService;
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
 * Created by Linqi on 2019-04-03.
 */
@Service
public class DictionarylistServiceImpl implements IdictionarylistService{
     @Resource
     private DictionarylistRepository dictionarylistRepository;

    @Resource
     private DictionaryRepository dictionaryRepository;

    @Override
    public DictionarylistEntity save(DictionarylistEntity entity) {
           entity= defortPramsSet(entity);
           entity=dictionarylistRepository.save(entity); //存两遍

        return entity;
    }

    @Override
    public DictionarylistEntity update(DictionarylistEntity newEntity, DictionarylistEntity oldEntity) {
        oldEntity=informationCompletionForEntity(newEntity,oldEntity);
        return dictionarylistRepository.save(oldEntity);
    }


    @Override
    public int cancellationById(Integer id) {
        return dictionarylistRepository.cancellationById(id);
    }

    @Override
    public int unCancellationById(Integer id) {
        return dictionarylistRepository.unCancellationById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return dictionarylistRepository.existsById(id);
    }

    @Override
    public boolean isAbleById(Integer id) {
        DictionarylistEntity entity =findById(id);
        if(entity!=null&&"0".equals(entity.getCtlx())){
            return true;
        }else{
            return false;
        }
    }

    /**
     *  修改词条的字典信息，当字典信息变更时，对应的词条也应该同步变更
     * @param id
     * @param zdmc
     * @param zddm
     * @return
     */
    @Override
    public int updateDictxx(String zdmc, String zddm ,Integer id) {
        return dictionarylistRepository.updateDictxx(zdmc, zddm, id);
    }

    @Override
    public DictionarylistEntity findById(Integer id) {
        Optional<DictionarylistEntity> dictMsg = dictionarylistRepository.findById(id);
           if(dictMsg.isPresent()){
               return dictMsg.get();
           }
        return null ;
    }

    @Override
    public List<DictionarylistEntity> findCtxxByZdmc(String zdmc) {
        DictionarylistEntity entity=new DictionarylistEntity();
                       entity.setZdmc(zdmc);
        return queryByEntity(entity,true);
    }

    @Override
    public List<DictionarylistEntity> findCtxxByZddm(String zddm) {
        DictionarylistEntity entity=new DictionarylistEntity();
                  entity.setZddm(zddm);
        return queryByEntity(entity,true);
    }

    @Override
    public List<DictionarylistEntity> findCtxxByZdid(Integer zdid){
        DictionarylistEntity entity=new DictionarylistEntity();
                  entity.setZdid(zdid);
        return queryByEntity(entity,true);
    }

    @Override
    public List<DictionarylistEntity> findAll( ) {
        DictionarylistEntity   entity= new DictionarylistEntity();
        return queryByEntity(entity,true);
    }

    @Override
    public List<DictionarylistEntity> findCtxxByEntity(DictionarylistEntity entity) {

        return queryByEntity(entity,true);
    }
    /*******************************对外提供的单个词条查询方式****************************************************/

    @Override
    public String queryCtmcByZdmcAndCtdm(String zdmc, String ctdm) {
        if(StringUtil.isNull(zdmc)||StringUtil.isNull(ctdm)){
            return  "字典名称和词条代码不能为空";
        }
        return dictionarylistRepository.queryCtmcByZdmcAndCtdm(zdmc, ctdm);
    }

    @Override
    public String queryCtmcByZddmAndCtdm(String zddm, String ctdm) {
        if(StringUtil.isNull(zddm)||StringUtil.isNull(ctdm)){
            return  "字典代码和词条代码不能为空";
        }

        return dictionarylistRepository.queryCtmcByZddmAndCtdm(zddm, ctdm);
    }

    @Override
    public String queryCtdmByZddmAndCtmc(String zddm, String ctmc) {
        if(StringUtil.isNull(zddm)||StringUtil.isNull(ctmc)){
            return  "字典代码和词条名称不能为空";
        }
        return dictionarylistRepository.queryCtdmByZddmAndCtmc(zddm, ctmc);
    }

    @Override
    public String queryCtdmByZdmcAndCtmc(String zdmc, String ctmc) {
        if(StringUtil.isNull(zdmc)||StringUtil.isNull(ctmc)){
            return  "字典名称和词条名称不能为空";
        }
        return dictionarylistRepository.queryCtdmByZdmcAndCtmc(zdmc, ctmc);
    }

    /*****************************************************************************************************/
    //设置默认值
    private DictionarylistEntity defortPramsSet(DictionarylistEntity entity){
        DictionaryEntity  dict=dictionaryRepository.findById(entity.getZdid()).get();
                    entity.setZdmc(dict.getZdmc());
                    entity.setZddm(dict.getZddm());
                    entity.setCtlx(dict.getZdlx()); //词条类型适合字典类型绑定的
                    entity.setZxbz("0");

        return entity;
    }

    private  DictionarylistEntity informationCompletionForEntity( DictionarylistEntity oldEntity,DictionarylistEntity newEntity){
        //能够更新的信息传递过来做判断就行了
        if (StringUtil.isNotNull(newEntity.getZdmc())) {
            oldEntity.setZdmc(newEntity.getZdmc());
        }
        if (StringUtil.isNotNull(newEntity.getZddm())) {
            oldEntity.setZddm(newEntity.getZddm());
        }
        if(0!=newEntity.getZdid()){
            oldEntity.setZdid(newEntity.getZdid());
        }
        if(StringUtil.isNotNull(newEntity.getCtmc())){
            oldEntity.setCtmc(newEntity.getCtmc());
        }
         if(StringUtil.isNotNull(newEntity.getCtdm())){
             oldEntity.setCtdm(newEntity.getCtdm());
         }
        if(StringUtil.isNotNull(newEntity.getCtlx())){
             oldEntity.setCtlx(newEntity.getCtlx());
        }
        return oldEntity;
    }

    private List<DictionarylistEntity> queryByEntity(DictionarylistEntity entity,boolean isSort) {

        Specification querySpecifi= new Specification<DictionarylistEntity>() {

            @Override
            public Predicate toPredicate(Root<DictionarylistEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates=new ArrayList<>();
                if(StringUtil.isNotNull(entity.getZdmc())){
                    predicates.add(cb.like(root.get("zdmc"),entity.getZdmc()));
                }
                if(StringUtil.isNotNull(entity.getZddm())){
                    predicates.add(cb.like(root.get("zddm"),entity.getZddm()));
                }
                if(StringUtil.isNotNull(entity.getZxbz())){
                    predicates.add(cb.equal(root.get("zxbz"),entity.getZxbz()));
                }
                if(StringUtil.isNotNull(entity.getCtlx())){
                    predicates.add(cb.equal(root.get("ctlx"),entity.getCtlx()));
                }
                if(StringUtil.isNotNull(entity.getCtmc())){
                    predicates.add(cb.like(root.get("ctmc"),entity.getCtmc()));
                }
                if(StringUtil.isNotNull(entity.getCtdm())){
                    predicates.add(cb.equal(root.get("ctdm"),entity.getCtdm()));
                }
               if( entity.getZdid()!=0){
                   predicates.add(cb.equal(root.get("zdid"),entity.getZdid()));
               }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<DictionarylistEntity> list=null ;
        if(isSort){
            Sort sort=new Sort(Sort.Direction.ASC,"ctdm"); //根据词条信息获取代码
            list= dictionarylistRepository.findAll(querySpecifi,sort);

        }else{
            list= dictionarylistRepository.findAll(querySpecifi);
        }
        return list;
    }

}
