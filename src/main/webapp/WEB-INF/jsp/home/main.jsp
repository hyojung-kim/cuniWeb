<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../part/head.jsp"%>

<link rel="stylesheet" href="/resource/main.css" />
<script src="/resource/js/tabButton.js"></script>

<script>
callDoArticles();
  var id = parseInt('${article.id}');
  var html = '';  
	function Articles__draw(articles) {
		html += '<li><a href="/article/detail?id='+ articles.id +'">';
		html += articles.title + '</a></li>';
		html += '<span>' + articles.regDate +'</span>';
	}
	function empty(){
		$('.ajax').empty().append(html);
		html='';
	}
///////////////////////////////////////////////////////
	
	function callDoArticles() {

		$.post(
			'/articlesAjax?boardCode=notice',
			{
				id : id
			},
			function(data) {
				for (var i = 0; i < data.articles.length; i++) {
					var articles = data.articles[i];
					Articles__draw(articles);
				}
				empty();
			},
			'json'
		);
	}

	function callDoArticles2() {

		$.post(
			'/articlesAjax?boardCode=free',
			{
				id : id
			},
			function(data) {
				for (var i = 0; i < data.articles.length; i++) {
					var articles = data.articles[i];
					Articles__draw(articles);
				}
				empty();
			},
			'json'
		);
	}
///////////////////////////////////////////////////////
</script>

<div id="visual"></div>

<div id="contents" class="after">
	<div class="con1">
		
		<div class="notice dt on"><a href="#" onclick="callDoArticles();">공지</a></div>
		<div class="noticeBody dd on">
			<ul class="ajax after">
				
			</ul>
		</div>
		<div class="free dt"><a href="#" onclick="callDoArticles2();">자유</a></div>
		<div class="freeBody dd">
			<ul class="ajax after">
				
			</ul>
		</div>
	</div>
	<div class="con2">

		
	</div>
</div>



<%@ include file="../part/foot.jsp"%>


