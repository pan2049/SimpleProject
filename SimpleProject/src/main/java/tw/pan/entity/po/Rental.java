package tw.pan.entity.po;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rental implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer rentalId;
	private String rentalDate;
	private Inventory inventory;
	private Customer customer;
	private String returnDate;
	private Staff staff;
	private String lastUpdate;
}
