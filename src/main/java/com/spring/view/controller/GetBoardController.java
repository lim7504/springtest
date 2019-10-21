package com.spring.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.sample.board.BoardVO;
import com.spring.sample.board.impl.BoardDAO;

public class GetBoardController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		String seq = request.getParameter("seq");
		System.out.println(seq);
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
       	HttpSession session = request.getSession();
       	session.setAttribute("board", board);
       	return "getBoard";
	}
}
