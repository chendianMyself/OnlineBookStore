package com.itheima.dao;

import com.itheima.domain.Customer;

public interface CustomerDao {

	void save(Customer c);

	Customer findOne(String customerId);

	Customer find(String username, String password);

}
