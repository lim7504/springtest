package com.spring.sample.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {

		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) container.getBean("BoardService");
		
		BoardVO vo = new BoardVO();	
		vo.setSeq(0);
		vo.setTitle("�ӽ�����333");
		vo.setWriter("ȫ33333");
		vo.setContent("�ӽó���111,.....");
		boardService.insertBoard(vo);
		
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("===>" + board.toString());
		}

		container.close();

	}

}
