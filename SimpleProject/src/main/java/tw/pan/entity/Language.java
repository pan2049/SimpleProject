package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {

	private Integer languageId;
	private String name;
	private String lastUpdate;
	
}
