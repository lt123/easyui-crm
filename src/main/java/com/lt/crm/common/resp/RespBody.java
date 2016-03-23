package com.lt.crm.common.resp;

/**
 * 封装json返回对象
 * @author lt
 *
 */
public class RespBody {
	/**
	 * 平台状态码
	 */
	private Integer code;
	
	/**
	 * 状态码描述信息
	 */
	private String desc;
	
	/**
	 * 返回的数据
	 */
	private Object respData;

	
	public RespBody() {
		super();
	}

	public RespBody(Integer code, String desc, Object respData) {
		super();
		this.code = code;
		this.desc = desc;
		this.respData = respData;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getRespData() {
		return respData;
	}

	@Override
	public String toString() {
		return "RespBody [code=" + code + ", desc=" + desc + ", respData="
				+ respData + "]";
	}

	public void setRespData(Object respData) {
		this.respData = respData;
	}
	
	
}
