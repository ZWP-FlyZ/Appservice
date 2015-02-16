package com.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.model.BsReplyData;
import com.service.model.BsThemeData;
import com.service.model.Data;
import com.service.model.LogInData;
import com.service.model.PerDataLoc;
import com.service.model.PerDataLocS;
import com.service.pojo.CreateBsInfo;


public interface LocalDao {
	public Data 		getLocalDataById(Integer uId);
	public void 		insertLocalData(Data d);
	public List<Data> 	getLocalDataListByMark(String likeStr);
	
	public Integer    	checkUserName(@Param("hashcode")Integer hashcode);
	public Integer    	count(@Param("tbname")String tbname);
	
	public void   		insertUserInfo(
								  @Param("uid")Integer uid,
			 					  @Param("nickname")String nickname,
			                      @Param("password")String password,
			                      @Param("hashcode")Integer hashcode);
	public LogInData    getLogInData(@Param("hashcode")Integer hashcode);
	
	public PerDataLoc   getPerDataLoc(@Param("uid")String uid);	                       
	public PerDataLocS  getPerDataLocS(@Param("uid")String uid);
	public int		chaPerDataLoc(
									@Param("uid")String uid,
									@Param("nickname")String nickname,
									@Param("marks")String marks,
									@Param("needMatch")String needMatch,
									@Param("majorTimes")String majorTimes,
									@Param("needTimes")String needTimes,
									@Param("marksTimes")String marksTimes
						); 
	public int         chaPerDataSign(
									@Param("uid")String uid,
									@Param("sign")String sign
						);    //insert select
	public int         chaPerDataCont(
									@Param("uid")String uid,
									@Param("contact")String contact
						);	//insert select
	
	public void         addMsgCache(
									@Param("uid")String uid,
									@Param("ouid")String ouid,
									@Param("nickname")String nickname,
									@Param("onickname")String onickname,
									@Param("msg")String msg
						);
	public void			addMsgCache2(
									@Param("uid")String uid,
									@Param("appendMsg")String appendMsg
						);
	
	public String 		getMsgCache(@Param("uid")String uid);
	public void 		delMsgCache(@Param("uid")String uid);
	
	public void 		createBsMain(@Param("bstype")String bstype);
	public void			createBsBody(@Param("bstypeBody")String bstypeBody);
	public void			createBsReply(@Param("bstypeReply")String bstypeReply);
	public void			insertBsName(@Param("bsName")String bsName);
	public int			isContainBBs(@Param("bsNameLike")String bsNameLike);
	
	public int 		addBsMain(CreateBsInfo info);
	
	public int         addBsBody(
									@Param("bstypeBody")String bstypeBody,
									@Param("msg")String msg,
									@Param("bsid")Integer bsid
						);
	public int 		deleteBsMain(
									@Param("bstype")String bstype,
									@Param("bsid")String bsid 
						);
	public void			deleteBsBody(
									@Param("bstypeBody")String bstypeBody,
									@Param("bsid")String bsid
						);
	public void 		deleteBsReply(
									@Param("bstypeReply")String bstypeReply,
									@Param("bsid")String bsid
						);
	public List<BsThemeData> 		searchBs( 
									@Param("bstype")String bstype,
									@Param("bsid")String bsid 
						);
	public List<BsThemeData>		searchNewBs(
									@Param("bstype")String bstype
						);
	public int 		replyBs(
									@Param("bstypeReply")String bstypeReply,
									@Param("bsid")String bsid,
									@Param("uid")String uid,
									@Param("nickname")String nickname,
									@Param("msg")String msg
						);
	public int 		replyBsAdd(
									@Param("bstype")String bstype,
									@Param("bsid")String bsid
						);
	public int 			likeBs(
									@Param("bstype")String bstype,
									@Param("bsid")String bsid,
									@Param("add")Integer add
						);
	public int 			calLikeBs(
									@Param("bstype")String bstype,
									@Param("bsid")String bsid,
									@Param("add")Integer add
						);
	
	public String 		getBsBody(
								@Param("bstypeBody")String bstypeBody,
								@Param("bsid")String bsid
						);
	public List<BsReplyData>  lookBs(
								@Param("bstypeReply")String bstypeReply,
								@Param("bsid")String bsid
						);
}
