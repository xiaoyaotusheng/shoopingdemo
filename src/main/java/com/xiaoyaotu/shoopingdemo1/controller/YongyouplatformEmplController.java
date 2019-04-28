package com.xiaoyaotu.shoopingdemo1.controller;


import com.xiaoyaotu.shoopingdemo1.service.IyongyouplatformEmplService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Linqi on 2019-04-27.
 */
@RestController
@Api("用友平台对接-数据导出管理")
public class YongyouplatformEmplController {

       @Resource
      private IyongyouplatformEmplService iyongyouplatformEmplService;

       public void exportExcel(){

           //第一步：获取数据
               int id=0;
               try {
                   iyongyouplatformEmplService.findByid(id); //通过id数组查询

               }catch (Exception e){
                   e.printStackTrace();
               }
           //确认导出的Excel表格的格式 2003版还是2007版


    }
}
