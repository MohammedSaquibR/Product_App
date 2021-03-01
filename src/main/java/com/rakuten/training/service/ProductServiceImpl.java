package com.rakuten.training.service;
import com.rakuten.training.dal.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rakuten.training.domain.*;

@Service
public class ProductServiceImpl implements ProductService {

ProductDAO dao; // = new ProductDAOJpaMemImpl();
	
//	private ProductDAO dao = new ProductDAOJpaImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int createNewProduct(Product toBeCreated) {
		if(toBeCreated.getPrice() * toBeCreated.getQoh() >= 10000) {
			Product created = dao.save(toBeCreated);
			return created.getId();
		}else {
			throw new IllegalArgumentException("The product passed to create is not worth 10k");
		}
	}

	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		
		if(existing == null) {
			throw new IllegalArgumentException("product with id "+id+" not found!");
//			System.out.println("Product doesn't exist. Doin nothin!!");
		}
		if(existing.getPrice() * existing.getQoh() >= 100000) {
			throw new IllegalStateException("Can't delete product when stock >= 100k");
		}
		dao.deleteById(id);
		
	}
	
	public void changePrice(int id,float newPrice) {
		Product p = dao.findById(id);
		p.setPrice(newPrice);
	}
	

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
		}

	@Override
	public int addProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Product created = dao.save(toBeAdded);
			return created.getId();
		}else {
			throw new IllegalArgumentException("The product passed to create is not worth 10k");
		}
	}
}
