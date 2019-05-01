package com.xiaoyaotu.shoopingdemo1.repository;

import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;
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
 * Created by Linqi on 2019-04-02.
 */
public interface DictionaryRepository extends CrudRepository<DictionaryEntity,Integer>, JpaSpecificationExecutor {
     //排序的方式条件查询
     List<DictionaryEntity> findAll(Specification querySpecifi, Sort sort);
    //条件查询
     List<DictionaryEntity> findAll(Specification querySpecifi);

    boolean existsById(Integer id);

    Optional<DictionaryEntity> findById(Integer id);

    DictionaryEntity save(DictionaryEntity entity);


    @Query(value = "update dictionary  dic set dic.state='1' where dic.id=?1 and dic.state='0'" , nativeQuery = true)
    @Modifying
    @Transactional
    int   cancellationById(Integer id);

    @Query(value = "update dictionary  dic set dic.state='0' where dic.id=?1 and dic.state='1'" , nativeQuery = true)
    @Modifying
    @Transactional
    int   unCancellationById(Integer id);


    void  deleteById(Integer integer);
}
