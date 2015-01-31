package com.service.dbservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.dao.LocalDao;
import com.service.model.Data;


public class LocalDbService {
	
	 private LocalDao localDao;

     public LocalDbService()
     {
    	@SuppressWarnings("resource")
		ApplicationContext  locctx=new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-local.xml"); 
    	localDao = (LocalDao)locctx.getBean(LocalDao.class);
    	locctx=null;
     }
	public Data getLocalDataById(Integer uId)
	{
		return localDao.getLocalDataById(uId);
	}
}
