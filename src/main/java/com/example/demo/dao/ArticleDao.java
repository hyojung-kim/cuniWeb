package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Board;

@Mapper
public interface ArticleDao {

	Article getArticle(@Param("id") int id);

	void deleteArticle(@Param("id") int id);

	List<Article> getArticlesByBoardCode(@Param("boardCode") String boardCode);

	Board getBoardByBoardCode(@Param("boardCode") String boardCode);

	Board getBoard(@Param("boardId") int boardId);

	void writeArticle(Map<String, Object> param);

	void modifyArticle(Map<String, Object> param);

	void increaseArticleHit(@Param("id") int id);

	List<Article> getForPrintArticlesByBoardCode(@Param("boardCode") String boardCode);

	Article getForPrintArticle(@Param("id") int id);

	int getLikePointByMemberId(@Param("id") int id, @Param("memberId") int loginedMemberId);

	void likeArticle(@Param("id") int id, @Param("memberId") int loginedMemberId);

	void cancelLikeArticle(@Param("id") int id, @Param("memberId") int loginedMemberId);

	int getLikePoint(@Param("id") int id);

	void writeArticleReply(Map<String, Object> param);

	List<ArticleReply> getForPrintArticleReplies(@Param("articleId") int articleId);

	ArticleReply getArticleReply(@Param("id") int id);

	void deleteArticleReply(@Param("id") int id);

	ArticleReply getForPrintArticleReply(int id);

	void modifyArticleReply(Map<String, Object> param);
}
