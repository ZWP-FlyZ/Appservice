package com.service.pojo;

import java.util.List;

import io.netty.channel.Channel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.service.handlers.*;
import com.service.model.BsThemeData;
import com.service.model.PerDataLoc;
import com.service.model.PerDataLocS;
import com.service.model.PerDataRem;
import com.service.model.PerDataRemS;
import com.service.system.SerSystem;
import com.service.threadpool.MyThreadPool;


public class UserInfoUtil {
	
	private static Logger logger = Logger.getLogger(UserInfoUtil.class);
	private static Log logfile = LogFactory.getLog("WarnLog"); 
	
	public 	static void DecoderAndRun(byte[] r,Channel channel)
	{
		String s = new String(r);
		logger.debug("IN FRAME ["+s+"]");
		String[] tmpStrings = s.split(Cmd.sqlitChar1);
		int size = tmpStrings.length;
		MyThreadPool pool 	  = SerSystem.getThreadPool();
		MyThreadPool chatPool = SerSystem.getThreadPoolChat();
		
		if(!tmpStrings[size-1].equals("#"))
		{
			logger.warn("frame error not # frame is ["+s+"]");
			logfile.warn("frame error not # frame is ["+s+"]");
		}
		else if(tmpStrings[0].equals(Cmd.BBSCount)){
			pool.AddTask(new BbsCountTask(new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
		else if(tmpStrings[0].equals(Cmd.SearchBBS)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			info.setOv(tmpStrings[4]);
			pool.AddTask(new SearchBsTask(info));
		}			
		else if(tmpStrings[0].equals(Cmd.Chat)){
			ChatInfo info = new ChatInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setNickname(tmpStrings[3]);
			info.setOnickname(tmpStrings[4]);
			info.setMessage(tmpStrings[5]);
			chatPool.AddTask(new ChatTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.LogIn)){//登入任务
		  CommonInfo info =  new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
		  info.setValues(tmpStrings[3]);
		  pool.AddTask(new LogInTask(info,channel));
		}
		else if(tmpStrings[0].equals(Cmd.MsgCache)){//登入任务
			  CommonInfo info =  new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			  pool.AddTask(new MesCacheTask(info));
			}
		else if(tmpStrings[0].equals(Cmd.RegCheck)){ //注册检查任务
			//logger.debug("Cmd.RegCheck");
		    pool.AddTask(new RegCheckTask(
		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]),channel));
		}
        else if(tmpStrings[0].equals(Cmd.LookBBS)){
        	CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			info.setOv(tmpStrings[4]);
        	 pool.AddTask(new LookBsTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.LikeBBS)){
          CommonInfo info =  new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
   		  info.setValues(tmpStrings[3]);
   		  info.setOv(tmpStrings[4]);
   		  pool.AddTask(new LikeBsTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.ReplyBBS)){
			ReplyBsInfo info = new ReplyBsInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setBstypeS(tmpStrings[3]);
			info.setBsid(tmpStrings[4]);
			info.setBody(tmpStrings[5]);
			info.setNickName(tmpStrings[6]);
			chatPool.AddTask(new ReplyBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.CreateBBS)){
		CreateBsInfo info = new CreateBsInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setBstype(tmpStrings[3]);
			info.setTheme(tmpStrings[4]);
			info.setBody(tmpStrings[5]);
			info.setNickName(tmpStrings[6]);					
			pool.AddTask(new AddBsTask(info));
		}
//		else if(tmpStrings[0].equals(Cmd.Ccontact)){//添加到通信录
//        	pool.AddTask(new CcontactTask(
//       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
//		}	
		else if(tmpStrings[0].equals(Cmd.MatchPerson)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			pool.AddTask(new MatchTask(info));
		}
//		else if(tmpStrings[0].equals(Cmd.Dcontact)){//删除从通讯录
//        	pool.AddTask(new DcontactTask(
//       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
//		}
        else if(tmpStrings[0].equals(Cmd.GetPersonData)){//获取个人信息
        	pool.AddTask(new GetPerDataTask(
       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
        else if(tmpStrings[0].equals(Cmd.ChangePersonData)){//修改个人信息
        	String[] addrsStrings = tmpStrings[12].split("-");
			ChangePerInfo info = new ChangePerInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setNickname(tmpStrings[3]);
			info.setSex(tmpStrings[4]);
			info.setSchool(tmpStrings[5]);
			info.setMajor(tmpStrings[6]);
			info.setMtimes(tmpStrings[7]);
			info.setYear(tmpStrings[8]);
			info.setSign(tmpStrings[9]);
			info.setBriday(tmpStrings[10]);
			info.setContact(tmpStrings[11]);
			info.setAddrbuid(addrsStrings[0]);
			info.setAddrrooom(addrsStrings[1]);
			info.setSelfMark(tmpStrings[13]);
			info.setSelfTimes(tmpStrings[14]);
			info.setOtherMark(tmpStrings[15]);
			info.setOtherTimes(tmpStrings[16]);
			pool.AddTask(new ChangePerTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.RegUser)){//注册任务
		   RegInfo info = new RegInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
		   info.setPassword(tmpStrings[3]);
		   info.setSex(tmpStrings[4]);
		   info.setSchool(tmpStrings[5]);
		   info.setMajor(tmpStrings[6]);
		   info.setYear(tmpStrings[7]);
		   pool.AddTask(new RegTask(info,channel));
		}
        else if(tmpStrings[0].equals(Cmd.CalLikeBBS)){
        	CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			info.setOv(tmpStrings[4]);
			pool.AddTask(new CalLikeBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.DeleteBBS)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			info.setOv(tmpStrings[4]);
			pool.AddTask(new DeleteBsTask(info));
		}
//		else if(tmpStrings[0].equals(Cmd.Rcontact)){
//			pool.AddTask(new RContactTask(
//	       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
//		}
		else {
			logger.warn("frame error not right type frame is ["+s+"]");
			logfile.warn("frame error not right type frame is ["+s+"]");
		}
	}
	
//	private static void Exchange(CommonInfo info)
//	{ 
//		String tmpString = info.getSendTo();
//		info.setSendTo(info.getReceiveFrom());
//		info.setReceiveFrom(tmpString);
//	}
		
	public  static String  getDataFrame(CommonInfo info)
	{
		//Exchange(info);
		String tmp;	
		if(info.getValues()==null)
			tmp = info.getCmdKind()+":"+info.getSendTo()+":"+info.getReceiveFrom()+":#";
		else
			tmp = info.getCmdKind()+":"+info.getSendTo()+":"+
		          info.getReceiveFrom()+":"+info.getValues()+":#";			
		logger.debug("OUT FRAME ["+tmp+"]");
		return tmp;
	}
	
	private static String nullToString(String string)
	{
		if(string==null)
			return "null";
		else {
			return string;
		}
	}
	
	public static String getPerValues(PerDataLoc loc,PerDataLocS locs,PerDataRem rem,PerDataRemS rems)
	{
		String tmp = "";
		if(locs==null)
			locs=new PerDataLocS();
		if(rems==null)
			rems=new PerDataRemS();
		tmp+= loc.getU_NickName()+":"+
			  rem.getU_Sex()+":"+
			  rem.getU_School()+":"+
			  rem.getU_Major()+":"+
			  loc.getU_MajorTimes()+":"+
			  rem.getU_Year()+":"+
			  nullToString(locs.getU_Sign())+":"+
			  nullToString(rems.getU_BirDay())+":"+
			  nullToString(locs.getU_Contact())+":"+
			  nullToString(rems.getU_AddrBud())+"-"+
			  nullToString(rems.getU_AddrRoom())+":"+
			  nullToString(loc.getU_Marks())+":"+
			  loc.getU_MarkTimes()+":"+
			  nullToString(loc.getU_NeedMatch())+":"+
			  loc.getU_NeedMatchTimes();
		
		
		return tmp;
	}
	
	public static String getBsThemeValues(String bstype,List<BsThemeData> list)
	{
		String tmp=""+bstype;
		for(BsThemeData d:list)
			tmp+=":$"+
					d.getTheme()+","+
					d.getBsid()+","+
					d.getNickname()+","+
					d.getTimestamp()+","+
					d.getTalksC()+","+
					d.getLikeC()+","+
				   "$";
		return tmp;
	}
	
}
