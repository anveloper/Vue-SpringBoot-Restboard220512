package com.devan.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devan.board.model.dao.BoardDao;
import com.devan.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList(HashMap<String, String> params) {		
		return boardDao.selectList(params);
	}

	@Override
	public Board getBoard(int no) {		
		return boardDao.selectOne(no);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}

	@Override
	public void upViewCnt(int no) {
		boardDao.upViewCnt(no);
	}

}
