package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.Customer;

public interface CustomerDao {

	public List<Customer> selectAllCustomer();
	
	public List<Customer> selectCustomerByName(String name);
	
	public Customer selectCustomerById(Integer id);
	
	public void insertCustomer(Customer customer);
	
	public void deleteCustomerById(Integer id);
}
