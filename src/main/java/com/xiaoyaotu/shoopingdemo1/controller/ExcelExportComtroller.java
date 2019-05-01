package com.xiaoyaotu.shoopingdemo1.controller;


import com.xiaoyaotu.shoopingdemo1.entity.*;
import com.xiaoyaotu.shoopingdemo1.service.*;

import com.xiaoyaotu.shoopingdemo1.vo.FileVo;
import com.xiaoyaotu.shoopingdemo1.utils.DateUtils;
import com.xiaoyaotu.shoopingdemo1.utils.ExcelUtil;
import com.xiaoyaotu.shoopingdemo1.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Linqi on 2019-04-29.
 */
@Api(description = "信息导出-管理")
@RestController
@RequestMapping(value = "/export",method = {RequestMethod.GET, RequestMethod.POST})
public class ExcelExportComtroller {

    private   String filepash=null; //文件名
    private   String sheetName=null;//表名
    private   List<String> titles=null;//列名数组
    private   List<Map<String, Object>> values=null;//数据值
    private   String filerealPath=null; //文件路径信息

    @Resource
    private IparamstypemsService iparamstypemsService;
    @Resource
    private IemplPictureInforService iemplPictureInforService;














    @ApiOperation(value = "员工的对应图片信息导出")
    @RequestMapping(value = "/findPageByXxgzjlid",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "hzdm", value = "后缀名代号： 1：xls【2003版到2007版以前】，2：xlsx【2007版及以后】",required = true)

    })
    public void findPageByXxgzjlid( FileVo fileVo,
                                   @RequestParam String hzdm,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        try{

            if(fileVo.getZjid()==0&&fileVo.getXxgzjlid()==0&&fileVo.getYgid()==0){
                throw new Exception("员工ID，证件ID，学习工作经历ID 不能全为空！！");
            }
            if(StringUtil.isNull(hzdm)){
                throw new Exception("后缀名代号不能未开工");
            }
            String names=null;
            if(hzdm.equals("1")){
                names=ExcelUtil.OFFICE_EXCEL_XLS;
            }else{
                names=ExcelUtil.OFFICE_EXCEL_XLSX;
            }
            EmplPictureInforEntity entity=new EmplPictureInforEntity();
               entity.setZjzj(fileVo.getZjid());
               entity.setGzxxjlzj(fileVo.getXxgzjlid());
               entity.setYgzj(fileVo.getYgid());
            List<EmplPictureInforEntity> list = iemplPictureInforService.findAll(entity);
            sheetName="员工的对应图片信息";//表名
            filepash=sheetName+ DateUtils.getStringByDateForDay4(new Date()) +"."+names; //文件路径
            filerealPath=request.getSession().getServletContext().getRealPath("/download/")+filepash;
            titles=getTableTitle(entity,6);//列名数组
            values=getPictureValues(list,6);//数据值
            Workbook workbook = ExcelUtil.getExcel(filerealPath, sheetName, titles, values);
            ExportExcle(workbook,request,response);

        }catch (NullPointerException nulle){
            nulle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private  void ExportExcle(Workbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String userAgent = request.getHeader("USER-AGENT");
        String newFilename = URLEncoder.encode(filepash, "UTF-8").replace("+", " ");
        if (userAgent != null) {
            if (userAgent.contains("edge") || userAgent.contains("Edge") || userAgent.contains("Trident") || userAgent.contains("trident")) {
                newFilename = URLEncoder.encode(filepash, "UTF-8").replace("+", " ");
            } else {
                newFilename = new String(filepash.getBytes("UTF-8"), "ISO8859-1");
            }
        }
        response.addHeader("Content-Disposition", "attachment;filename=" + newFilename);
        response.setContentType("application/vnd.ms-excel");
        OutputStream toClient = response.getOutputStream();
        workbook.write(toClient);
    }




    private  List<Map<String, Object>>  getPictureValues(List<EmplPictureInforEntity>list , int number)throws Exception{
        List<Map<String, Object>> getValues= new ArrayList<Map<String, Object>>();
        for(EmplPictureInforEntity object :list){ //获取一条记录
            getValues.add(getMap(object,number));
        }
        return  getValues;
    }

    //需要一个表来存实体类的属性名和中文注释的对接信息
    private List<String> getTableTitle(Object object,int number)throws Exception{
        List<String>  sxzwm=new ArrayList<String>();
        List<ParamstypemsEntity>  params=iparamstypemsService.findBySxlb(number);
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            for(ParamstypemsEntity param :params){
                if(f.getName().equals(param.getSxm())){
                    sxzwm.add(param.getSxzwzs());
                }
            }
        }
        return  sxzwm;

    }
    private  Map<String, Object> getMap(Object object,int number )throws Exception {
        List<ParamstypemsEntity> params = iparamstypemsService.findBySxlb(number);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Field f : object.getClass().getDeclaredFields()) {//记录存值
            f.setAccessible(true);
            for (ParamstypemsEntity param : params) {
                if (f.getName().equals(param.getSxm())) {
                    map.put(param.getSxzwzs(), f.get(object)); //中文名做Key
                }
            }
        }
        return map;
    }

}
