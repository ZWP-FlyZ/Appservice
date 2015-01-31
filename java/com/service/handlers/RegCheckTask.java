package com.service.handlers;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;

public class RegCheckTask extends CommonTask{

	public RegCheckTask(UserInfo info) {
		super(info);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CommonInfo sCommonInfo = (CommonInfo) info;
	}

}
