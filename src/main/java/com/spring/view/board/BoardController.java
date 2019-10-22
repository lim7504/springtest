package com.spring.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sample.board.BoardVO;
import com.spring.sample.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
	
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deletedBoard(vo);
       	return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색처리");
		
       	mav.addObject("boardList",boardDAO.getBoardList(vo));
       	mav.setViewName("getBoardList.jsp");
       	return mav;
	}
}
