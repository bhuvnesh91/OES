package com.bebo.oes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebo.oes.dao.VoucherDao;
import com.bebo.oes.model.Voucher;
import com.bebo.oes.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherDao voucherDao;

	@Override
	public Voucher getVoucherByNumber(String voucherNumber) {
		return voucherDao.getVoucherByNumber(voucherNumber);
	}

}
