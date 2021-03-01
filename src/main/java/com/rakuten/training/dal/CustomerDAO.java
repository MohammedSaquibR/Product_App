package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Customer;

public interface CustomerDAO {

	public Customer save(Customer toBeSaved);
	public Customer findById(int id);
	public List<Customer> findAll();
	public void deleteById(int id);
	public List<Customer> findByFirstName(String fname);
}
