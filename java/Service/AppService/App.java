package Service.AppService;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.netty.MyChannelGroup;
import com.service.netty.NettyService;
import com.service.system.SerSystem;

public class App 
{
	private static Log logfile = LogFactory.getLog("RegLog"); 
	private static Log logger1 = LogFactory.getLog("WarnLog"); 
	private static Logger logger = Logger.getLogger(App.class);
	
    @SuppressWarnings("resource")
	public static void main( String[] args ) 
    {
    	
       
    	PropertyConfigurator.configure ("log4j.propertise");
    	
    	logger.debug("asdf");
    	logger.info("中文");
    	logger1.info("asdfasdf");
    	logfile.info(";;;;;;;;;;;;;;;");
    	logfile.info("中文dfasdf");
    	logfile.info("asdfasdfasdfasdfasdf");
    	
        new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-system.xml","classpath:conf/spring-init.xml"});
//        ApplicationContext locctx=new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-local.xml");
               
//        LocalDao localdao = (LocalDao)locctx.getBean(LocalDao.class);
//        RemoteDao remotedao = (RemoteDao)ctx.getBean(RemoteDao.class);
        
//        LocalDbService lss  =(LocalDbService)ctx.getBean(LocalDbService.class);
//        RemoteDbService rss =(RemoteDbService)ctx.getBean(RemoteDbService.class);
        
        final NettyService service =SerSystem.getNettyService();
            
       
//        
        
//        Data iData = new Data();
//        iData.setuId(33332);
//        iData.setMark("zwp");
//        localdao.insertLocalData(iData);
//        remotedao.insertRemoteData(iData);
        
        
        
    /*   Data ld = db.getLocalDataById(123);
       System.out.println(ld.getuId());*/
     
//        Data ld = localdao.getLocalDataById(123);
//        System.out.println(ld.getuId());
//        System.out.println(ld.getMark());
       
//        ScheduledExecutorService servicezz = Executors.newScheduledThreadPool(1);  
//        
//        final ScheduledFuture<?> beeperHandle =   servicezz.scheduleAtFixedRate(new Runnable() {		
//			@Override
//			public void run() {	
//				System.out.println("sssssss");
//			}
//		}, 1000, 1000,TimeUnit.MILLISECONDS);
//        
//        servicezz.scheduleAtFixedRate(new Runnable() {		
//			@Override
//			public void run() {	
//				
////				if(!beeperHandle.isCancelled())
////					beeperHandle.cancel(false);
//				System.out.println(beeperHandle.isCancelled());
//				System.out.println("zzzzzzzz");
//			}
//		}, 1000, 2000,TimeUnit.MILLISECONDS);
//        
        
       
        System.out.println("----------------------------");
        String s ="1:2:3:null:null:null";
        
        String[] ss = s.split(":");
        System.out.println(ss.length);
        for(String t:ss)
        {
        	System.out.println(t);
        }
        
        
        
        System.out.println("----------------------------");     
          
//        Data rd = remotedao.getRemoteDataById(321); 
//        System.out.println(rd.getuId());
//        System.out.println(rd.getMark());
//        
//        
//        List<Data> list = localdao.getLocalDataListByMark("%a%c");
//        for(Data d:list)
//        {
//        	 logger1.debug(d.getuId());
//        	 System.out.println(d.getuId());
//             System.out.println(d.getMark());
//        }
//        System.out.println("----------------------------");
//        List<Data> listd = remotedao.getRemoteDataListByMark("%k%");
//        for(Data d:listd)
//        {
//        	 logger1.debug(d.getuId());
//        	 System.out.println(d.getuId());
//             System.out.println(d.getMark());
//        }
      
//        System.out.println("+++++++++++++++++++++++++++++++++++");      
//        Data ld = lss.getLocalDataById(123);
//        System.out.println(ld.getMark());
//        
//             
//        Data ld2 = rss.getRemoteDataById(321);
//        System.out.println(ld2.getMark());
        
        System.out.println("+++++++++++++++++++++++++++++++++++"); 
        System.out.println(SerSystem.getRemoteDbService().getRemoteDataById(321).getMark());
        
        
        MyChannelGroup gg = SerSystem.getChannelGroup();
        
        gg.add("sdfsdf", null);
        gg.add("sdfsdsdff", null);
        gg.remove("sdfsdsdff");
        System.out.println(gg.isEmpty());
        System.out.println(gg.isContainId("sdfsdf"));
        System.out.println(gg.isContainId("sdfsdsdff"));
        
        MyChannelGroup gg2 = new MyChannelGroup();
        
        System.out.println(gg2.isEmpty());
        System.out.println(gg2.isContainId("sdfsdf"));
        System.out.println(gg2.isContainId("sdfsdsdff"));
             
       
        System.out.println();
        
        
        service.start();
  
       // service.stop();
        System.out.println( "Hello World!" );
    }
}
