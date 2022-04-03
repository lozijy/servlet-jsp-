package com.Lozijy.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCount implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer  attribute = (Integer)servletContext.getAttribute("OnlineCount");
        if(attribute==null){
            attribute=new Integer(1);
        }else{
            int count=attribute.intValue();
            attribute=new Integer(count+1);
        }
        servletContext.setAttribute("OnlineCount",attribute);


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer  attribute = (Integer)servletContext.getAttribute("OnlineCount");
        if(attribute==null){
            attribute=new Integer(0);
        }else{
            int count=attribute.intValue();
            attribute=new Integer(count-1);
        }
        servletContext.setAttribute("OnlineCount",attribute);

    }
}
