package tw.pan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actor {

	private Integer actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;
	
}
