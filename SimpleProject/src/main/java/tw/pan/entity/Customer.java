package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer{

	private Integer customerId;
	private Store store;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Integer active;
	private String createDate;
	private String lastUpdate;
	
}
