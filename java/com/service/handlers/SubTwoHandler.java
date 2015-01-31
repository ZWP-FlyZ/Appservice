package com.service.handlers;

import com.service.netty.Upojo;

import io.netty.channel.ChannelHandlerContext;

public class SubTwoHandler extends BaseChannelInHandler {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println(((Upojo)msg).getFrame()+" 2 ");
		super.channelRead(ctx, msg);
	}

}
