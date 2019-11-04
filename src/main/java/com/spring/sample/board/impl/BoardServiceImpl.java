package com.spring.sample.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sample.board.BoardService;
import com.spring.sample.board.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO_Mybatis boardDAO;
	
	@Transactional
	@Override
	public void insertBoard(BoardVO vo) {
		
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0�� ���� ��� �� �� �����ϴ�.");
//		}
		boardDAO.insertBoard(vo);
	}
	
	@Transactional
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Transactional
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	
	@Transactional(readOnly=true)
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		return boardDAO.getBoardList(vo);
	}
}
