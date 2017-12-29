package com.project.web;

import java.util.ArrayList;
import java.util.List;


public class Pager {

	private int page;
	private int countList;
	private int countPage;
	private int totalCount;
	private int totalPage;
	
	private int startPage;
	private int endPage;
	
	public Pager(int page, int totalCount, int countList, int countPage) {
		
		this.page = page;
		this.totalCount = totalCount;
		this.countList = countList;
		this.countPage = countPage;
		
		make();
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	private void make() {
		
		totalPage = totalCount / countList;

		if (totalCount % countList > 0) {
		    totalPage++;
		}

		if (totalPage < page) {
		    page = totalPage;
		}

		startPage = ((page - 1) / countList ) * countPage + 1;
		endPage = startPage + countPage - 1;

		if (endPage > totalPage) {
		    endPage = totalPage;
		}
		
	}	
	
	public List<String> getLeftSide( List<HttpParameter> request ){
		
		List<String> list = new ArrayList<String>();
		list.add( first( request ) );
		list.add( prev( request ) );
		
		return list;
	}
	
	public List<String> getRightSide( List<HttpParameter> request ){
		
		List<String> list = new ArrayList<String>();
		list.add( next( request ) );
		list.add( last( request ) );
		
		return list;
		
	}
	
	public String first( List<HttpParameter> request ) {

		String result = "";
		
		if (startPage > 1) {
			
			result = "<li><a href=\"?page=1";
			
			if ( request != null ) {
				for ( HttpParameter param : request ) {
					result += "&" + param.getParam() + "=" + param.getValue(); 
				}
			}
			
			result += "\">처음</a></li>";
				
			return result;
			
		}
		else
			return "";
	}
	
	public String prev( List<HttpParameter> request ) {
		
		String result = "";
		
		if (page > 1) {
			
			result = "<li><a href=\\\"?page=\" + (page - 1)";
			
			if ( request != null ) {
				for ( HttpParameter param : request ) {
					result += "&" + param.getParam() + "=" + param.getValue(); 
				}
			}
			
		    result += "\">이전</a></li>";
		    
		    return result;
		}
		else
			return "";
	}
	
	public List<String> getPager( List<HttpParameter> request ) {
		
		List<String> list = new ArrayList<String>();
		String result = "";
		for (int iCount = startPage; iCount <= endPage; iCount++) {
			
		    if (iCount == page) {
		    	// System.out.print(" <b>" + iCount + "</b>");
		    	
		    	result = "<li class=\"active\"><a href=\"?page=" + (iCount);
		    	
		    	if ( request != null ) {
			    	for ( HttpParameter param : request ) {
						result += "&" + param.getParam() + "=" + param.getValue(); 
					}
		    	}
		    	
		    	result += "\"><b>" + iCount + "</b></a></li>";
		    	
		    } else {
		    	
		    	result = "<li><a href=\"?page=" + (iCount);
		    	
		    	if ( request != null ) {
			    	for ( HttpParameter param : request ) {
						result += "&" + param.getParam() + "=" + param.getValue(); 
					}
		    	}
		    	
		    	result += "\">" + iCount + "</a></li>";
		        //System.out.print(" " + iCount + " ");
		    }
		    
		    list.add( result );
		    
		}
		
		return list;
	}
	
	public String next( List<HttpParameter> request ) {

		String result = "";
		
		if (page < totalPage) {
			
			result = "<li><a href=\"?page=" + (page + 1);
			
			if ( request != null ) {
				for ( HttpParameter param : request ) {
					result += "&" + param.getParam() + "=" + param.getValue(); 
				}
			}
			
			result += "\">다음</a></li>";
			
			return result;
		    //System.out.println("<a href=\"?page=" + (page + 1)  + "\">다음</a>");
		}else
			return "";
	}
	
	public String last( List<HttpParameter> request ) {
		
		String result = "";
		
		if (endPage < totalPage) {
			
			result = "<li><a href=\"?page=" + totalPage;
			
			if ( request != null ) {
				for ( HttpParameter param : request ) {
					result += "&" + param.getParam() + "=" + param.getValue(); 
				}
			}
			
			result += "\">끝</a></li>";
			
			return result;
			
		    //System.out.print("<a href=\"?page=" + totalPage + "\">끝</a>");
		}else
			return "";
	}
	
}
