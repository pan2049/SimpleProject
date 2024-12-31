package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store{

	private Integer storeId;
	private Integer managerStaffId;
	private Address address;
	private String lastUpdate;
}
