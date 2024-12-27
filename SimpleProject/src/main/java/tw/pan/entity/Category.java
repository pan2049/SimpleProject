package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

	private Integer categoryId;
	
	@JsonProperty(value = "name")
	private String categoryName;
	
	private String lastUpdate;
	
	
}
