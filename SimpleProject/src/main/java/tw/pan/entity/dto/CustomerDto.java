package tw.pan.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@Email
	private String email;
	private Integer addressId;
	private String address;
	private String address2;
	private String district;
	@NotNull
	@NotBlank
	private Integer cityId;
	private Integer postalCode;
	@NotNull
	@NotBlank
	private Integer phone;
	@NotNull
	@NotBlank
	private Integer storeId;
	
}
