package kr.or.ddit.adrs.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.or.ddit.adrs.service.AddressService;
import kr.or.ddit.adrs.service.AddressServiceImpl;
import kr.or.ddit.vo.AddressVO;

/**
 * 	/adrs/address (GET)	주소록 조회
 *	/adrs/address (POST)주소록 등록
 *	/adrs/address/23 (GET) 주소록 상세조회
 *	/adrs/address/23 (PUT) 주소록 수정
 *	/adrs/address/23 (DELETE) 주소록 삭제
 */
@Controller
@RequestMapping("/adrs/address")
public class AddressDataController{
	
	@Inject
	private AddressService service;
	
	@GetMapping
	public String adrsList(Principal principal, Model model) {
		
		String memId = principal.getName();
		List<AddressVO> adrsList = service.retriveAddressList(memId);
		
		model.addAttribute("adrsList", adrsList);
		
		return "jsonView";
	}

	@PostMapping
	public String doPost(
		@Valid @RequestBody AddressVO vo
		, Errors errors
		, Principal principal
		, Model model
	) {
		
		model.addAttribute("originalData", vo);
		
		vo.setMemId(principal.getName());
		
		boolean success = false;
		String message = null;
		
		boolean valid = ! errors.hasErrors();
		
		if(valid) {
			if(service.createAddress(vo)) {
				success = true;
			}else {
				message = "등록 실패";
			}
		}else {
			message = "필수파라미터 누락";
		}
		
		model.addAttribute("success", success);
		model.addAttribute("message", message);
		
		return "jsonView";
	}
	
	@DeleteMapping("{adrsNo}")
	public String doDelete(
		@PathVariable int adrsNo
		, Model model
	) throws ServletException, IOException {
		boolean success = service.removeAddress(adrsNo);
		model.addAttribute("success", success);
		if(!success) {
			model.addAttribute("message", "삭제 실패");
		}
		
		return "jsonView";
	}
}












