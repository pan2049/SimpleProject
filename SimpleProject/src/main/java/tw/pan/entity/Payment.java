package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {

	private Integer paymentId;
	private Customer customer;
	private Staff staff;
	private Rental rental;
	private Float amount;
	private String paymentDate;
	private String lastUpdate;
}
