package com.project.dao;

import java.util.List;

import com.project.model.Member;

public interface MemberDAO {

	public List<Member> findByUser( Member member );
	
}
