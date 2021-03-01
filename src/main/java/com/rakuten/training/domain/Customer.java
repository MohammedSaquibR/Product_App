package com.rakuten.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
		
		@Id
		@Column(name = "cust_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		
		@Column(name = "first_name",length=50)
		String fname;
		@Column(name = "last_price")
		String lname;
		@Column(name = "email")
		String email;
		public Customer()
		{
			
		}
		public Customer(String fname, String lname, String email) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.email = email;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
}
