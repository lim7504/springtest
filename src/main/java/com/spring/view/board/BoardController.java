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

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
//	@RequestMapping(value="/hello.do")
//	public String gethelloName() {
//		return "hello";
//	}
	
	
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("�� ��� ó��");
	
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� : " + vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());
		
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");

		boardService.deleteBoard(vo);
       	return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����","TITLE");
		conditionMap.put("����","CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("�� ��� �˻�ó��");
		
       	model.addAttribute("boardList",boardService.getBoardList(vo));
       	return "getBoardList.jsp";
	}
	
	
//	@RequestMapping("/dataTransform.do")
//	@ResponseBody
//	public List<BoardVO> dataTransform(BoardVO vo) {
//		System.out.println("�� ��� JSON ��ȸ ó��");
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		return boardList;
//	}
}
