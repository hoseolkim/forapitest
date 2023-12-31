package kr.or.ddit.buyer.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.validate.grouphint.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

@Controller
@RequestMapping("/buyer")
public class BuyerInsertController {
	
	@Inject
	private OthersDAO others;
	
	@Inject
	private BuyerService service;
	
	
	@ModelAttribute("lprodList")
	public List<LprodVO> lprodList(){
		return others.selectLprodList();
	}
	
	@ModelAttribute("buyer")
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	
	@GetMapping("form")
	public String buyerInsertForm() {
		
		return "buyer/buyerForm";
	}
	
	@PostMapping
	public String buyerInsert(
		@ModelAttribute("buyer") @Validated(InsertGroup.class) BuyerVO buyer
		, Errors errors
		, Model model
	) {
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBuyer(buyer);
			switch (result) {
			case OK:
				return "redirect:/buyer/" + buyer.getBuyerId();
			default:
				model.addAttribute("message", "서버오류! ");
				return "buyer/buyerForm";
			}
		}else {
			return "buyer/buyerForm";
		}
	}
}
