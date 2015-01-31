package com.service.handlers;

import io.netty.channel.ChannelHandlerContext;

import com.service.netty.Upojo;

public class SubOneHandler extends BaseChannelInHandler{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println(((Upojo)msg).getFrame()+" 1 ");
		ctx.fireChannelRead(msg);//将msg传递到下一个handler
		super.channelRead(ctx, msg);
	}
   
}
