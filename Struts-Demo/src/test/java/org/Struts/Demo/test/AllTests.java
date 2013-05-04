package org.Struts.Demo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ListCustomerTest.class,AddCustomerTest.class,DeleteCustomerTest.class,SaveCustomerTest.class, UpdateCustomerTest.class })
public class AllTests {

}
