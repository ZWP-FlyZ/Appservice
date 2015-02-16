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
	
    @SuppressWarnings({ "resource", "null" })
	public static void main( String[] args ) 
    {
    	PropertyConfigurator.configure ("log4j.propertise");
        new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-system.xml","classpath:conf/spring-init.xml"});
//        ApplicationContext locctx=new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-local.xml");
               
//        LocalDao localdao = (LocalDao)locctx.getBean(LocalDao.class);
//        RemoteDao remotedao = (RemoteDao)ctx.getBean(RemoteDao.class);
        
//        LocalDbService lss  =(LocalDbService)ctx.getBean(LocalDbService.class);
//        RemoteDbService rss =(RemoteDbService)ctx.getBean(RemoteDbService.class);
        
//        final NettyService service =SerSystem.getNettyService();
//            
//       
//      
//       System.out.println("张伟鹏".hashCode());
//       System.out.println("zwp223sad23".hashCode());
//       
////        
//        
//       
//        System.out.println("----------------------------");
//        String s ="1:2:3:::#";
//        
//        String[] ss = s.split(":");
//        System.out.println(ss.length);
//        for(String t:ss)
//        {
//        	System.out.println(t);
//        }
//          String stringt=null;
//      //  System.out.println(stringt.toString());
//        
//        System.out.println("----------------------------");               
//        System.out.println("+++++++++++++++++++++++++++++++++++"); 
//        System.out.println(SerSystem.getLocalDbService().CheckUserName("zwp"));
//        System.out.println();
//        
//        System.out.println("+++++++++++++++++++++++++++++++++++"); 
//        
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m01");
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m02");
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m03");
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m04");
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m05");
////        
////        SerSystem.getRemoteDbService().creRelationTab(RelType.RMARKS,"m01_m02");
////        
////        System.out.println(SerSystem.getRemoteDbService().isContarnRelation("m%"));
////        System.out.println(SerSystem.getRemoteDbService().isContarnRelation("m%m%"));
//        
//        
//        SerSystem.getLocalDbService().CreateBs("b1");
//        SerSystem.getLocalDbService().CreateBs("b2");
//        SerSystem.getBsCount().initCount();
//        System.out.println( SerSystem.getBsCount());
//        
//        System.out.println("+++++++++++++++++++++++++++++++++++"); 
//        
//        String skString="b12";
//        
//        
//        //MyChannelGroup gg = SerSystem.getChannelGroup();
//        
////        gg.add("sdfsdf", null);
////        gg.add("sdfsdsdff", null);
////        gg.remove("sdfsdsdff");
////        System.out.println(gg.isEmpty());
////        System.out.println(gg.isContainId("sdfsdf"));
////        System.out.println(gg.isContainId("sdfsdsdff"));
////        
//        MyChannelGroup gg2 = new MyChannelGroup();
////        
////        System.out.println(gg2.isEmpty());
//        	gg2.remove("asdf");
////        System.out.println(gg2.isContainId("sdfsdsdff"));
//             
//       
//        
//        System.out.println();
//        
//        
////        while(true)
////        {
////        	try {
////        		System.out.println( "Hello World!" );
////        		int t = Integer.parseInt("123");
////        		System.out.println( "Hello World! "+ t );
////        		break;
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////        	
////        }
//        
//        
//        
//        
//         service.start();
//  
//       // service.stop();
//        
    }
}
