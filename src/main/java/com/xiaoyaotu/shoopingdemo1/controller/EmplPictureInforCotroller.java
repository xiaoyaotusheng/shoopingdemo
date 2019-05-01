package com.xiaoyaotu.shoopingdemo1.controller;

import com.xiaoyaotu.shoopingdemo1.common.ApiPageResult;
import com.xiaoyaotu.shoopingdemo1.common.ApiResult;

import com.xiaoyaotu.shoopingdemo1.entity.EmplPictureInforEntity;
import com.xiaoyaotu.shoopingdemo1.service.IemplPictureInforService;
import com.xiaoyaotu.shoopingdemo1.vo.FileVo;
import com.xiaoyaotu.shoopingdemo1.utils.DateUtils;
import com.xiaoyaotu.shoopingdemo1.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Linqi on 2019-04-23.
 */
@Api(description = "员工图片附件信息管理")
@RestController
@RequestMapping("/files")
public class EmplPictureInforCotroller {

        @Resource
        private IemplPictureInforService iemplPictureInforService;



         //文件上传
     @ApiOperation(value = "单文件上传：FileVo对象 必填项：1.上传员工的照片信息 ：只填写-员工主键；2.上传证件图片信息：只填写- 证件主键；" +
             "3.上传学历证书图片信息：只填写学历工作主键。")
     @RequestMapping(value = "/fileUpload",method = {RequestMethod.POST, RequestMethod.GET})
     public  ApiResult<Object> fileUpload(HttpServletRequest request, MultipartFile file, FileVo fileVo){

            if(fileVo.getZjid()==0&&fileVo.getXxgzjlid()==0&&fileVo.getYgid()==0){
                return  ApiResult.FAILURE("员工ID，证件ID，学习工作经历ID 不能全为空！！");
            }

             if(fileVo.getYgid()!=0){
                 if(isExitPhoto(fileVo.getYgid())){//已有照片了
                     return  ApiResult.FAILURE("员工照片信息只能存一张，请删除后再去上传");
                 }
             }
           Date scsj=new Date();
           String filename = DateUtils.getStringByDateForDay4(scsj) +file.getOriginalFilename();
           String path = request.getSession().getServletContext().getRealPath("/upload/");
         try {
             FileUtil.uploadFile(path,filename,file); //文件信息保存
           //同步存数据库信息
             EmplPictureInforEntity entity=new EmplPictureInforEntity();
                  entity.setYgzj(fileVo.getYgid());
                  entity.setGzxxjlzj(fileVo.getXxgzjlid());
                  entity.setZjzj(fileVo.getZjid());
                  entity.setBz(fileVo.getBz());
                  entity.setTpcjsj(scsj);
                  entity.setTpcjsj(scsj);
                  entity.setTplj("upload/"+filename);
                  entity.setTpmc(filename);
                  entity=iemplPictureInforService.save(entity);
             return  ApiResult.SUCCESS(entity);
         } catch (IOException ioe) {
             ioe.printStackTrace();
             return ApiResult.FAILURE("文件上传失败");
         }catch (Exception e){
             e.printStackTrace();
             return ApiResult.FAILURE("文件上传失败");
         }

     }

    //文件上传
    @ApiOperation(value = "多文件上传 文件存放到“file”字段中，后台通过遍历file属性的值获取文件信息。FileVo对象必填项：1.上传员工的照片信息 ：只填写-员工主键；2.上传证件图片信息：只填写- 证件主键；"+
            "3.上传学历证书图片信息：只填写学历工作主键。")
    @RequestMapping(value = "/filesUpload",method = {RequestMethod.POST, RequestMethod.GET})
     public  ApiResult<Object> filesUpload(HttpServletRequest request, FileVo fileVo){
         if(fileVo.getZjid()==0&&fileVo.getXxgzjlid()==0&&fileVo.getYgid()==0){
             return  ApiResult.FAILURE("员工ID，证件ID，学习工作经历ID 不能全为空！！");
         }


         //获取文件信息
        List<MultipartFile> files= FileUtil.getfile(request);
        List<EmplPictureInforEntity>  list=new ArrayList<EmplPictureInforEntity>();
         if(files.size()!=0){
              int i=0;
            System.out.println("文件总数为："+files.size());
             try{
                  for(MultipartFile file: files){
                      Date scsj=new Date();
                      i=i++;
                      String filename = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                      String path = request.getSession().getServletContext().getRealPath("/upload/");
                      FileUtil.uploadFile(path,filename,file); //文件信息保存
                      //同步存数据库信息
                      EmplPictureInforEntity entity=new EmplPictureInforEntity();
                      entity.setYgzj(fileVo.getYgid());
                      entity.setGzxxjlzj(fileVo.getXxgzjlid());
                      entity.setZjzj(fileVo.getZjid());
                      entity.setBz(fileVo.getBz());
                      entity.setTpcjsj(scsj);
                      entity.setTpcjsj(scsj);
                      entity.setTplj("upload/"+filename);
                      entity.setTpmc(filename);
                      entity=iemplPictureInforService.save(entity);
                      list.add(entity);
                  }
              }catch (IOException ioe){
                  ioe.printStackTrace();
                  return  ApiResult.FAILURE("文件保存操作失败："+"第"+i+"个文件出了问题");
              }catch (Exception e){
                 e.printStackTrace();
                  return   ApiResult.FAILURE();
              }
         }else{
             return ApiResult.FAILURE("文件上传失败，没有找到对应的文件信息");
         }

         return ApiResult.SUCCESS(list);
     }



    @ApiOperation(value = "根据主键查询-图片信息")
    @RequestMapping(value = "/findById",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParam(paramType = "query",dataType ="int",name = "id",value = "主键",required = true)
    public  ApiResult<Object> findById(@RequestParam int id){
        try{
            if(id==0){
                return  ApiResult.FAILURE("查询失败，该id对应记录不存在");
            }
            EmplPictureInforEntity entity=iemplPictureInforService.findByid(id);
            return  ApiResult.SUCCESS(entity);
        }catch (NullPointerException nulle){
            nulle.printStackTrace();
            return ApiResult.FAILURE("查询失败,主键不能为空");
        }catch (Exception e){
            e.getMessage();
            return  ApiResult.FAILURE("查询失败:"+e.getMessage());
        }

    }


    @ApiOperation(value = "根据员工id查询照片信息")
    @RequestMapping(value = "/findPageByYgid",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType ="int",name = "ygid",value = "员工ID",required = true)
    })
    public ApiResult<Object> findPageByYgid(@RequestParam int ygid){
        try{
            if(ygid==0){
                return ApiPageResult.FAILURE("查询失败,员工ID不能为空");
            }

            List<EmplPictureInforEntity> list = iemplPictureInforService.findByYgId(ygid);
            return ApiResult.SUCCESS(list);
        }catch (NullPointerException nulle){
            nulle.printStackTrace();
            return ApiPageResult.FAILURE("查询失败,员工ID不能为空");
        }catch (Exception e){
            e.getMessage();
            return ApiPageResult.FAILURE("查询失败:"+e.getMessage());
        }
    }

    @ApiOperation(value = "根据证件id查询证件图片信息")
    @RequestMapping(value = "/findPageByZjid",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType ="int",name = "zjid",value = "证件ID",required = true),

    })
    public ApiResult<Object> findPageByZjid(@RequestParam int zjid){
        try{
            if(zjid==0){
                return ApiPageResult.FAILURE("查询失败,员工ID不能为空");
            }

            List<EmplPictureInforEntity> list = iemplPictureInforService.findByZjId(zjid);
            return ApiResult.SUCCESS(list);
        }catch (NullPointerException nulle){
            nulle.printStackTrace();
            return ApiResult.FAILURE("查询失败,员工ID不能为空");
        }catch (Exception e){
            e.getMessage();
            return ApiResult.FAILURE("查询失败:"+e.getMessage());
        }
    }

    @ApiOperation(value = "根据学习工作经历id查询 学位证书附件信息")
    @RequestMapping(value = "/findPageByXxgzjlid",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType ="int",name = "xxgzjlid",value = "学习工作经历ID",required = true),
    })
    public ApiResult<Object> findPageByXxgzjlid(@RequestParam int xxgzjlid){
        try{
            if(xxgzjlid==0){
                return ApiPageResult.FAILURE("查询失败,员工ID不能为空");
            }

            List<EmplPictureInforEntity> list = iemplPictureInforService.findByXxgzjlId(xxgzjlid);
            return ApiResult.SUCCESS(list);
        }catch (NullPointerException nulle){
            nulle.printStackTrace();
            return ApiResult.FAILURE("查询失败,员工ID不能为空");
        }catch (Exception e){
            e.getMessage();
            return ApiResult.FAILURE("查询失败:"+e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键删除-图片信息")
    @RequestMapping(value = "/deleteById",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParam(paramType = "query",dataType ="int",name = "id",value = "主键",required = true)
    public ApiResult<Object>  deleteById(@RequestParam int id){
         if(id==0){
             return  ApiResult.FAILURE("id 不能为空");
         }
         try {
             if (iemplPictureInforService.existsById(id)) {
                //先删除图片信息文件
                 EmplPictureInforEntity entity =iemplPictureInforService.findByid(id);
                 File   file=new File(entity.getTplj());
                   file.delete();
                   //再删除数据库里的信息
                   iemplPictureInforService.deleteByid(id);

             }else{
                 return  ApiResult.FAILURE("没有找到该图片");
             }
         }catch (Exception e){
             e.printStackTrace();
             return ApiResult.FAILURE("删除操作错误");
         }

         return ApiResult.SUCCESS();
    }


     private boolean isExitPhoto(int ygid){

         try {
               int con =iemplPictureInforService.findByYgId(ygid).size();
                 if(con>1){
                     return  true;
                 }
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             return false;
         }


     }
}
