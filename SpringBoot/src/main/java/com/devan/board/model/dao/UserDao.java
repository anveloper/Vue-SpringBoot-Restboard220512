package com.devan.board.model.dao;

import java.util.List;

import com.devan.board.model.dto.Comment;
import com.devan.board.model.dto.User;

public interface UserDao {
	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteBoard(int seq);

	public List<Comment> selectOne(int seq);

	public List<Comment> selectList();
}
