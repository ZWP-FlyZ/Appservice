package com.service.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfoUtil;

public class MyBufEncode extends MessageToByteEncoder<CommonInfo> {
	@Override
	protected void encode(ChannelHandlerContext ctx, CommonInfo msg, ByteBuf out)
			throws Exception {
		out.writeBytes(UserInfoUtil.getDataFrame(msg).getBytes());
		ctx.flush();
	}

}
