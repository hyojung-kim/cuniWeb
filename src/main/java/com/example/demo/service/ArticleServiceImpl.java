package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Board;
import com.example.demo.util.CUtil;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	


	@Override
	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}

	@Override
	public Map<String, Object> deleteArticle(int id) {
		articleDao.deleteArticle(id);
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물이 삭제되었습니다.", id));

		return rs;
	}

	@Override
	public List<Article> getArticles(String boardCode) {
		return articleDao.getArticlesByBoardCode(boardCode);
	}

	@Override
	public Board getBoard(String boardCode) {
		return articleDao.getBoardByBoardCode(boardCode);
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		articleDao.writeArticle(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물이 생성되었습니다.", id));

		return rs;
	}

	@Override
	public Board getBoard(int boardId) {
		return articleDao.getBoard(boardId);
	}

	@Override
	public Map<String, Object> modify(Map<String, Object> param) {
		articleDao.modifyArticle(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물이 수정되었습니다.", id));

		return rs;
	}

	@Override
	public Map<String, Object> getArticleModifyAvailable(int id, int loginedMemberId) {
		Article article = getArticle(id);

		Map<String, Object> rs = new HashMap<>();

		if (article.getMemberId() == loginedMemberId) {
			rs.put("resultCode", "S-1");
			rs.put("msg", "수정권한이 있습니다.");
		} else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "수정권한이 없습니다.");
		}

		return rs;
	}

	@Override
	public Map<String, Object> getArticleDeleteAvailable(int id, int loginedMemberId) {
		Map<String, Object> rs = getArticleModifyAvailable(id, loginedMemberId);

		String msg = (String) rs.get("msg");
		msg = msg.replace("수정", "삭제");
		rs.put("msg", msg);
		
		return rs;
	}

	@Override
	public void increaseArticleHit(int id) {
		articleDao.increaseArticleHit(id);
	}

	@Override
	public List<Article> getForPrintArticles(String boardCode, int loginedMemberId) {
		List<Article> articles = articleDao.getForPrintArticlesByBoardCode(boardCode);

		for (Article article : articles) {
			updateMoreInfoForPrint(article, loginedMemberId);
		}

		return articles;
	}

	private void updateMoreInfoForPrint(Article article, int loginedMemberId) {
		if ( loginedMemberId == 0 ) {
			article.getExtra().put("loginedMemberCanLike", false);
			article.getExtra().put("loginedMemberCanCancelLike", false);

			return;
		}

		int likePoint = articleDao.getLikePointByMemberId(article.getId(), loginedMemberId);

		if (likePoint == 0) {
			article.getExtra().put("loginedMemberCanLike", true);
			article.getExtra().put("loginedMemberCanCancelLike", false);
		} else {
			article.getExtra().put("loginedMemberCanLike", false);
			article.getExtra().put("loginedMemberCanCancelLike", true);
		}
		
	}

	@Override
	public Article getForPrintArticle(int id, int loginedMemberId) {
		Article article = articleDao.getForPrintArticle(id);
		updateMoreInfoForPrint(article, loginedMemberId);

		return article;
	}

	@Override
	public Map<String, Object> getArticleLikeAvailable(int id, int loginedMemberId) {
		Article article = getArticle(id);

		Map<String, Object> rs = new HashMap<>();

		if (article.getMemberId() == loginedMemberId) {
			rs.put("resultCode", "F-1");
			rs.put("msg", "본인 게시글은 좋아요 할 수 없습니다.");

			return rs;
		}

		int likePoint = articleDao.getLikePointByMemberId(id, loginedMemberId);

		if (likePoint > 0) {
			rs.put("resultCode", "F-2");
			rs.put("msg", "이미 좋아요를 하셨습니다.");

			return rs;
		}

		rs.put("resultCode", "S-1");
		rs.put("msg", "가능합니다.");

		return rs;
	}

	@Override
	public Map<String, Object> likeArticle(int id, int loginedMemberId) {
		articleDao.likeArticle(id, loginedMemberId);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시글을 추천 했습니다.", id));

		return rs;
	}

	@Override
	public Map<String, Object> getArticleCancelLikeAvailable(int id, int loginedMemberId) {
		Map<String, Object> rs = new HashMap<>();

		int likePoint = articleDao.getLikePointByMemberId(id, loginedMemberId);

		if (likePoint == 0) {
			rs.put("resultCode", "F-1");
			rs.put("msg", "추천하신 분만 취소가 가능합니다.");

			return rs;
		}

		rs.put("resultCode", "S-1");
		rs.put("msg", "가능합니다.");

		return rs;
	}

	@Override
	public Map<String, Object> cancelLikeArticle(int id, int loginedMemberId) {
		articleDao.cancelLikeArticle(id, loginedMemberId);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물 추천을 취소하였습니다.", id));

		return rs;
	}

	@Override
	public int getLikePoint(int id) {
		return articleDao.getLikePoint(id);
	}

	@Override
	public Map<String, Object> writeReply(Map<String, Object> param) {
		articleDao.writeArticleReply(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물 댓글이 생성되었습니다.", id));

		return rs;
	}

	@Override
	public List<ArticleReply> getForPrintArticleReplies(int articleId) {
		return articleDao.getForPrintArticleReplies(articleId);
	}

	@Override
	public Map<String, Object> getArticleReplyDeleteAvailable(int id, int loginedMemberId) {
		ArticleReply articleReply = getArticleReply(id);

		Map<String, Object> rs = new HashMap<>();

		if (articleReply.getMemberId() == loginedMemberId) {
			rs.put("resultCode", "S-1");
			rs.put("msg", "삭제권한이 있습니다.");
		} else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "삭제권한이 없습니다.");
		}

		return rs;
	}

	@Override
	public ArticleReply getArticleReply(int id) {
		return articleDao.getArticleReply(id);
	}

	@Override
	public Map<String, Object> deleteArticleReply(int id) {
		articleDao.deleteArticleReply(id);
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물 댓글이 삭제되었습니다.", id));

		return rs;
	}

	@Override
	public Map<String, Object> getArticleModifyReplyAvailable(int id, int loginedMemberId) {
		Map<String, Object> rs = getArticleReplyDeleteAvailable(id, loginedMemberId);
		String msg = (String)rs.get("msg");
		msg = msg.replace("삭제", "수정");
		rs.put("msg", msg);

		return rs;
	}

	@Override
	public ArticleReply getForPrintArticleReply(int id, int loginedMemberId) {
		ArticleReply articleReply = articleDao.getForPrintArticleReply(id);
		return articleReply;
	}

	@Override
	public Map<String, Object> modifyReply(Map<String, Object> param) {
	
		articleDao.modifyArticleReply(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물 댓글이 수정되었습니다.", id));

		return rs;
	}
	

}
