package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.domain.Product;
 
class ProductServiceImplTest_WithMockito {
	@Test
	void addProduct_Must_Return_Valid_Id_When_Product_Value_GTEO_10k() {
		//AAA
		//Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		Product arg = new Product("test",10000,1);
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		objUnderTest.setDao(mockDAO);
		Product returnedByMock = new Product("test",10000f,1);
		returnedByMock.setId(1);
		
		Mockito.when(mockDAO.save(arg)).thenReturn(returnedByMock);
		//Act
		int id = objUnderTest.addProduct(arg);
		//Assert
		assertTrue(id>0);
	}
	@Test
	void removeExisting_Must_Return_Valid_Id_When_Product_Value_GTEO_10k() {
		//AAA
		//Arrange
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		int idToTest =1;
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		objUnderTest.setDao(mockDAO);
		Product dataReturnedByMock = new Product("test",10000f,1);
		dataReturnedByMock.setId(idToTest);
		
		Mockito.when(mockDAO.findById(idToTest)).thenReturn(dataReturnedByMock);
		//Act
		objUnderTest.removeExisting(idToTest);
		//Assert
		Mockito.verify(mockDAO).deleteById(idToTest);
	}
}
