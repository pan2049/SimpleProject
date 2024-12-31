package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address{

	private Integer addressId;
	private String address;
	private String address2;
	private String district;
	private City city;
	private String postalCode;
	private String phone;
	private String lastUpdate;
}
