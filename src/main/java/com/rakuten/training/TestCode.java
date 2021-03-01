package com.rakuten.training;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.CustomerDAO;
import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.repos.ProductRepository;
import com.rakuten.training.domain.Customer;
import com.rakuten.training.domain.Product;

public class TestCode {

public static void testFullProductDAO(ApplicationContext springContainer) {
		
		ProductDAO dao = springContainer.getBean(ProductDAO.class);
		
		Product aProduct = new Product("test", 12334, 123);
		Product saved = dao.save(aProduct);
		System.out.println("Saved Product with id : "+saved.getId());
		
		System.out.println("Removing newly added product....");
		dao.deleteById(saved.getId());
		List<Product> f = dao.findAll();
		System.out.println(f.size());
		
	}

public static void testCustomerDAO(ApplicationContext springContainer) {
	CustomerDAO dao = springContainer.getBean(CustomerDAO.class);
	Customer c = new Customer("fn","ln","fn@gamil.com");
	dao.save(c);
	dao.deleteById(c.getId());
	List<Customer> l = dao.findByFirstName("fn");
	System.out.println(l.size());
	List<Customer> f = dao.findAll();
	System.out.println(f.size());
	System.out.println(dao.findById(2));
}

public static void testCrudRepository(ApplicationContext springContainer) {

	ProductRepository repo = springContainer.getBean(ProductRepository.class);
	Product p = new Product("asb",12345,12);
	repo.save(p);
}
}
