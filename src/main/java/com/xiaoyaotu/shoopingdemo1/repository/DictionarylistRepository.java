package com.xiaoyaotu.shoopingdemo1.repository;

import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Linqi on 2019-04-03.
 */
public interface DictionarylistRepository extends CrudRepository<DictionarylistEntity,Integer>, JpaSpecificationExecutor {

    //排序的方式条件查询
    List<DictionarylistEntity> findAll(Specification querySpecifi, Sort sort);
    //条件查询
    List<DictionarylistEntity> findAll(Specification querySpecifi);

    boolean existsById(Integer id);

    Optional<DictionarylistEntity> findById(Integer id);

    DictionarylistEntity save(DictionarylistEntity entity);


    @Query(value = "update dictionarylist  dics set dics.state='1' where dics.id=?1 and dics.state='0'" , nativeQuery = true)
    @Modifying
    @Transactional
    int   cancellationById(Integer id);


    @Query(value = "update dictionarylist   set dictname=?1, dicteng_name=?2 where dics.id=?3 " , nativeQuery = true)
    @Modifying
    @Transactional
    int updateDictxx(String zdmc, String zddm, Integer id);


    @Query(value = "update dictionarylist  dics set dics.state='0' where dics.id=?1 and dics.state='1'" , nativeQuery = true)
    @Modifying
    @Transactional
    int   unCancellationById(Integer id);




    /**
     * 根据字典名称和词条代码查询词条名称 --用于导出数据时把字典字段的代码转换成中文名
     */
    @Query(value = "select entryvalue from dictionarylist where dictname=?1 and entrycode=?2",nativeQuery = true)
    String  queryCtmcByZdmcAndCtdm(String zdmc, String ctdm);
    /**
     * 根据字典代码和词条代码查询词条名称 --用于导出数据时把字典字段的代码转换成中文名
     */
    @Query(value = "select entryvalue from dictionarylist where dicteng_name=?1 and entrycode=?2",nativeQuery = true)
    String queryCtmcByZddmAndCtdm(String zddm, String ctdm);

    /**
     * 根据字典名称和词条名称查询词条代码 --用于导入数据时把字典字段的词条名称转换成对应的词条代码
     */
    @Query(value = "select entrycode from dictionarylist where dicteng_name=?1 and entryvalue=?2",nativeQuery = true)
    String  queryCtdmByZddmAndCtmc(String zddm, String ctmc);

    /**
     * 根据字典名称和词条名称查询词条代码 --用于导入数据时把字典字段的词条名称转换成对应的词条代码
     */
    @Query(value = "select entrycode from dictionarylist where dictname=?1 and entryvalue=?2",nativeQuery = true)
    String  queryCtdmByZdmcAndCtmc(String zdmc, String ctmc);

}
