package com.service.pojo;

import com.service.handlers.*;
import com.service.system.SerSystem;
import com.service.threadpool.MyThreadPool;


public class UserInfoUtil {
	
	public 	static void DecoderAndRun(byte[] r)
	{
		String s = new String(r);
		String[] tmpStrings = s.split(Cmd.sqlitChar1);
		int size = tmpStrings.length;
		MyThreadPool pool 	  = SerSystem.getThreadPool();
		MyThreadPool chatPool = SerSystem.getThreadPoolChat();
		
		if(!tmpStrings[size-1].equals("#"))
		{
			
		}
		else if(tmpStrings[0].equals(Cmd.SearchBBS)){
			 pool.AddTask(new SearchBsTask(
				 new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}			
		else if(tmpStrings[0].equals(Cmd.Chat)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			chatPool.AddTask(new ChatTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.LogIn)){//登入任务
		  CommonInfo info =  new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
		  info.setValues(tmpStrings[3]);
		  pool.AddTask(new LogInTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.RegCheck)){//注册检查任务
		    pool.AddTask(new RegCheckTask(
		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
        else if(tmpStrings[0].equals(Cmd.LookBBS)){
        	 pool.AddTask(new LookBsTask(
             		new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
        else if(tmpStrings[0].equals(Cmd.LikeBBS)){
          CommonInfo info =  new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
   		  info.setValues(tmpStrings[3]);
   		  pool.AddTask(new LikeBsTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.ReplyBBS)){
			ReplyBsInfo info = new ReplyBsInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setBody(tmpStrings[3]);
			info.setAuid(tmpStrings[4]);
			info.setNickName(tmpStrings[5]);
			chatPool.AddTask(new ReplyBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.CreateBBS)){
		CreateBsInfo info = new CreateBsInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setTheme(tmpStrings[3]);
			info.setBody(tmpStrings[4]);
			info.setNickName(tmpStrings[5]);		
			pool.AddTask(new CreateBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.MatchPerson)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			pool.AddTask(new MatchTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.GetPersonData)){//获取个人信息
        	pool.AddTask(new GetPerDataTask(
       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
        else if(tmpStrings[0].equals(Cmd.ChangePersonData)){//修改个人信息
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
			info.setAddr(tmpStrings[12]);
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
		   pool.AddTask(new RegTask(info));
		}
        else if(tmpStrings[0].equals(Cmd.CalLikeBBS)){
        	CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			pool.AddTask(new CalLikeBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.DeleteBBS)){
			CommonInfo info = new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2]);
			info.setValues(tmpStrings[3]);
			pool.AddTask(new DeleteBsTask(info));
		}
		else if(tmpStrings[0].equals(Cmd.Contact)){
			pool.AddTask(new ContactTask(
	       		     new CommonInfo(tmpStrings[0],tmpStrings[1],tmpStrings[2])));
		}
		
	}
	
	public  static String  getDataFrame(UserInfo u)
	{
		return null;
	}
}
