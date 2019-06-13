package com.xiaoyaotu.shoopingdemo1.controller;


import com.xiaoyaotu.shoopingdemo1.common.ApiResult;
import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;
import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;
import com.xiaoyaotu.shoopingdemo1.service.IdictionaryService;
import com.xiaoyaotu.shoopingdemo1.service.IdictionarylistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * [字典JS 文件生成]
 * Created by Linqi on 2019-04-19.
 */
@Api(description = "字典JS文件生成")
@RestController
@RequestMapping("/dictWork")
public class DictWorkController {
     @Resource
     private IdictionaryService idictionaryService;

     @Resource
     private IdictionarylistService idictionarylistService;


     @ApiOperation("点击生成字典信息")
     @RequestMapping(name = "/greatDicts",method ={RequestMethod.GET, RequestMethod.POST})
     public ApiResult<Object> greatDicts(){
            try {
                readDictionary();
            }catch (Exception e){
                  e.printStackTrace();
                return ApiResult.FAILURE(e.getMessage());
            }
         return ApiResult.SUCCESS("生成-完毕");
     }




     //获取字典信息
     private String readDictionary( ) {
           //d读取字典表信息
              DictionaryEntity entity=new DictionaryEntity();
                  entity.setZxbz("0");
           List<DictionaryEntity> list =idictionaryService.findZdxxByEntity(entity);
              for(DictionaryEntity iterm : list){
                    readEntry(iterm);
              }

         return "生成完毕";
     }

     //获取词条信息,并生成js文件
    private void  readEntry( DictionaryEntity dictEntity){
                 DictionarylistEntity dictListEntity = new DictionarylistEntity();
                      dictListEntity.setZdid(dictEntity.getId());
                      dictListEntity.setZdywm(dictEntity.getZdywm());
                      dictListEntity.setZdzwm(dictEntity.getZdzwm());
                      dictListEntity.setZxbz("0");
               List<DictionarylistEntity>  listDict=idictionarylistService.findCtxxByEntity(dictListEntity);





    }


}
