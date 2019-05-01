package com.xiaoyaotu.shoopingdemo1.common;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {
    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        return request;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static Object getuser() {
        return getSession().getAttribute("id");
    }

    public static Integer getrole() {
        return (Integer) getSession().getAttribute("js");
    }
//    public static TCyMemberBasEntity getuser() {
//        TCyMemberBasEntity entity = (TCyMemberBasEntity) getSession().getAttribute("user");
//        return entity;
//    }
}
