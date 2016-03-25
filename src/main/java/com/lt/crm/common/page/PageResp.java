package com.lt.crm.common.page;

import java.util.List;

public class PageResp<T> {
	private Integer total;
	private List<T> rows;
	
	public PageResp() {
		super();
	}
	public PageResp(Integer total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
