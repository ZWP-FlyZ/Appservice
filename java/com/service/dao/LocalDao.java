package com.service.dao;

import java.util.List;

import com.service.model.Data;


public interface LocalDao {
	public Data 	getLocalDataById(Integer uId);
	public void 	insertLocalData(Data d);
	public List<Data> getLocalDataListByMark(String likeStr);
	
	//将userinfo中属于本地数据库的信息插入到userInfo表中
	//public void 	insertUser(UserInfo userInfo);
	
	
}
