package com.sitronics.voa.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitronics.voa.core.dto.MemberCardDto;
import com.sitronics.voa.core.dto.MemberDto;
import com.sitronics.voa.core.dto.pages.MemberPage;
import com.sitronics.voa.core.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/saveMember", method = RequestMethod.POST)
	@ResponseBody
	public String saveMember(@RequestBody MemberDto memberDto) {
		if (memberDto.getId() == null) {
			MemberCardDto cardDto = new MemberCardDto();
			cardDto.setCardStatus("Не активна");
			memberDto.setMemberCard(cardDto);
			return memberService.insert(memberDto).getMemberCard().getCardNumber();
		} else {
			return memberService.update(memberDto).getMemberCard().getCardNumber();
		}
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@ResponseBody
	public MemberPage getMembers(@RequestParam("firstRow") Long firstRow,
		@RequestParam("listSize") Integer listSize,
		@RequestParam("sortColumn") String sortColumn,
			@RequestParam("sortOrder") String sortOrder) {
		System.out.println("Getting Members Page");
		MemberPage x = memberService.getAllMembersPage(firstRow, listSize, sortColumn, sortOrder);
		return x;
	}

	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	@ResponseBody
	public MemberPage getCandidates(@RequestParam("firstRow") Long firstRow,
		@RequestParam("listSize") Integer listSize,
		@RequestParam("sortColumn") String sortColumn,
		@RequestParam("sortOrder") String sortOrder) {
		System.out.println("Getting Candidates Page");
		return memberService.getCandidatesPage(firstRow, listSize, sortColumn, sortOrder);
	}

	@RequestMapping(value = "/memberByCard", method = RequestMethod.GET)
	@ResponseBody
	public MemberDto getMemberByCardNumber(@RequestParam("cardNumber") String cardNumber) {
		System.out.println("Getting Member By Card Number " + cardNumber);
		return memberService.getMemberByCardNumber(cardNumber);
	}
}
