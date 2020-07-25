<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resource/common.css">

<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="/resource/common.css"></script>
<script src="/resource/js/slide.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css" />

<script>
var param = ${paramJson};
</script>

</head>
<body>

	<main>
	
	<div class="tab">
		<c:if test="${isLogined}">
			<span>${loginedMember.name}님 환영합니다.</span>
			<a href="/member/doLogout">로그아웃</a>
		</c:if>
		
		<c:if test="${isLogined == false}">
			<a href="/member/login">로그인</a>
			<a href="/member/join">회원가입</a>
		</c:if>
	</div>
<div id="headerWrap" class="after" >
	<div class="header after" >
		<a href="/" class="logo"></a>
		<div class="bgn">
			<ul class="after">
				<li><a href="/article/list">게시판</a><div></div>
					<ul class="sub">
		                <li><a href="/article/list?boardCode=notice">공지게시판</a></li>
		                <li><a href="/article/list?boardCode=free">자유게시판</a></li>
            		</ul>
				</li>
				<li><a href="">메뉴2</a><div></div>
					<ul>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					</ul>
				</li>
				<li><a href="">메뉴3</a><div></div></li>
				<li><a href="">메뉴4</a><div></div></li>
			</ul>
		</div>
	</div>
</div>