package com.xiaoyaotu.shoopingdemo1.controller;

import com.xiaoyaotu.shoopingdemo1.common.ApiResult;

import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;
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
 * Created by Linqi on 2019-04-03.
 */
@Api(description = "字典词条信息管理")
@RestController
@RequestMapping("/dictList")
public class DictionarylistController {

         @Resource
         private IdictionaryService    idictionaryService;

         @Resource
         private IdictionarylistService idictionarylistService;

         @ApiOperation(value = "添加词条")

         @RequestMapping(value = "/addDictList",method = RequestMethod.POST)
         @ApiImplicitParams({
                 @ApiImplicitParam(paramType = "query",name = "zdid",value = "字典ID",required =true,dataType = "Integer"),
                 @ApiImplicitParam(paramType = "query",name = "ctmc",value = "词条名称",required =true,dataType = "String"),
                 @ApiImplicitParam(paramType = "query",name = "ctdm",value = "词条代码",required =true,dataType = "Integer")

         })
         public ApiResult<Object>  addDictList(@RequestParam Integer zdid,
                                               @RequestParam String ctmc,
                                               @RequestParam String ctdm ){
             if( 0==zdid){
                return  ApiResult.FAILURE("字典ID不能为空！！");
             }
             if(StringUtil.isNull(ctmc)){
                return  ApiResult.FAILURE("词条名称不能为空！！");
             }
             try {
                 //判断该字典是否存在
                 if (idictionaryService.existsById(zdid)) { //存在才会去添加信息
                     //判断词条是否已存在

                     DictionarylistEntity entity=new DictionarylistEntity();
                     entity.setZdid(zdid);
                     entity.setCtmc(ctmc);
                     entity.setCtdm(ctdm);
                     List<DictionarylistEntity> list = idictionarylistService.findCtxxByEntity(entity);
                      if(list.size()==0) {
                          return ApiResult.SUCCESS(idictionarylistService.save(entity));
                      }else{
                          return  ApiResult.FAILURE("该词条信息已存在");
                      }
                 } else{
                     return  ApiResult.FAILURE("该字典不存在，无法添加词条信息");
                 }

             }catch (Exception e){
                   e.printStackTrace();
                 return  ApiResult.FAILURE();
             }

         }


        @ApiOperation(value = "更新词条")

        @RequestMapping(value = "/updateDictList",method = RequestMethod.POST)
        @ApiImplicitParams({
                @ApiImplicitParam(paramType = "query",name = "id",value = "ID",required =true,dataType = "Integer"),
                @ApiImplicitParam(paramType = "query",name = "ctmc",value = "词条名称",required =false,dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "ctdm",value = "词条代码",required =false,dataType = "String")

        })
        public ApiResult<Object> updateDictList(@RequestParam Integer id,
                                        @RequestParam(required = false) String ctmc,
                                        @RequestParam(required = false) String ctdm){
           if(0==id){
               return ApiResult.FAILURE("ID不能为空");
           }
           try {
               if (idictionarylistService.existsById(id)) {
                      DictionarylistEntity old=idictionarylistService.findById(id);
                      DictionarylistEntity entity=new DictionarylistEntity();
                            entity.setCtdm(ctdm);
                            entity.setCtmc(ctmc);
                   entity= idictionarylistService.update(entity ,old);
                   return ApiResult.SUCCESS(entity);
               } else {
                   return ApiResult.FAILURE("该词条不存在！！");
               }
           }catch (Exception e){
                 e.printStackTrace();
                 return  ApiResult.FAILURE( );
           }

        }


    @ApiOperation("根据id 注销词条")

    @RequestMapping(value = "/cancellationDictById", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "Integer")
    public ApiResult<Object> cancellationDictById(@RequestParam Integer id) {
        if (id == 0) {
            return ApiResult.FAILURE("主键不能为空！！");
        }
        try {

                int cn = idictionarylistService.cancellationById(id);
                if (cn == 1) {
                    return ApiResult.SUCCESS("注销成功");
                } else {
                    return ApiResult.FAILURE("注销失败，可能已经被注销了");
                }
        }catch (Exception e){
            e.printStackTrace();
            return  ApiResult.FAILURE();
        }
    }


    @ApiOperation("根据id 激活词条")

    @RequestMapping(value = "/activationDictById", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "Integer")
    public ApiResult<Object> activationDictById(@RequestParam Integer id) {
        if (id == 0) {
            return ApiResult.FAILURE("主键不能为空！！");
        }
        try {
            int cn = idictionarylistService.unCancellationById(id);
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


    @ApiOperation("根据id 查询词条")
    @RequestMapping(value = "/findByid", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "Integer")
    public ApiResult<Object> findByid(@RequestParam Integer id){
        if (id == 0) {
            return ApiResult.FAILURE("主键不能为空！！");
        }
        try{
             DictionarylistEntity entity= idictionarylistService.findById(id);
             return ApiResult.SUCCESS(entity);
        }catch (Exception e){
             e.printStackTrace();
             return ApiResult.FAILURE();
        }
    }


    @ApiOperation("根据查询条件查询词条信息，【不填写条件默认忽略该条件查询】")
    @RequestMapping(value = "/findAll",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "zdid",value = "字典ID",required =false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "ctmc",value = "词条名称",required =false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "ctdm",value = "词条代码",required =false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "zxbz",value = "注销标志",required =false,dataType = "String"),

            })
    public ApiResult<Object> findAll(
                                     @RequestParam(required = false) String zdid,
                                     @RequestParam(required = false) String ctmc,
                                     @RequestParam(required = false) String ctdm,
                                     @RequestParam(required = false) String zxbz
                                     ){

                try{
                         DictionarylistEntity entity=new  DictionarylistEntity();
                            entity.setCtdm(ctdm);
                            entity.setCtmc(ctmc);
                            entity.setZxbz(zxbz);
                            if(StringUtil.isNotNull(zdid)){
                                int  zdids=Integer.parseInt(zdid);
                                 entity.setZdid(zdids);
                            }else{
                                entity.setZdid(0);
                            }

                     List<DictionarylistEntity> dictList=idictionarylistService.findCtxxByEntity(entity);
                      return ApiResult.SUCCESS(dictList);
                }catch (Exception e){
                     e.printStackTrace();
                     return ApiResult.FAILURE();
                }

    }





}
