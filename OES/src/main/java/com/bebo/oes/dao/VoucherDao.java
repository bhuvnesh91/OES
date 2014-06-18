package com.bebo.oes.dao;

import com.bebo.oes.model.Voucher;

public interface VoucherDao {
	public Voucher getVoucherByNumber(String voucherNumber);
}
