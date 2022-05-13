package com.devan.board.model.dao;

import java.util.HashMap;
import java.util.List;

import com.devan.board.model.dto.Comment;

public interface CommentDao {
	public void insertComment(Comment comment);

	public void updateComment(Comment comment);

	public void deleteComment(int id);

	public List<Comment> selectList(HashMap<String, String> params);
}
