package org.Struts.Demo.test;

import org.Struts.Demo.example.CustomerAction;
import org.apache.struts2.StrutsTestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ListCustomerTest extends StrutsTestCase {

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
	public void test() throws Exception{		
		assertEquals(1,1);
	}
	@Test
	public void testListCustomerTest() throws Exception{		
		assertFalse(CustomerAction.listCustomer().equals(null));
	}
	
}

