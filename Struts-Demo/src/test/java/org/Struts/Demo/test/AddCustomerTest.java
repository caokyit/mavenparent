package org.Struts.Demo.test;

import maven.Customer;

import org.Struts.Demo.example.CustomerAction;
import org.apache.struts2.StrutsTestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class AddCustomerTest extends StrutsTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}

	@Test
	public void testAddNewCustomerByModel() throws Exception {
		System.out.println("Add New Cus with model");
		CustomerAction customerAction = new CustomerAction();
		Customer customer = new Customer();
		customer.setAddress("Address Test");
		customer.setName("Name Test");
		customerAction.setCustomer(customer);
		assertEquals("success", customerAction.addCustomer());
	}

}
