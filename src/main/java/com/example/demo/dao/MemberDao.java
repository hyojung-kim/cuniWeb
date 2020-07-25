package com.example.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {

	Member getMemberByLoginId(@Param("loginId") String loginId);

	void joinMember(Map<String, Object> param);

	Member getMemberById(@Param("id") int id);



}
