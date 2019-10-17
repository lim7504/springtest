package com.spring.sample.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.sample.user.UserService;
import com.spring.sample.user.UserVO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}
		
		
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle("�ӽ�����");
//		vo.setWriter("ȫ�浿222");
//		vo.setContent("�ӽó���,.....");
//		boardService.insertBoard(vo);
//		
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		for (BoardVO board : boardList) {
//			System.out.println("===>" + board.toString());
//		}
		
		
		container.close();
		
	}
	
}
