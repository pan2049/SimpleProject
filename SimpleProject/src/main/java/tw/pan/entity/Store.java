package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store extends Address{

	private Integer storeId;
	private Integer managerStaffId;
	private String lastUpdate;
}