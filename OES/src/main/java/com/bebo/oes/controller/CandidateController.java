package com.bebo.oes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebo.oes.model.Candidate;
import com.bebo.oes.model.Voucher;
import com.bebo.oes.service.CandidateService;
import com.bebo.oes.service.VoucherService;

@Controller
public class CandidateController {

	@Autowired
	private VoucherService voucherService;
	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/candidate", method = RequestMethod.GET)
	public String welcomeCandidate() {
		return "voucher";
	}

	@RequestMapping(value = "/candidateWelcome", method = RequestMethod.GET)
	public String candidateHome() {
		return "candidate";
	}

	@RequestMapping(value = "/saveCandidate", method = RequestMethod.POST)
	@ResponseBody
	public String saveCandidate(@RequestBody Candidate candidate) {
		Candidate candidate2 = new Candidate();
		candidate2 = candidate;
		candidateService.saveCandidate(candidate2);
		return candidate.getVoucher();
	}

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public String welcomeCandidate(@ModelAttribute Voucher voucher, Map<String, Object> map) {
		Voucher voucher2 = voucherService.getVoucherByNumber(voucher.getValue());
		if (voucher2 != null) {
			if (voucher2.isStatus()) {
				return "redirect:/candidateWelcome";
			} else {
				map.put("error", "Entered voucher Number is expired");
				return "voucher";
			}

		} else {
			map.put("error", "Entered voucher Number is incorrect");
			return "voucher";
		}
	}
}
