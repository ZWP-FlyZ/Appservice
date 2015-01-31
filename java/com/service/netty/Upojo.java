package com.service.netty;


public class Upojo {
	 private String frame = "";
	 public Upojo(){}	 
	
	public Upojo(String frames)
	 {
		 this.frame=frames;
		 Decoder(frames);
	 }
	 private void    Decoder(String frames){}
	@SuppressWarnings("unused")
	private String  Encode()
	 {
		return frame;
	 }
	 public String getFrame() {
			return frame;
		}
		public void setFrame(String frame) {
			this.frame = frame;
		}
}
