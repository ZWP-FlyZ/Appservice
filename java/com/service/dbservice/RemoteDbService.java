package com.service.dbservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.service.dao.RemoteDao;
import com.service.model.Data;

@Service
public class RemoteDbService {
	
	  private RemoteDao remoteDao;
	  ApplicationContext ctx=null;
  
   public RemoteDbService()
   {
	   ctx=new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-remote.xml"); 
	   remoteDao = (RemoteDao)ctx.getBean(RemoteDao.class);
   }
   
   public Data getRemoteDataById(Integer uId)
   {
	  return remoteDao.getRemoteDataById(uId);
   }
}
