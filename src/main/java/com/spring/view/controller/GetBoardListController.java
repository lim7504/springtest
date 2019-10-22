package com.spring.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.sample.board.BoardVO;
import com.spring.sample.board.impl.BoardDAO;

public class GetBoardListController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색처리");
		
    	BoardVO vo = new BoardVO();
       	BoardDAO boardDAO = new BoardDAO();
       	List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
       	
       	HttpSession session = request.getSession();
       	session.setAttribute("boardList", boardList);
       	return "getBoardList";
	}
}
