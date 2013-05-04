package org.Struts.Demo.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import maven.Customer;
import maven.Hibernate;

//import org.Child.App;

import org.Struts.Demo.service.Service;
import org.hibernate.Session;



import com.opensymphony.xwork2.ModelDriven;
 
public class CustomerAction
	implements ModelDriven{
	
	
	Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	List<Customer> customerList = new ArrayList<Customer>();
	Long id;
	
	public static String SUCCESS = "success";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public Object getModel() {
		return customer;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{
		
		//get hibernate session from the servlet context
		

		Session session = Hibernate.getSessionFactory().openSession();

		//save it
		customer.setCreatedDate(new Date());
	 
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
	 
		//reload the customer list
		customerList = null;
		customerList = session.createQuery("from Customer").list();
		
		return SUCCESS;
	
	}
	
	//list all customers
	public static String listCustomer() throws Exception{
		
		System.out.println("List Customer!!!!....");

//		Session session = Hibernate.getSessionFactory().openSession();

//		customerList = session.createQuery("from Customer").list();		
		return new Service().getListCustomer();
	}
	
	public String updateCustomer() throws Exception {
		
		Session session = Hibernate.getSessionFactory().openSession();
		session.getTransaction().begin();
	
		customer = (Customer)session.load(Customer.class, id);
		
		/*AppChild child = new AppChild();*/

		/*customer.setAddress(child.testChildren() + customer.getAddress());*/
		/*session.delete(customer);*/
		session.getTransaction().commit();
		
		//session.close();
		
		return SUCCESS;
	}
	
	public String deleteCustomer() throws Exception {
		Session session = Hibernate.getSessionFactory().openSession();
		session.getTransaction().begin();
//		System.out.println("IDDDDDDDDDDDDDDDDD: "+id);
		customer = (Customer)session.load(Customer.class, id);
//		System.out.println(customer.getName());
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
		return SUCCESS;
	}
	
}