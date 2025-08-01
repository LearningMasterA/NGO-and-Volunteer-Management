package com.ngo.dao;

import com.spring.donation.Donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ngo.dao.DonorDao;
@Component("donorDao")
public class DonorDaoImpl implements DonorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insertDonor(Donor d) {
		String q="insert into donors(name,email,phone,donation_type,amount_of_items) values (?,?,?,?,?)";
		int i = jdbcTemplate.update(q,d.getName(),d.getEmail(),d.getPhone(),d.getDonation_type(),d.getAmount_of_items());
	    return i;
	}

}
