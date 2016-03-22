package com.lt.crm.common.util.resp;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 根据系统编码返回相应数据
 * @author lt
 *
 */
public class RespBodyUtil {
	
	private static Logger logger = LoggerFactory.getLogger(RespBodyUtil.class);
	
	private RespBodyUtil(){}
	
	public static RespBody getRespBody(Integer code,Object data) {
		Properties props = new Properties();
		try {
        	props.load(RespBodyUtil.class.getResourceAsStream("/resources.properties"));
        	String desc = props.getProperty(code + "");
        	if(desc != null) {
        		return new RespBody(code, desc.toString(), data);
        	}else {
        		// 未找到描述信息
        		return new RespBody(404, props.getProperty("404").toString(), data);
        	}
        }catch(Exception e){
        	logger.error("读取resources.properties文件出错："+e.getMessage(),e.fillInStackTrace());
        }
		// 系统异常
		return new RespBody(500, props.getProperty("500").toString(), data);
	}
}
