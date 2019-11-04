package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.sample.board.BoardService;
import com.spring.sample.board.BoardVO;

import io.swagger.annotations.Api;


@RestController
public class BoardRestController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/dataTransform.do")
	public List<BoardVO> dataTransform(BoardVO vo) {
		System.out.println("�� ��� JSON ��ȸ ó��");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
}
