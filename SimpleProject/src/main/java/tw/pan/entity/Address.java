package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends City{

	private Integer addressId;
	private String address;
	private String address2;
	private String district;
	private String postalCode;
	private String phone;
	private String lastUpdate;
}
