package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.Customer;

public interface CustomerDao {

	public List<Customer> selectAllCustomer();
	
	
}
