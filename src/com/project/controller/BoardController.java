package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.OrclBoardDAOImpl;
import com.project.model.Board;
import com.project.search.SearchVO;
import com.project.web.HttpParameter;
import com.project.web.Pager;
import com.project.web.ViewBag;

@Controller
public class BoardController {
	
	// �Խ��� ���
	@RequestMapping(value = "/Board/list.do", method = {RequestMethod.GET})
	public ModelAndView list( HttpServletRequest req, HttpSession session) {
		
		OrclBoardDAOImpl dao = new OrclBoardDAOImpl();
		SearchVO search = null;
		ModelAndView mav = new ModelAndView();
		List<HttpParameter> paramList = null;
		ViewBag viewBag = ViewBag.getInstance();
		
		int pageNum = 1;
		int totalCount;
		int searchType = -1;
		
		String keyword = "";
		String board_id = null; 

		// �Խù� ID
		if ( req.getParameter("id") != null )
			board_id = req.getParameter("id");
				
		// ������
		if ( req.getParameter("page") != null )
			pageNum = Integer.valueOf( req.getParameter("page") );
		
		// �˻� ����
		if ( req.getParameter("searchtype") != null )
			searchType = Integer.valueOf( req.getParameter("searchtype") );
		
		if ( req.getParameter("keyword") != null )
			keyword = req.getParameter("keyword");
		
		// �˻�
		if ( searchType != -1 && keyword != "" ) {
			
			search = SearchVO.getInstance();
			search.setType( searchType );
			search.setKeyword( keyword );
			
			System.out.println( "�˻�:" + searchType + "/" + keyword );
		}
		
		// �Ķ���� ����
		if ( search != null ) {
			paramList = new ArrayList<HttpParameter>();
			
			for ( int choose = 0; choose < 2; choose++ ) {
				HttpParameter param = new HttpParameter();
				
				switch ( choose ) {
				
					case 0:
						param.setParam("searchtype");
						param.setValue( String.valueOf( search.getType() ) );						
						break;
						
					case 1:
						param.setParam("keyword");
						param.setValue( search.getKeyword() );
						break;
				
				}
				
				paramList.add(param);
			}
			
		}
		
		// �⺻ ����
		viewBag.setIdentity( board_id );
		System.out.println( board_id );
		viewBag.setContent( null );
		viewBag.setSearch( search );
		
		totalCount = dao.selectAllCount( viewBag );
		
		Pager pager = new Pager( pageNum, totalCount, 10, 10 );
		
		viewBag.setStartNum( ( pageNum - 1 ) * pager.getCountPage() + 1 );	// Oracle ��
		viewBag.setEndNum( pager.getCountPage() * pageNum );
		
		// ������ �б�
		List<Board> listView = dao.select( viewBag );
		List<String> pagerNav = pager.getPager( paramList );
		
		//session.setAttribute("member_message", mem_msg );
		mav.setViewName("board/list");
		mav.addObject("message", null );
		mav.addObject("board_id", board_id );
		
		mav.addObject("listView", listView);
		mav.addObject("pagerLeft", pager.getLeftSide( paramList ) );
		mav.addObject("pagerNav", pagerNav);
		mav.addObject("pagerRight", pager.getRightSide( paramList ) );
		
		return mav;
		
	}
	
	// �Խ��� �� �ۼ�
	@RequestMapping(value = "/Board/write.do", method = RequestMethod.GET)
	public ModelAndView write() {
	   
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");
		
		return mav;
	   
	}
	
	// �Խ��� �� ����
	@RequestMapping(value = "/Board/modify.do", method = RequestMethod.GET)
	public ModelAndView modify() {
	   
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/modify");
		
		return mav;
	   
	}
	
	// �Խ��� �� ����
	@RequestMapping(value = "/Board/view.do", method = RequestMethod.GET)
	public ModelAndView view() {
	   
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		
		return mav;
	   
	}
	
}
