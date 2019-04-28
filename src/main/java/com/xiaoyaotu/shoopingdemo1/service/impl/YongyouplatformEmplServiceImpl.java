package com.xiaoyaotu.shoopingdemo1.service.impl;


import com.xiaoyaotu.shoopingdemo1.entity.YongyouplatformEmplEntity;
import com.xiaoyaotu.shoopingdemo1.repository.YongyouplatformEmplRepository;
import com.xiaoyaotu.shoopingdemo1.service.IyongyouplatformEmplService;
import com.xiaoyaotu.shoopingdemo1.utils.StringUtil;
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
 * Created by Linqi on 2019-04-27.
 */
@Service
public class YongyouplatformEmplServiceImpl implements IyongyouplatformEmplService {

    @Resource
     private YongyouplatformEmplRepository yongyouplatformEmplRepository;
    
    
    @Override
    public YongyouplatformEmplEntity save(YongyouplatformEmplEntity entity) throws Exception {
        return yongyouplatformEmplRepository.save(entity);
    }

    @Override
    public YongyouplatformEmplEntity update(YongyouplatformEmplEntity entity) throws Exception {
        if (null == (Integer) entity.getId() || entity.getId() == 0) {
            return null;
        }
        return yongyouplatformEmplRepository.save(entity);
    }

    @Override
    public YongyouplatformEmplEntity findByid(int id) throws Exception {
        Optional<YongyouplatformEmplEntity> option = yongyouplatformEmplRepository.findById(id);
        if (option.isPresent()) {
            return option.get();
        }
        return null;
    }

    @Override
    public List<YongyouplatformEmplEntity> findAll() throws Exception {
        return yongyouplatformEmplRepository.findAll();
    }

    @Override
    public List<YongyouplatformEmplEntity> findAll(YongyouplatformEmplEntity entiy) throws Exception {
        return queryByEntity(entiy,false);
    }

    @Override
    public Page<YongyouplatformEmplEntity> findByEntity(YongyouplatformEmplEntity entiy, int page, int pagesize) throws Exception {
        return queryPageByEntity(entiy,page,pagesize,true);
    }

    @Override
    public boolean existsById(int id) throws Exception {
        return yongyouplatformEmplRepository.existsById(id);
    }

    @Override
    public void deleteByid(int id) throws Exception {
        yongyouplatformEmplRepository.deleteById(id);
    }

    private Specification queryParams(YongyouplatformEmplEntity entity) {
        Specification querySpecifi = new Specification<YongyouplatformEmplEntity>() {
            @Override
            public Predicate toPredicate(Root<YongyouplatformEmplEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtil.isNotNull(entity.getXm())) {
                    predicates.add(cb.equal(root.get("xm"), entity.getXm()));
                }

                if(StringUtil.isNotNull(entity.getXb())){
                    predicates.add(cb.equal(root.get("xb"),entity.getXb()));
                }
                if(entity.getGxsj()!=null){
                    predicates.add(cb.equal(root.get("gxsj"),entity.getGxsj()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return querySpecifi;
    }

    private List<YongyouplatformEmplEntity> queryByEntity(YongyouplatformEmplEntity entity, boolean isSort) throws Exception {

        Specification querySpecifi = queryParams(entity);

        List<YongyouplatformEmplEntity> list = null;
        if (isSort) {
            Sort sort = new Sort(Sort.Direction.DESC, "gxsj");
            list = yongyouplatformEmplRepository.findAll(querySpecifi, sort);
        } else {
            list = yongyouplatformEmplRepository.findAll(querySpecifi);
        }

        return list;
    }

    private Page<YongyouplatformEmplEntity> queryPageByEntity(YongyouplatformEmplEntity entity, int page, int pagesize, boolean isSort) throws Exception {

        Specification querySpecifi = queryParams(entity);
        Page<YongyouplatformEmplEntity> list = null;
        Pageable pageable = null;
        if (isSort) {
            pageable = PageRequest.of(page - 1, pagesize, Sort.by(new Sort.Order(Sort.Direction.DESC, "gxsj")));
        } else {
            pageable = PageRequest.of(page - 1, pagesize);
        }

        list = yongyouplatformEmplRepository.findAll(querySpecifi, pageable);


        return list;
    }


}
