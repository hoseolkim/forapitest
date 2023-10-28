package kr.or.ddit.buyer.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.paging.BootstrapPaginationRenderer;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PaginationInfo;

/**
 * 	/buyer/buyerView.do
 * 	/buyer/buyerList.do
 * 	/buyer/buyerInsert.do
 * 	/buyer/buyerUpdate.do
 * 	/buyer/buyerDelete.do
 *
 *	Restful URI(GET/POST/PUT/DELETE) : 명사(URI), 동사(method)
 *	/buyer/form (GET) : 제조사 등록 양식
 *	/buyer (POST) : 제조사 등록
 *
 *	/buyer (GET) : 제조사 목록 조회
 *	/buyer/P10101 (GET) : 제조사 상세 조회
 *
 *	/buyer/P10101/form (GET) : 제조사 수정 양식
 *	/buyer/P10101 (PUT) : 제조사 수정
 *
 *	/buyer/P10101 (DELETE) : 제조사 삭제
 *	
 */
@Controller
@RequestMapping("/buyer")
public class BuyerRetrieveController {
	
	@Inject
	private BuyerService service;
	
	@Inject
	private OthersDAO dao;
	
	@GetMapping
	public String buyerListRestful(Model model) {
		model.addAttribute("lprodList", dao.selectLprodList());
		return "buyer/buyerList";
	}
	
	@GetMapping("listData")
	public String buyerListRestfulData(
		@ModelAttribute("detailCondition") BuyerVO detailCondition
		, @RequestParam(value = "page", required = false, defaultValue = "1") int currentPage
		, Model model
	) {
		PaginationInfo<BuyerVO> paging = new PaginationInfo<>(3,2);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		service.retrieveBuyerList(paging);
		
		paging.setRenderer(new BootstrapPaginationRenderer());
		
		model.addAttribute("paging", paging);
		return "jsonView";
	}
	
	
	
	@GetMapping("{buyerId}")
	public String buyerViewRestful(@PathVariable String buyerId, Model model) {
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		model.addAttribute("buyer", buyer);
		return "buyer/buyerView";
	}
	
	
//	RequestToViewNameTranslator 전략 객체 동작
//	@GetMapping("/buyer/buyerView.do")
//	public String buyerDetail(
//	public void buyerDetail(
	public ModelAndView buyerDetail(
		@RequestParam(value = "what",required = true) String buyerId
	) {
		
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		
//		model.addAttribute("buyer", buyer);
		
//		return "buyer/buyerView";
		ModelAndView mav = new ModelAndView();
		mav.addObject("buyer", buyer);
		mav.setViewName("buyer/buyerView");
		return mav;
	}
}