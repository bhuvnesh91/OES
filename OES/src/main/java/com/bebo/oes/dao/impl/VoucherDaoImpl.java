package com.bebo.oes.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bebo.oes.dao.VoucherDao;
import com.bebo.oes.model.Voucher;

@Repository
public class VoucherDaoImpl implements VoucherDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Voucher getVoucherByNumber(String voucherNumber) {
		List<Voucher> vouchers = hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Voucher.class).add(Restrictions.ilike("value", "%" + voucherNumber + "%")));
		if (vouchers.isEmpty())
			return null;
		else
			return vouchers.get(0);
	}

}
