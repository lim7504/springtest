package com.spring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.sample.board.BoardVO;
import com.spring.sample.board.impl.BoardDAO;


public class GetBoardListController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색처리");
		
    	BoardVO vo = new BoardVO();
       	BoardDAO boardDAO = new BoardDAO();
       	List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
       	
       	ModelAndView mav = new ModelAndView();
       	mav.addObject("boardList",boardList);
       	mav.setViewName("getBoardList");
       	return mav;
	}
}
