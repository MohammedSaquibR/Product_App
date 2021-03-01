package com.rakuten.training;

import java.awt.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = SpringApplication.run(ProductAppApplication.class, args);
		
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
//		TestCode.testFullProductDAO(springContainer);
//		TestCode.testCustomerDAO(springContainer);
//		TestCode.testCrudRepository(springContainer);
	}


	

}
