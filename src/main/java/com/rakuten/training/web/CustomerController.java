package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.dal.CustomerDAO;
import com.rakuten.training.domain.Customer;
import com.rakuten.training.domain.Product;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDAO dao;
	
	@GetMapping("/customers")
	public List<Customer> getAllProducts()
	{
		return dao.findAll();
	}
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getProductById(@PathVariable("id")int pid)
	{
		Customer p = dao.findById(pid);
		if(p!=null)
		{
			return new ResponseEntity<Customer>(HttpStatus.OK);		
			}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/customers")
	public ResponseEntity<Customer> addNewproduct(@RequestBody Customer toBeAdded) {
		try {
            Customer id = dao.save(toBeAdded);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/products/"+id));
            return new ResponseEntity<>(toBeAdded,headers,HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	}
	@DeleteMapping("customers/{id}")
	public  void deleteProduct(@PathVariable("id")int pid)
	{
		dao.deleteById(pid);
	}
	@GetMapping("customers/{fname}")
	public ResponseEntity<Customer> getProductByName(@PathVariable("fname")String pid)
	{
		List<Customer> p = dao.findByFirstName(pid);
		if(p!=null)
		{
			return new ResponseEntity<Customer>(HttpStatus.OK);		
			}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
