package com.project.web;

public class ViewBag {
	
	private String identity;		// ½Äº°: ¿¹) Board_{menu};
	
	private int startNum;
	private int endNum;
	
	private Object content;
	private Object search;

	private static ViewBag obj;
	
	public static ViewBag getInstance() {
		
		if ( obj == null )
			obj = new ViewBag();
		
		return obj;
	}
	
	private ViewBag() {
		ViewBag.obj = null;
		this.content = null;
		this.search = null;
	}
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void setPagerNum(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}
	
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public Object getSearch() {
		return search;
	}

	public void setSearch(Object search) {
		this.search = search;
	}
	
	public boolean isPageNumber() {
		
		if ( ( startNum == -1 ) && ( endNum == -1 ) )
			return false;
		else
			return true;
		
	}
	
}