package org.Struts.Demo.service;

import java.util.ArrayList;
import java.util.List;

import maven.Customer;
import maven.Hibernate;

import org.hibernate.Session;


public class Service {

	List<Customer> customerList = new ArrayList<Customer>();
	/**
	 * 
	 */
	Customer customer = new Customer();

	public String getListCustomer() throws Exception {
		System.out.println("getListCustomer");
		Session session = Hibernate.getSessionFactory().openSession();
		customerList = session.createQuery("from Customer").list();
		for (Customer cs : customerList) {
			System.out.println(cs.getName() + "-------" + cs.getAddress()
					+ "-----------" + cs.getCreatedDate());
		}
		// return session.createQuery("from Customer").list();
		return "success";
	}
}
