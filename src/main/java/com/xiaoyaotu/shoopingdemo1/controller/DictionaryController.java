package com.xiaoyaotu.shoopingdemo1.controller;

import com.xiaoyaotu.shoopingdemo1.common.ApiResult;

import com.xiaoyaotu.shoopingdemo1.entity.DictionaryEntity;
import com.xiaoyaotu.shoopingdemo1.service.IdictionaryService;
import com.xiaoyaotu.shoopingdemo1.service.IdictionarylistService;
import com.xiaoyaotu.shoopingdemo1.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Linqi on 2019-04-02.
 */
@Api(description = "字典信息管理")
@RestController
@RequestMapping("/dict")
public class DictionaryController {
        @Resource
        private IdictionaryService idictionaryService;

        @Resource
        private IdictionarylistService idictionarylistService;

         @RequestMapping(value = "/addDict",method = RequestMethod.POST)
         @ApiOperation(value = "新增字典")

         @ApiImplicitParams({
                 @ApiImplicitParam(dataType = "String", paramType = "query", name = "zdmc", value = "字典名称", required = true),
                 @ApiImplicitParam(dataType = "String", paramType = "query", name = "zddm", value = "字典代码", required = true),
                 @ApiImplicitParam(dataType = "String", paramType = "query", name = "zdlx", value = "字典类型[1:下拉列表 2：树状列表]", required = true)
         })
        public ApiResult<Object> addDict(@RequestParam String zdmc,
                                         @RequestParam String zddm,
                                                        String zdlx
                                                    ){
            if(StringUtil.isNull(zdmc)){
                return ApiResult.FAILURE("字典名称不能为空！！");
            }
            if(StringUtil.isNull(zddm)){
               return ApiResult.FAILURE("字典代码不能为空！！");
            }
             try {
                 //通过字典代码和名称字典是否已存在
                 if (idictionaryService.findZdxxByZddmAndZdmc(zddm, zdmc)) {
                     return ApiResult.FAILURE("字典已存在！！");
                 } else {
                     DictionaryEntity entity = new DictionaryEntity();
                     entity.setZdzwm(zdmc);
                     entity.setZdywm(zddm);
                     entity.setZdlx(zdlx);
                     DictionaryEntity saveEntity = idictionaryService.save(entity);
                     if (!(saveEntity == null)) {
                         return ApiResult.SUCCESS(saveEntity);
                     } else {
                         return ApiResult.FAILURE("添加失败");
                     }
                 }
             }catch (Exception e){
                e.printStackTrace();
                return ApiResult.FAILURE();
             }

        }


        @RequestMapping(value = "/updateDict",method = RequestMethod.POST)

        @ApiOperation(value = "更新字典")
        @ApiImplicitParams({
                @ApiImplicitParam(dataType = "Integer", paramType = "query", name = "id", value = "字典ID", required = true),
                @ApiImplicitParam(dataType = "String", paramType = "query", name = "zdmc", value = "字典名称", required = false),
                @ApiImplicitParam(dataType = "String", paramType = "query", name = "zddm", value = "字典代码", required = false)
        })
        public  ApiResult<Object>  updateDict(@RequestParam Integer id,
                                              @RequestParam(required = false) String zdmc,
                                              @RequestParam(required = false) String zddm
                                                ){
            if( id==0){
                return ApiResult.FAILURE("字典ID不能为空！！");
            }
            try {
                if (idictionaryService.existsById(id)) {
                        DictionaryEntity oldEntity = idictionaryService.findById(id);
                        DictionaryEntity newEntity = new DictionaryEntity();
                        newEntity.setZdzwm(zddm);
                        newEntity.setZdywm(zdmc);
                        newEntity.setId(id);
                        DictionaryEntity entity2 = idictionaryService.update(newEntity, oldEntity);
                        idictionarylistService.updateDictxx(zdmc, zddm, id);
                        return ApiResult.SUCCESS(entity2);

                } else {
                    return ApiResult.FAILURE("修改失败,该字典不存在！！");
                }
            }catch (Exception e){
                e.printStackTrace();
                return  ApiResult.FAILURE();
            }
        }


    @RequestMapping(value = "/findDicts",method ={RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "根据条件查询字典信息【不填写条件默认忽略该条件查询】")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "zdmc",value = "字典名称",required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "zddm",value = "字典代码",required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "zxbz",value = "注销标志，[0：未注销，1：已注销]",required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "zdlx",value = "字典类型",required = false,dataType = "String")
    })
       public    ApiResult<Object>  findDicts(   @RequestParam(required = false) String  zdmc,
                                                 @RequestParam(required = false) String  zddm,
                                                 @RequestParam(required = false) String  zxbz,
                                                 @RequestParam(required=false)   String  zdlx
       ){
             try{
                  DictionaryEntity entity=new DictionaryEntity();
                           entity.setZdzwm(zdmc);
                           entity.setZdywm(zddm);
                           entity.setZxbz(zxbz);
                           entity.setZdlx(zdlx);
                 List<DictionaryEntity> entityList= idictionaryService.findZdxxByEntity(entity);
                 return  ApiResult.SUCCESS(entityList);
             }catch (Exception e){
                        e.printStackTrace();
                 return  ApiResult.FAILURE("查询失败");
             }


    }

    @RequestMapping(value = "/findDictByid",method ={RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "根据ID查询单个字典")
    @ApiImplicitParam(paramType = "query",name = "id",value = "ID",required = true,dataType = "Integer")
    public  ApiResult<Object>   findDictByid(Integer id){
            if(id==null||id==0){
                return ApiResult.FAILURE("ID不能为空！！");
            }
           try{
             DictionaryEntity entity=idictionaryService.findById(id);
             return ApiResult.SUCCESS(entity);
           }catch (Exception e){
                    e.printStackTrace();
               return ApiResult.FAILURE("查询失败");
           }
    }




    @RequestMapping(value = "/findByZddm",method ={RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "根据字典代码查询单个字典")
    @ApiImplicitParam(paramType = "query",name = "zddm",value = "字典代码",required = true,dataType = "String")
    public ApiResult<Object> findByZddm(String zddm){
        if(StringUtil.isNull(zddm)){
            return  ApiResult.FAILURE("字典代码不能为空");
        }
        try{
            DictionaryEntity entity=idictionaryService.findZdxxByZddm(zddm);
            return  ApiResult.SUCCESS(entity);
        }catch (Exception e){
              e.printStackTrace();
            return ApiResult.FAILURE();
        }
    }

    @ApiOperation("根据id 注销字典")
    @RequestMapping(value = "/cancellationDictById", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "Integer")
    public ApiResult<Object> cancellationDictById(@RequestParam Integer id) {
        if (id == 0) {
            return ApiResult.FAILURE("主键不能为空！！");
        }
        try {
            if (idictionaryService.isAbleById(id)) {
                int cn = idictionaryService.cancellationById(id);
                if (cn == 1) {
                    return ApiResult.SUCCESS("注销成功");
                } else {
                    return ApiResult.FAILURE("注销失败，可能已经被注销了");
                }
            } else {
                return ApiResult.FAILURE("该字典不能被注销,或者不存在！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  ApiResult.FAILURE();
        }
    }

    @ApiOperation("根据id 激活字典")

    @RequestMapping(value = "/activationDictById", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "Integer")
    public ApiResult<Object> activationDictById(@RequestParam Integer id) {
        if (id == 0) {
            return ApiResult.FAILURE("主键不能为空！！");
        }
         try {
             int cn = idictionaryService.unCancellationById(id);
             if (cn == 1) {
                 return ApiResult.SUCCESS("激活成功");
             } else {
                 return ApiResult.FAILURE("激活失败，可能已经被激活了");
             }
         }catch (Exception e){
            e.printStackTrace();
            return  ApiResult.FAILURE();
         }
    }






    @RequestMapping(value = "/deleteDictByid",method = RequestMethod.POST)
    @ApiOperation(value = "根据ID删除字典")

    @ApiImplicitParam(paramType = "query",name = "id",value = "字典ID",required = true,dataType = "Integer")
    public  ApiResult<Object>  deleteDictByid(Integer id){

          if(id==0){
              return ApiResult.FAILURE("id不能为空");
          }
        try{
            if(idictionaryService.existsById(id)){
                idictionaryService.deleteById(id);
                return  ApiResult.SUCCESS("删除成功");
            }else{
                return ApiResult.FAILURE("删除失败，该字典不存在！！");
            }

        }catch (Exception e){
             e.printStackTrace();
            return ApiResult.FAILURE();
        }

    }


}
