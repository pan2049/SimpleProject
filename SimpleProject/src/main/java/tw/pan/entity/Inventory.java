package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inventory{

	private Integer inventoryId;
	private Film film;
	private Store store;
	private String lastUpdate;
	
}
