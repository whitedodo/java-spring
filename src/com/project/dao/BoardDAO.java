package com.project.dao;

import java.util.List;

import com.project.model.Board;
import com.project.model.extend.BoardWrite;
import com.project.web.ViewBag;

public interface BoardDAO {
	
	public int insert( BoardWrite board );
	public List<Board> select( ViewBag viewBag );
	public int selectAllCount( ViewBag viewBag );
	
}
