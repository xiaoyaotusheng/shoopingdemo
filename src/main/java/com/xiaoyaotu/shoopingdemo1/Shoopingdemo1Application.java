package com.xiaoyaotu.shoopingdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Shoopingdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Shoopingdemo1Application.class, args);
    }

    //添加类型转换器
     @Bean
     public Converter<String, Date> addDateConverter(){
        return new Converter<String, Date>() {
            @Override
            public Date convert(String souce) {
                SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-mm-dd");
                Date time=null;
                try {
                    time= sdf1.parse(souce);
                } catch (ParseException e) {

                }
                   if(time==null){
                try {
                    time=sdf2.parse(souce);
                } catch (ParseException e) {
                  return null;
                }
                      }

                return time;
            }
        };



     }

     //避免前端传递“null”字符串导致的空值无法为空。
    @Bean
    public  Converter<String,String> addNewConvert2(){
        return  new Converter<String,String>(){
            @Override
            public String convert(String s) {
                if("null".equals(s)){
                    s=null;
                }
                return s;
            }
        };
    }

}
