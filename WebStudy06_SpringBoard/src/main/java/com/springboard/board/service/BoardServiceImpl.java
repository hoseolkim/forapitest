package com.springboard.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboard.board.BoardNotFoundException;
import com.springboard.board.InvalidPasswordException;
import com.springboard.board.dao.AttatchDAO;
import com.springboard.board.dao.BoardDAO;
import com.springboard.board.vo.AttatchVO;
import com.springboard.board.vo.FreeBoardVO;
import com.springboard.paging.vo.PaginationInfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Inject
	private BoardDAO boardDAO;
	
	@Inject
	private AttatchDAO attatchDAO;
	
	@Value("#{appInfo.boFiles}")
	private Resource boFiles;
	
	private void processBoFiles(FreeBoardVO board) {
		List<AttatchVO> attatchList = board.getAttatchList();
		if(attatchList != null) {
			attatchList.forEach((atch)->{
				try {
					atch.setBoNo(board.getBoNo());
					attatchDAO.insertAttatch(atch);
					atch.saveTo(boFiles.getFile());
					if(1==1) {
						throw new IOException("강제로 발생시킨 예외!!!!!");
					}
				}catch(IOException e) {
					throw new RuntimeException(e);
				}
			});
		}
	}
	
//	@Transactional
	@Override
	public void createBoard(FreeBoardVO board) {
		String plain = board.getBoPass();
		String encoded = passwordEncoder.encode(plain);
		board.setBoPass(encoded);
		boardDAO.insertBoard(board);
		processBoFiles(board);
	}

	@Override
	public FreeBoardVO retrieveBoard(int boNo) {
		FreeBoardVO board = boardDAO.selectBoard(boNo);
		if(board==null) {
			throw new BoardNotFoundException(HttpStatus.NOT_FOUND, String.format("%d 에 해당하는 게시글이 없음", boNo));
		}
		return board;
	}

	@Override
	public AttatchVO retrieveAttatch(int attNo) {
		AttatchVO atch = attatchDAO.selectAttatch(attNo);
		if(atch == null)
				throw new BoardNotFoundException(HttpStatus.NOT_FOUND, String.format("%d 에 해당하는 파일이 없음", attNo));
		
		attatchDAO.incrementDowncount(attNo);
		return atch;
	}

	@Override
	public void retrieveBoardList(PaginationInfo<FreeBoardVO> paging) {
		int totalRecord = boardDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		List<FreeBoardVO> dataList = boardDAO.selectBoardList(paging);
		paging.setDataList(dataList);
	}

	@Override
	public void incrementBoardHit(FreeBoardVO board) {
		boardDAO.incrementBoard(board.getBoNo());
		board.setBoHit(board.getBoHit()+1);
	}
//	@Transactional
	@Override
	public void modifyBoard(FreeBoardVO board) {
		FreeBoardVO target = auth(board);
		if(target != null) {
			boardDAO.updateBoard(board);
			processDeleteAttatches(board);
			processBoFiles(board);
		}
	}
//	@Transactional
	@Override
	public void deleteBoard(FreeBoardVO board) {
		FreeBoardVO target = auth(board);
		if(target != null) {
			processDeleteAttatches(board);
			boardDAO.deleteBoard(board.getBoNo());
		}
	}
	
	private void processDeleteAttatches(FreeBoardVO board) {
		FreeBoardVO saved = boardDAO.selectBoard(board.getBoNo());
		saved.getAttatchList().forEach(atch->{
			try {
				attatchDAO.deleteAttatch(atch.getAttNo());
				FileUtils.deleteQuietly(new File(boFiles.getFile(), atch.getAttSavename()));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
	
	private FreeBoardVO auth(FreeBoardVO board) {
		FreeBoardVO saved = boardDAO.selectBoard(board.getBoNo());
		String encoded = saved.getBoPass();
		String raw = board.getBoPass();
		if(passwordEncoder.matches(raw, encoded)) {
			return saved;
		}else {
			throw new InvalidPasswordException();
		}
	}
	
}