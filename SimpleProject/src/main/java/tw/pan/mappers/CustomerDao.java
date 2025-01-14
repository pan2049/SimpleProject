package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.dto.CustomerDto;
import tw.pan.entity.po.Customer;

public interface CustomerDao {

	public List<Customer> selectAllCustomer();
	
	public List<Customer> selectCustomerByName(String name);
	
	public Customer selectCustomerById(Integer id);
	
	public void insertCustomer(CustomerDto customerDto);
	
	public void deleteCustomerById(Integer id);
}
