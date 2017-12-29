package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.search.SearchVO;
import com.project.db.DBConn;
import com.project.db.DBUtil;
import com.project.model.Board;
import com.project.model.extend.BoardWrite;
import com.project.web.ViewBag;

public class OrclBoardDAOImpl implements BoardDAO {

	@SuppressWarnings("resource")
	@Override
	public int insert(BoardWrite board) {
		

		PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql;
        String board_id = board.getH_board_id();
        int code = -1;
        
 	    DBConn dbConn = new DBConn( DBConn.ORACLE );
 	    Connection conn = dbConn.getConnection();
 	    
        try {
        	
        	// 게시글 등록
        	
        	sql = "INSERT INTO BOARD_" + board_id + 
        			" (CATEGORY, REPLY, SUBJECT, CONTENT, WRITER, MEMBER_ID, PASSWORD, TYPE, ATTACH, UUID, COUNT, REGIDATE, IP, ARTICLE_ID) " + 
        			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	
        	pstmt = conn.prepareStatement(sql);
        	
        	pstmt.setInt(1, board.getCategory() );				// 카테고리
        	pstmt.setInt(2, board.getReply() );						// 답글
        	pstmt.setString(3, board.getSubject() );				// 제목
        	pstmt.setString(4, board.getContent() );				// 내용
        	pstmt.setString(5, board.getWriter() );				// 작성자
        	pstmt.setInt(6, board.getMember_id() );				// 회원ID
        	pstmt.setString(7, board.getPassword() );			// 비밀번호
        	pstmt.setInt(8, board.getType() );						// 글 유형(공개, 비공개)
        	pstmt.setInt(9, board.getAttach() );					// 첨부 여부
        	pstmt.setString(10, board.getUuid() );				// 게시글 UUID
        	pstmt.setInt(11, board.getCount() );					// 조회수
        	pstmt.setDate(12, board.getRegidate() );			// 등록일자
        	pstmt.setString(13, board.getIp() );					// 등록IP
        	pstmt.setInt(14, board.getArticle_id() );			// 등록IP
        	
            code = pstmt.executeUpdate();
            
            // 게시글 고유키 가져오기
            
            sql = "SELECT * FROM BOARD_" + board_id + " " + 
            		"WHERE UUID = ?";

        	pstmt = conn.prepareStatement( sql );
        	pstmt.setString(1, board.getUuid() );
            rset = pstmt.executeQuery();
            
            while ( rset.next() ) {
            	code = rset.getInt("id");
            }
            
            
        } catch (Exception e) {
        	
        	System.out.println("오류:" + e.getMessage() );
        	
        } finally {
        	
        	com.project.db.DBUtil.close(pstmt);
        	DBUtil.close(conn);
        }

        return code;
		
	}

	@SuppressWarnings("resource")
	@Override
	public List<Board> select( ViewBag viewBag ) {

		int choose = -1;
		
		String SQL = ""; 
		String board_id = viewBag.getIdentity();
		
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        
 	    DBConn dbConn = new DBConn( DBConn.ORACLE );
 	    Connection conn = dbConn.getConnection();
 	    
        List<Board> list = null;
        
        Board content = (Board)viewBag.getContent();
        SearchVO search = (SearchVO)viewBag.getSearch();
        
        try {
        	
        	if ( content == null )
        	{
	        	SQL = "SELECT *" + 
	        			" FROM " + 
	        			"  (SELECT ROW_NUMBER() Over (Order By Board_" +  board_id +  ".ID) AS rnum, " + 
	        			"    BOARD_" + board_id + ".ID," +  
	        			"    BOARD_" + board_id + ".CATEGORY," +
	        			"    BOARD_" + board_id + ".REPLY," +
	        			"    BOARD_" + board_id + ".SUBJECT," +
	        			"    BOARD_" + board_id + ".CONTENT," +
	        			"    BOARD_" + board_id + ".WRITER," +
	        			"    BOARD_" + board_id + ".MEMBER_ID," +
	        			"    BOARD_" + board_id + ".PASSWORD," +
	        			"    BOARD_" + board_id + ".TYPE," +
	        			"    BOARD_" + board_id + ".ATTACH," +
	        			"    BOARD_" + board_id + ".UUID," +
	        			"    BOARD_" + board_id + ".COUNT," +
	        			"    BOARD_" + board_id + ".REGIDATE," +
	        			"    BOARD_" + board_id + ".IP," +
	        			"    BOARD_" + board_id + ".ARTICLE_ID" +
	        			"  FROM BOARD_" + board_id +   
	        			"  ORDER BY BOARD_" + board_id + ".id" + 
	        			") WHERE RNUM >= ? and RNUM <= ?";
	        
	        	if ( search != null ) {
	        		
	        		choose = search.getType();
	        		
	        		switch ( choose ) {
	        		
	        			case SearchVO.TYPE_WRITER:
		        			SQL += " and WRITER = ?";
		        			break;
		        			
	        			case SearchVO.TYPE_CONTENT:
	        				SQL += " and CONTENT like '%' || ? || '%'";
	        				break;
	        				
	        			case SearchVO.TYPE_SUBJECT:
	        				SQL += " and SUBJECT like '%' || ? || '%'";
	        				break;
	        		
	        		} // end of switch
	        		
	        	} // end of if
        			
	        	pstmt = conn.prepareStatement( SQL );
	        	
	        	pstmt.setInt(1, viewBag.getStartNum() );
	        	pstmt.setInt(2, viewBag.getEndNum() );
	        	
	        	if ( search != null ) {
	        		//System.out.println( "결과:" + search.getKeyword() );
	        		pstmt.setString(3, search.getKeyword() );
	        	}
	        	
        	}
        	
        	if ( content != null ) {
        		
        		SQL = "SELECT * FROM BOARD_" + board_id +
        				 " WHERE ID = ?";

	        	pstmt = conn.prepareStatement( SQL );
        		pstmt.setInt(1, content.getId() );
        	}
        	
        	//System.out.println(SQL);
        	
            rset = pstmt.executeQuery();
            
            // 데이터 가져오기
            while ( rset.next() ) {
            
            	if ( list == null )
            		list = new ArrayList<Board>();
            	
            	content = new Board();
            	
            	content.setId( rset.getInt("id") );
            	content.setCategory( rset.getInt("category") );
            	content.setReply( rset.getInt("reply") );
            	content.setSubject( rset.getString("subject") );
            	content.setContent( rset.getString("content") );
            	content.setWriter( rset.getString("writer") );
            	content.setMember_id( rset.getInt("member_id") );
            	content.setPassword( rset.getString("password") );
            	content.setType( rset.getInt("type") );
            	content.setAttach( rset.getInt("attach") );
            	content.setUuid( rset.getString("uuid") );
            	content.setCount( rset.getInt("count") );
            	content.setRegidate( rset.getDate("regidate") );
            	content.setIp( rset.getString("ip") );
            	content.setArticle_id( rset.getInt("article_id") );
            	
            	list.add( content );
            	
            }
           
            
        } catch (Exception e) {
        	
        	System.out.println("오류:" + e.getMessage() );
        	
        } finally {
        	
        	DBUtil.close(rset);
        	DBUtil.close(pstmt);
        	DBUtil.close(conn);
        }
        
        return list;
		
	}

	@SuppressWarnings("resource")
	@Override
	public int selectAllCount(ViewBag viewBag) {
		
		int count = -1;
		int choose = -1;
		
		String SQL = "";
		
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        
 	    DBConn dbConn = new DBConn( DBConn.ORACLE );
 	    Connection conn = dbConn.getConnection();
 	    
 	    SearchVO search = (SearchVO) viewBag.getSearch();
        
        try {

    		SQL = "SELECT count(*) FROM BOARD_" + viewBag.getIdentity();
    		
        	if ( search == null )
        	{
            	pstmt = conn.prepareStatement( SQL );
        	}
        	
        	if ( search != null )
        	{
        		choose = search.getType();
        		// 조건
        		switch ( choose ) {
        			
        			case SearchVO.TYPE_WRITER:
        				SQL += " WHERE WRITER = ?";
        				break;
        		
        			case SearchVO.TYPE_CONTENT:
        				SQL += " WHERE CONTENT like '%' || ? || '%'";
        				break;
        				
					case SearchVO.TYPE_SUBJECT:
        				SQL += " WHERE SUBJECT like '%' || ? || '%'";
						break;
        		}
        		
        		pstmt = conn.prepareStatement( SQL );
        		pstmt.setString(1, search.getKeyword() );
        		
        	}
        	
            rset = pstmt.executeQuery();
            
            if ( rset.next()) {
            	count = rset.getInt(1);
            }
            
        } catch (Exception e) {
        	
        	System.out.println("오류:" + e.getMessage() );
        	
        } finally {
        	
        	DBUtil.close(rset);
        	DBUtil.close(pstmt);
        	DBUtil.close(conn);
        }
        
        return count;
	}

}
