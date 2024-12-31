package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City{

	private Integer cityId;
	private String city;
	private Country country;
	private String lastUpdate;
}
