package com.xiaoyaotu.shoopingdemo1.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** [工厂类]
 * Created by Linqi on 2019-04-19.
 */
@Service("register")
public class DictWorkFactory implements InitializingBean, ApplicationContextAware {

     private  Map<String, IdictListWorkService>  serviceImpMap =new HashMap<>() ;

     private ApplicationContext applicationContext;

    // 获取Spring的上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
           this.applicationContext=applicationContext;
    }
    // 注册接口IdictListWorkService的所有实现的bean，
     // 可以按照自己的规则放入 注册中心 serviceImpMap里
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String,IdictListWorkService> beanMap=applicationContext.getBeansOfType(IdictListWorkService.class);
        String name=null;
        for(IdictListWorkService idictListWorkService:beanMap.values()){
            name=idictListWorkService.getClass().getSimpleName();
            //System.out.println("--key:t"+name);
            //将类名，做为key,
            serviceImpMap.put(name,idictListWorkService);
        }
    }

   public  IdictListWorkService getIdictListWorkService(String  name){

        return  serviceImpMap.get(name);
   }

}
