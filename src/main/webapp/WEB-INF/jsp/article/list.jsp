<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../part/head.jsp"%>


<link rel="stylesheet" href="/resource/list.css">
<c:set var="pageName" value="${board.name}" />

<div class="con margin-top-100">
	<div>커뮤니티 사이트 - ${pageName}</div>
	<span> <span>총 게시물 수 : </span> <span>카운트</span>
	</span> <span>/</span> <span> <span>현재 페이지 : </span> <span
		style="color: red;">페이지</span>
	</span>
</div>

<div class="table-box margin-top-30 con">
<form class="after">
	<input class="buttonStyle" type = "button" value="게시글 추가" onclick = "window.location='write?boardCode=${board.code}'">
</form>

	<table>
		<colgroup>
			<col width="80">
			<col width="180">
			<col>
			<col width="100">
			<col width="80">
			<col width="80">
			<col width="220">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articles}" var="article">
				<tr>
					<td>${article.id}</td>
					<td>${article.regDate}</td>
					<td><a href="./detail?id=${article.id}">${article.title}</a></td>
					<td>${article.extra.writer}</td>
					<td>${article.hit}</td>
					<td>${article.extra.likePoint}</td>
					<td>
						<c:if test="${article.extra.loginedMemberCanLike}">
							<a href="./doLike?id=${article.id}&redirectUrl=${urlEncodedRequesturiQueryString}"
							onclick="if ( confirm('추천하시겠습니까?') == false ) { return false; }">좋아요 /</a>
						</c:if>
						<c:if test="${article.extra.loginedMemberCanCancelLike}">
							<a href="./doCancelLike?id=${article.id}&redirectUrl=${urlEncodedRequesturiQueryString}"
							onclick="if ( confirm('추천을 취소하시겠습니까?') == false ) { return false; }">좋아요 취소 /</a>
						</c:if>
						
						<a href="./doDelete?id=${article.id}" onclick="if ( confirm('삭제하시겠습니까?') == false ) { return false; }">삭제 /</a>
						<a href="./modify?id=${article.id}">수정</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../part/foot.jsp"%>
