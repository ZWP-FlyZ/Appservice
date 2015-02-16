package com.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.model.Data;
import com.service.model.MatchData;
import com.service.model.PerDataRem;
import com.service.model.PerDataRemS;

public interface RemoteDao {
	public Data 	getRemoteDataById(Integer uId);
	public void 	insertRemoteData(Data d);
	public List<Data> getRemoteDataListByMark(String likeStr);
	
    public Integer 	isConRelation(@Param("RelTypeLike")String RelTypeLike);
    public void 	insertRelation(@Param("relationName")String relationName);
    
    public void 	creRelationTabForMarks(@Param("MarkName")String MarkName);
    public void     creRelationTabForInt(@Param("relation")String relation);
    public void 	creRelationTabForStr(@Param("relation")String relation);
    
    public void insertUserInfo(
			    		@Param("uid")Integer uid,
			    		@Param("nickname")String nickname,
			    		@Param("sex")String sex,
			            @Param("school")String school,
			            @Param("major")String major,
			            @Param("year")String year);
    
    public int count(@Param("tbname")String tbname);
    
    public PerDataRem  getPerDataRem(@Param("uid")String uid);	                       
	public PerDataRemS  getPerDataRemS(@Param("uid")String uid);
    
	public int 		chaPerDataRem(
							@Param("uid")String uid,
							@Param("nickname")String nickname,
							@Param("sex")String sex,							
							@Param("school")String school,
							@Param("major")String major,
							@Param("year")String year
						); 
	public int         chaPerDataAddr(
							@Param("uid")String uid,
							@Param("addrbuid")String addrbuid,
							@Param("addrroom")String addrroom);    //insert select
	public int         chaPerDataBri(
							@Param("uid")String uid,
							@Param("briday")String briday);	//insert select

	public List<MatchData> getMatchRand(@Param("matchtb")String matchtb);
	
	
	
	
}
