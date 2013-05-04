import java.util.List;

import maven.Customer;

import org.Struts.Demo.example.CustomerAction;
import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class CustomerActionTest extends StrutsTestCase {

	public void testListCustomerAction() throws Exception {

		System.out.println("Method-1: testListCustomerAction");

		CustomerAction customerAction = new CustomerAction();
		// customerAction = null;
		String result = customerAction.listCustomer();

		assertEquals("success", result);

		List<Customer> customerList = customerAction.getCustomerList();
		for (Customer customer : customerList) {
			System.out.println("RESULT from DATABASE: " + customer.getName()
					+ customer.getCreatedDate());
		}

		// customerAction.listCustomer();

	}

	public void testListAllCustomerData() throws Exception {

		System.out.println("Method-2: listAllCustomerData");

		CustomerAction customerAction = new CustomerAction();
		String result = customerAction.listCustomer();

		assertEquals("success", result);

		List<Customer> customerList = customerAction.getCustomerList();
		for (Customer customer : customerList) {
			System.out.println("RESULT from DATABASE: " + customer.getName()
					+ customer.getCreatedDate());
		}

	}

	public void testAddNewCustomerByModel() throws Exception {

		System.out.println("Method-3: addNewCustomerByModel");

		CustomerAction customerAction = new CustomerAction();

		Customer customer = new Customer();

		customer.setAddress("Ho Chi Minh");
		customer.setName("Model Thien");

		customerAction.setCustomer(customer);
		assertEquals("success", customerAction.addCustomer());
	}

	public void testAddNewCustomerByParameter() throws Exception {

		System.out.println("Method-4: addNewCustomerByParameter");

		CustomerAction customerAction = new CustomerAction();

		request.setParameter("customer.name", "Parameter Thien");
		request.setParameter("customer.address", "Tp. HCM");

		ActionProxy actionProxy = getActionProxy("/addCustomerAction");
		CustomerAction customerAction2 = (CustomerAction) actionProxy
				.getAction();

		System.out.println("actionProxy.execuse " + actionProxy.execute());
	}

	public void testCustomerAction() throws Exception {

		System.out.println("Method-5: testCustomerAction");

		CustomerAction customerAction = new CustomerAction();

		customerAction.listCustomer();

		List<Customer> customerList = customerAction.getCustomerList();
		for (Customer customer : customerList) {
			System.out.println("RESULT from DATABASE: " + customer.getName()
					+ customer.getAddress());
		}
	}

	public void testDeleteCustomer() throws Exception {

		System.out.println("Method-6: testDeleteCustomer");

		CustomerAction customerAction = new CustomerAction();
		customerAction.listCustomer();

		List<Customer> customerList = customerAction.getCustomerList();

		if (customerList.size() == 0) {
			return;
		}

		Customer customer = customerList.get(0);
		

		System.out.println("Address: " + customer.getAddress());

		customerAction.setId(customer.getCustomerId());
		customerAction.deleteCustomer();

		customerAction.listCustomer();
		customerList = customerAction.getCustomerList();

		for (Customer iCustomer : customerList) {
			System.out.println("RESULT from DATABASE: " + iCustomer.getName()
					+ iCustomer.getAddress());
		}

	}
	
}
