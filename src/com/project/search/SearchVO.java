package com.project.search;

public class SearchVO {
	
	public static final int TYPE_WRITER = 1;
	public static final int TYPE_CONTENT = 2;
	public static final int TYPE_SUBJECT = 3;
	
	private int type;
	private String keyword;
	
	private static SearchVO obj;
	
	public static SearchVO getInstance() {
		
		if ( obj == null )
			obj = new SearchVO();
		
		return obj;
	}
	
	private SearchVO() {
		obj = null;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
