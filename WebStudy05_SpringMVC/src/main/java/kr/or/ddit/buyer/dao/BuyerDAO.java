package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PaginationInfo;

@Mapper
public interface BuyerDAO {
	/**
	 * 제조사 상세 조회
	 * @param buyerId
	 * @return
	 */
	public BuyerVO selectBuyer(String buyerId);
	
	/**
	 * 제조사 등록
	 * @param buyer
	 * @return 성공시 ( > 0)
	 */
	public int insertBuyer(BuyerVO buyer);
	
	/**
	 * 제조사 수정
	 * @param buyer
	 * @return
	 */
	public int updateBuyer(BuyerVO buyer);
	
	/**
	 * 토탈 카운트 조회
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo<BuyerVO> paging);
	
	/**
	 * 제조사 목록 조회
	 * @param paging
	 * @return
	 */
	public List<BuyerVO> selectBuyerList(PaginationInfo<BuyerVO> paging);
	
}