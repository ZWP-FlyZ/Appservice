package com.service.handlers;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public  class BaseChannelInHandler extends ChannelInboundHandlerAdapter {
	
	protected String channelId;
	
	public BaseChannelInHandler()
	{ 
		
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
	
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		super.channelActive(ctx);
	}
	@Override
	public  void channelRead(ChannelHandlerContext ctx,Object msg)
			throws Exception{	
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("exceptionCaught");
		super.exceptionCaught(ctx, cause);
	}
		
}
