package com.xiaoyaotu.shoopingdemo1.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.xiaoyaotu.shoopingdemo1.common.SessionHelper;
import com.xiaoyaotu.shoopingdemo1.entity.DictionarylistEntity;
import com.xiaoyaotu.shoopingdemo1.service.IdictListWorkService;
import com.xiaoyaotu.shoopingdemo1.vo.DictVo;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linqi on 2019-04-19.
 */
@Service("d_SYS_BaseDM_Service")
public class DictWorkBaseService implements IdictListWorkService {

    @Override
    public  void getZDXX(List<DictionarylistEntity>  listDict,String zddm) { //传递对应字典信息-这个是普通字典
          //词条信息调整
          List<DictVo>  dictMsg= new ArrayList<DictVo>();
          if(listDict.size()!=0) {
              for (DictionarylistEntity iterm : listDict) { //遍历词条信息
                  DictVo vo = new DictVo();
                  vo.setValue(iterm.getCtdm().toString()); //获取词条代码
                  vo.setLabel(iterm.getCtmc());//获取词条名称
                  dictMsg.add(vo);
              }
          }
            /********************************** 写文件固定信息****************************************************************/
            //生成js文件
          String fileName=zddm+".js";
           String path= SessionHelper.getSession().getServletContext().getRealPath("dicts");  //文件路径
            File file=new File(path+"/"+fileName);
        try {

            if(file.exists()){ //创建文件
                   file.delete();
                   file.createNewFile();
             }else{
                file.createNewFile();
            }
            //往文件里写数据，并覆盖掉原先的
            OutputStream out=new FileOutputStream(file);
            BufferedWriter rd=new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
             Object json = JSONObject.toJSON(dictMsg);
              rd.write(json.toString());
               rd.close();
               out.close();
            System.out.println("生成："+fileName+"成功");
             } catch (IOException e) {
                e.printStackTrace();
            System.out.println("生成："+fileName+"失败");
        }


    }



}
