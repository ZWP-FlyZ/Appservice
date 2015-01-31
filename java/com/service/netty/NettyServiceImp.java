package com.service.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.springframework.beans.factory.annotation.Autowired;



public class NettyServiceImp implements NettyService{
	@Autowired
	EventLoopGroup bossGroup;
	@Autowired
	EventLoopGroup workerGroup;
	
	ChannelFuture f;
	final int restartTime=10;
	final NettyServiceImp service=this;
	final int port=30000;
		
	@Override
	public void start() {
		
		System.out.println("NettyServiceStarting");
		
		 try {
	            ServerBootstrap b = new ServerBootstrap(); // (2)
	            b.group(bossGroup, workerGroup)
	             .channel(NioServerSocketChannel.class) // (3)
	             .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
	                 @Override
	                 public void initChannel(SocketChannel ch) throws Exception {
	                	 ch.pipeline().addFirst(new MyBufDecoder()); 
	                	 //ch.pipeline().addLast(new SubOneHandler());
	                	 //ch.pipeline().addLast(new SubTwoHandler());  
	                 }
	             })
	             .option(ChannelOption.SO_BACKLOG, 128)          // (5)
	             .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

	            f = b.bind(port).sync(); 
	          	f.channel().closeFuture().sync();
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            workerGroup.shutdownGracefully();
	            bossGroup.shutdownGracefully();
	        }	
		
	}

	@Override
	public void restart() {
		this.stop();
		this.start();
		System.out.println("NettyServiceRestart");
	}

	@Override
	public void stop() {
		  System.out.println("NettyServiceStoping");
		  if(!bossGroup.isShuttingDown()|!workerGroup.isShuttingDown())
		  {
			  System.out.println("NettyServiceReadyshutdown");
			  workerGroup.shutdownGracefully();
			  bossGroup.shutdownGracefully().awaitUninterruptibly();
			  //f.channel().close().awaitUninterruptibly();
			  f=null;				
		  }
		  System.out.println("NettyServiceStop");				
	}

	
}
