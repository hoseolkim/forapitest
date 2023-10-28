package com.springboard.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboard.board.vo.AttatchVO;

@Mapper
public interface AttatchDAO {
	public int insertAttatch(AttatchVO attatch);
	public AttatchVO selectAttatch(@Param("attNo") int attNo);
	public int incrementDowncount(@Param("attNo") int attNo);
	public int deleteAttatch(@Param("attNo") int attNo);
}
