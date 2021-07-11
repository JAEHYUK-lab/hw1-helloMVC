package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	private static final CustomerService instance = new CustomerService();
	
	private Map<String, Customer> customers;
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
		System.out.println("In CustomerService Constructor");
	}
	
	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id) {
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}

	public Customer login(String id, String password) {
		Customer customer = findCustomer(id);
	
		if(customer != null) {
			if( password.equals(customer.getPassword())  ) {
				System.out.println("login success");
				return customer;
			}
					
			else {
				System.out.println("login failed");
				return null;
			}
		}	
		return null;
	}

	//customers HashMap에 값을 저장
	public Customer register(String id, String password, String name, String gender, String email) {
		Customer customer = new Customer(id, password, name, gender, email);
		
		customer.setId(id);
		customer.setPassword(password);
		customer.setName(name);
		customer.setGender(gender);
		customer.setEmail(email);
		
		addCustomer(customer);
		
		return customer;
	}
	
	
}
