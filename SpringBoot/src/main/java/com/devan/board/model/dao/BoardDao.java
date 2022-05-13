package com.devan.board.model.dao;

import java.util.HashMap;
import java.util.List;

import com.devan.board.model.dto.Board;

public interface BoardDao {
	public void insertBoard(Board board);

	public void updateBoard(Board board);

	public void upViewCnt(int no);

	public void deleteBoard(int no);

	public Board selectOne(int no);

	public List<Board> selectList(HashMap<String, String> params);
}
