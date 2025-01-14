package tw.pan.entity.po;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer customerId;
	private Store store;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Integer active;
	private String createDate;
	private String lastUpdate;
	
	private String fullName;
	private String note;
}
