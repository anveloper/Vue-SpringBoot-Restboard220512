package com.devan.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.devan.board.model.dto.Board;

public interface BoardService {

	public List<Board> getBoardList(HashMap<String, String> params);

	public Board getBoard(int no);

	public void writeBoard(Board board);

	public void updateBoard(Board board);

	public void deleteBoard(int no);

	public void upViewCnt(int no);

}
