package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Staff {

	private Integer staffId;
	private String firstName;
	private String lastName;
	private Address address;
	private byte[] picture;
	private String email;
	private Store store;
	private Integer active;
	private String username;
	private String password;
	private String lastUpdate;
}
