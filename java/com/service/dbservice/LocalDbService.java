package com.service.dbservice;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.dao.LocalDao;
import com.service.model.BsReplyData;
import com.service.model.BsThemeData;
import com.service.model.Data;
import com.service.model.LogInData;
import com.service.model.PerDataLoc;
import com.service.model.PerDataLocS;
import com.service.pojo.ChangePerInfo;
import com.service.pojo.CommonInfo;
import com.service.pojo.CreateBsInfo;
import com.service.pojo.RegInfo;
import com.service.pojo.ReplyBsInfo;
import com.service.pojo.UserInfo;

public class LocalDbService {
	
	 private LocalDao localDao;
	// private Logger logger = Logger.getLogger(LocalDbService.class);
	 
     public LocalDbService()
     {
    	@SuppressWarnings("resource")
		ApplicationContext  locctx=new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-local.xml"); 
    	localDao = (LocalDao)locctx.getBean(LocalDao.class);
    	locctx=null;
     }
	public Data GetLocalDataById(Integer uId)
	{
		return localDao.getLocalDataById(uId);
	}
	
	public int Count(String tbname)
	{
		return localDao.count(tbname);
	}
	
	public boolean CheckUserName(String name)
	{
		//logger.debug(" count  "+localDao.checkUserName(name.hashCode()));
		return localDao.checkUserName(name.hashCode())==0;
	}
	
	public synchronized void    RegUserData(int uid,UserInfo u)
	{
		RegInfo info = (RegInfo) u;
		localDao.insertUserInfo(uid,info.getReceiveFrom(),info.getPassword(),info.getReceiveFrom().hashCode());
	}
	
	public LogInData GetLogInData(UserInfo u)
	{
		return localDao.getLogInData(((CommonInfo)u).getReceiveFrom().hashCode());
	}
	
	public PerDataLoc GetPerDataLoc(UserInfo u)
	{
		CommonInfo info = (CommonInfo) u;
		return localDao.getPerDataLoc(info.getReceiveFrom());
	}
	
	public PerDataLocS GetPerDataLocS(UserInfo u)
	{
		CommonInfo info = (CommonInfo) u;
		return localDao.getPerDataLocS(info.getReceiveFrom());
	}
	
	public int ChanPerData(UserInfo u)
	{
		ChangePerInfo info =  (ChangePerInfo)u;
		int t = localDao.chaPerDataLoc(info.getReceiveFrom(),info.getNickname(), info.getSelfMark(),info.getOtherMark(), 
				  info.getMtimes(), info.getOtherTimes(), info.getSelfTimes());
		 t+=ChanPerDataS(info);	
		 return t;
	}
	private int ChanPerDataS(ChangePerInfo info)
	{
		int t=localDao.chaPerDataSign(info.getReceiveFrom(),info.getSign());
		    t+=localDao.chaPerDataCont(info.getReceiveFrom(),info.getContact());
		return t;
	}
	
	public void AddMsgCache(UserInfo u)
	{
		CommonInfo info = (CommonInfo) u;
		localDao.addMsgCache2(info.getSendTo(), info.getValues());
	}
	public String GetMsgCacheAndDelete(UserInfo u)
	{
		String tmpString = localDao.getMsgCache(((CommonInfo)u).getReceiveFrom());
		if(tmpString!=null)
			localDao.delMsgCache(((CommonInfo)u).getReceiveFrom());	
		return tmpString;
	}
	
	public void CreateBs(String bstype)
	{
		localDao.createBsMain(bstype);
		localDao.insertBsName(bstype);
		localDao.createBsBody(bstype+"Body");
		localDao.insertBsName(bstype+"Body");
		localDao.createBsReply(bstype+"Reply");
		localDao.insertBsName(bstype+"Reply");
	}
	public int IsContainBBs(String bsNameLike)
	{
		return localDao.isContainBBs(bsNameLike);
	}
	
	public int AddBs(UserInfo u)
	{
		CreateBsInfo info = (CreateBsInfo)u;
		int t = localDao.addBsMain(info);
		t+=localDao.addBsBody(info.getBstype()+"Body", info.getBody(), info.getBsId());
		return t;
	}
	
	public int DeleteBs(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		Integer t = localDao.deleteBsMain(info.getValues(), info.getOv());
		localDao.deleteBsBody(info.getValues()+"Body", info.getOv());
		localDao.deleteBsReply(info.getValues()+"Reply", info.getOv());
		return t;
	}
	public List<BsThemeData> SearchBs(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		if(info.getOv().equals("0"))
		   return localDao.searchNewBs(info.getValues());
		else 
		   return localDao.searchBs(info.getValues(),info.getOv());
	}
	public	int ReplyBs(UserInfo u)
	{
		ReplyBsInfo info = (ReplyBsInfo)u;
		int t = localDao.replyBs(info.getBstypeS()+"Reply", info.getBsid(), info.getReceiveFrom(), 
						info.getNickName(), info.getBody());
		if(t==1)
		   { 
			  return localDao.replyBsAdd(info.getBstypeS(), info.getBsid());
		   }
		else {
			return 0;
		}
	}
	
	public	int LikeBs(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		return localDao.likeBs(info.getValues(), info.getOv(), 1);	
	}
	
	public	int CalLikeBs(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		return localDao.calLikeBs(info.getValues(), info.getOv(), 1);	
	}
	
	public  String GetBsBody(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		return localDao.getBsBody(info.getValues()+"Body", info.getOv());
	}
	
	public List<BsReplyData>  LookBs(UserInfo u)
	{
		CommonInfo info = (CommonInfo)u;
		return localDao.lookBs(info.getValues()+"Reply", info.getOv());
	}
	
}
