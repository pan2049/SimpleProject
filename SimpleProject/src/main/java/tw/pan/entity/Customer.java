package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends Address{

	private Integer customerId;
	private Integer storeId;
	private String firstName;
	private String lastName;
	private String email;
	private Integer active;
	private String createDate;
	private String lastUpdate;
	
}
