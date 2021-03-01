package com.rakuten.training.dal.repos;


import com.rakuten.training.domain.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface ProductRepository extends CrudRepository<Product, Integer>{
	public List<Product> findByPrice(float p);//select x from Product where x.price=:p
	public List<Product> findByPriceLessThan(float p);//select x from Product where x.price<:p
}
