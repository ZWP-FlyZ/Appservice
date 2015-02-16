package com.service.system;

import org.apache.log4j.Logger;

import com.service.dbservice.RemoteDbService.RelType;

public class InitSystem {
	private Logger logger = Logger.getLogger(InitSystem.class);
	
	public void StartUp(){
		InitLogger();
		InitMarkSTab();
		InitMajorTab();
		InitBBsTab();
		StartNetty();
	}
	
	public void InitLogger(){
		try {
			//PropertyConfigurator.configure ("log4j.propertise");
			logger.info("Logger init OK!");
		} catch (Exception e) {
			logger.error("Logger init error !");
		}	
	}
	
	public void InitMarkSTab(){
		try {
			int mc = SerSystem.getRemoteDbService().isContarnRelation("m%");
		    mc = (int)Math.sqrt(mc*2);
		    int ct=0;;
			for(int i=mc+1;i<=SysValues.MARKCOUNT;i++)
			{
				SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS, SysValues.MARKSUFF+i);
				ct++;
				for(int j=1;j<i;j++){
					SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,
							SysValues.MARKSUFF+j+"_"+SysValues.MARKSUFF+i);
					ct++;
				}
					
			}
			logger.info("MarksTab init OK! Add new Marktabs "+ct+" !");
		} catch (Exception e) {
			logger.error("MarksTab init error!");
		}	
	}
	public void InitMajorTab(){
		try {
			int mc = SerSystem.getRemoteDbService().isContarnRelation("c%");
			int i=0;
			for(i = mc+1;i<=SysValues.MARKCOUNT;i++)
			{
				SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS, SysValues.MAJORSUFF+i);
			}
			logger.info("MajorTab init OK! Add new MajorTab "+(i-mc-1)+" !");
		} catch (Exception e) {
			logger.error("MajorTab init error!");
		}
	
	}
	public void InitBBsTab(){
		try {
			int mc = SerSystem.getLocalDbService().IsContainBBs("b%");
			int i=0;
			for(i = mc+1;i<=SysValues.BSCOUNT;i++)
				SerSystem.getLocalDbService().CreateBs(SysValues.BSSUFF+i);
			logger.info("BBsTab init OK! Add new BBsTab "+(i-mc-1)+" !");
		} catch (Exception e) {
			logger.error("BBsTab init error!");
		}
	}
	public void StartNetty(){
		SerSystem.getNettyService().start();
	}
	
	
}
