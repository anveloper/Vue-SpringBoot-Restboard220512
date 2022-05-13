package com.devan.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devan.board.model.dto.Board;
import com.devan.board.model.service.BoardService;

@RestController
@RequestMapping("/board")
public class ApiBoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("")
	public ResponseEntity<List<Board>> list(
			@RequestParam(defaultValue = "") String mode, 
			@RequestParam(defaultValue = "") String key) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("key", key);
		return new ResponseEntity<List<Board>>(boardService.getBoardList(params), HttpStatus.OK);
	}

	@GetMapping("/{no}")
	public ResponseEntity<Board> detail(@PathVariable int no) {
		boardService.upViewCnt(no);
		return new ResponseEntity<Board>(boardService.getBoard(no), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Board> insert(@RequestBody Board board) {
		System.out.println(board);
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(boardService.getBoard(board.getNo()), HttpStatus.CREATED);
	}

	@PutMapping("/{no}")
	public ResponseEntity<Board> update(@PathVariable int no, @RequestBody Board board) {
		boardService.updateBoard(board);
		return new ResponseEntity<Board>(boardService.getBoard(board.getNo()), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{no}")
	public ResponseEntity<String> delete(@PathVariable int no) {
		boardService.deleteBoard(no);
		return new ResponseEntity<String>("deleted : " + no, HttpStatus.NO_CONTENT);
	}

}
