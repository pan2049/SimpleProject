package tw.pan.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer addressId;
	private String address;
	private String address2;
	private String district;
	private City city;
	private String postalCode;
	private String phone;
	private String lastUpdate;
}
