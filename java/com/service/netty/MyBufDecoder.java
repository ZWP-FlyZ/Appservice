package com.service.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.service.pojo.UserInfoUtil;

public class MyBufDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		    byte[] r= new byte[in.readableBytes()];
            in.readBytes(r);
           
            UserInfoUtil.DecoderAndRun(r);
            
            r=null;
//            UserInfo tmpInfo = UserInfoFactory.getUserInfo(r);
//            
//            if(tmpInfo.getCmdKind().equals("1"))
//            {}
//            else if(tmpInfo.getCmdKind().equals("2"))
//            {}
//            else
//            {}
            
            
		  //   out.add(new Upojo(new String(r)));	
	}

}
