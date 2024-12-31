package tw.pan.entity;

import lombok.Data;

@Data
public class City{

	private Integer cityId;
	private String city;
	private Country country;
	private String lastUpdate;
}
