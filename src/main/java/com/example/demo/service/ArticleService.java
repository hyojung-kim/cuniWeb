package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Article;
import com.example.demo.dto.Board;

public interface ArticleService {
	List<Article> getArticles(String boardCode);

	Article getArticle(int id);

	Map<String, Object> deleteArticle(int id);

	Board getBoard(String boardCode);

	Map<String, Object> write(Map<String, Object> param);

	Board getBoard(int boardId);

	Map<String, Object> modify(Map<String, Object> param);

	Map<String, Object> getArticleModifyAvailable(int id, int loginedMemberId);

	Map<String, Object> getArticleDeleteAvailable(int id, int loginedMemberId);

	void increaseArticleHit(int id);

	List<Article> getForPrintArticles(String boardCode, int loginedMemberId);

	Article getForPrintArticle(int id, int loginedMemberId);

	Map<String, Object> getArticleLikeAvailable(int id, int loginedMemberId);

	Map<String, Object> likeArticle(int id, int loginedMemberId);

	Map<String, Object> getArticleCancelLikeAvailable(int id, int loginedMemberId);

	Map<String, Object> cancelLikeArticle(int id, int loginedMemberId);

	int getLikePoint(int id);

	Map<String, Object> writeReply(Map<String, Object> param);

	List<ArticleReply> getForPrintArticleReplies(int articleId);

	Map<String, Object> getArticleReplyDeleteAvailable(int id, int loginedMemberId);

	ArticleReply getArticleReply(int id);

	Map<String, Object> deleteArticleReply(int id);

	Map<String, Object> getArticleModifyReplyAvailable(int id, int loginedMemberId);

	ArticleReply getForPrintArticleReply(int id, int loginedMemberId);

	Map<String, Object> modifyReply(Map<String, Object> param);
}
