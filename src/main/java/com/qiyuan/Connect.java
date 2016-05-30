package com.qiyuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.apache.commons.codec.digest.DigestUtils;

@Path("connect")
public class Connect {
	
	/***
	 * wechat connection, see wechat doc for parameter details
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@GET
	@Path("aquire")
	public String aquireConnection(@QueryParam("signature") String signature,
			@QueryParam("timestamp") String timestamp, 
			@QueryParam("nonce") String nonce,
			@QueryParam("echostr") String echostr){
		
		if(signature == null || timestamp == null || nonce == null || echostr == null){
			System.out.println("Missing some parameters.");
			return null;
		}
		List<String> params = new ArrayList<String>(3){
			private static final long serialVersionUID = 8636259651817021385L;

			public String toString(){
				return this.get(0) + this.get(1) + this.get(2);
			}
		};
		
		params.add(timestamp);
		params.add(nonce);
		params.add("wocao");
		Collections.sort(params);
		
		String s = DigestUtils.shaHex(params.toString());
		if(s.equals(signature)){
			return echostr;
		}else{
			return null;
		}
	}
	
	@GET
	@Path("test")
	public String test(@QueryParam("text") String ret){
		return "test string: "+ ret;
		
	}
}
