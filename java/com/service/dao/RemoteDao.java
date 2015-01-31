package com.service.dao;

import java.util.List;

import com.service.model.Data;

public interface RemoteDao {
	public Data 	getRemoteDataById(Integer uId);
	public void 	insertRemoteData(Data d);
	public List<Data> getRemoteDataListByMark(String likeStr);
	

}
