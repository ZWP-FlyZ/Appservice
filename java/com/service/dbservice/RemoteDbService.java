package com.service.dbservice;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.service.dao.RemoteDao;
import com.service.model.Data;
import com.service.model.MatchData;
import com.service.model.PerDataRem;
import com.service.model.PerDataRemS;
import com.service.pojo.ChangePerInfo;
import com.service.pojo.CommonInfo;
import com.service.pojo.RegInfo;
import com.service.pojo.UserInfo;

@Service
public class RemoteDbService {
	
    public enum RelType 
    {
    	RMARKS,RINT,RSTR
    }
	
	
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
   
   public Integer isContarnRelation(String RelTypeLike)
   {
	   return remoteDao.isConRelation(RelTypeLike);
   }
   //创建关系表
   public void creRelationTab(RelType type,String rname)
   {
	   remoteDao.insertRelation(rname);
		switch (type) {
		case RMARKS:
			remoteDao.creRelationTabForMarks(rname);
			break;
		case RINT:
			remoteDao.creRelationTabForInt(rname);
			break;
		case RSTR:
			remoteDao.creRelationTabForStr(rname);
			break;
		default:
			break;
	    }
   }
   
    public synchronized void RegUserData(int uid,UserInfo u)
	{
		RegInfo info = (RegInfo) u;
		remoteDao.insertUserInfo(uid, info.getReceiveFrom(), info.getSex(), 
				       info.getSchool(), info.getMajor(), info.getYear());
	}
    
    public PerDataRem GetPerDataRem(UserInfo u)
	{
    	CommonInfo info = (CommonInfo) u;
		return remoteDao.getPerDataRem(info.getReceiveFrom());
	}
	
	public PerDataRemS GetPerDataRemS(UserInfo u)
	{
		CommonInfo info = (CommonInfo) u;
		return remoteDao.getPerDataRemS(info.getReceiveFrom());
	}
       
    public int ChanPerData(UserInfo u)
	{
    	ChangePerInfo info =  (ChangePerInfo)u;
    	int t=remoteDao.chaPerDataRem(info.getReceiveFrom(), info.getNickname(), info.getSex(),
    			            info.getSchool(), info.getMajor(), info.getYear());
    	t+=ChanPerDataS(info);
    	return t;
    }
	private int ChanPerDataS(ChangePerInfo info)
	{
		int t = remoteDao.chaPerDataAddr(info.getReceiveFrom(),info.getAddrbuid(), info.getAddrrooom());
    	t+=remoteDao.chaPerDataBri(info.getReceiveFrom(), info.getBriday());
    	return t;
	}
	
	List <MatchData> GetMatchRand(String matchtb)//matchtb一定存在
	{
		return null;	
	}
	
	public void AddRelation(String RelationType,int Id1, int Id2)
	{
		
	}
   
}
