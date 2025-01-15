package tw.pan.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@JsonInclude(value = Include.NON_NULL)
public class UpdateRentalDto{
	@NotNull
	private Integer rentalId;
	@NotNull
	private String returnDate;
	@NotNull
	private Integer staffId;
}
