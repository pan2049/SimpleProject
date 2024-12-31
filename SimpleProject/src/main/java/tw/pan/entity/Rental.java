package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rental {

	private Integer rentalId;
	private String rentalDate;
	private Inventory inventory;
	private Customer customer;
	private String returnDate;
	private Staff staff;
	private String lastUpdate;
}
