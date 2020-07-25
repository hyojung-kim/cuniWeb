package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.Member;



public interface MemberService {

	Map<String, Object> join(Map<String, Object> param);

	Member getMemberByLoginId(String loginId);

	Member getMemberById(int loginedMemberId);

}
