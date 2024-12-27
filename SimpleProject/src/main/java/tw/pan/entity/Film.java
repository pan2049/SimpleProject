package tw.pan.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Film extends Category{

	private Integer FID;
	private String title;
	private String description;
	private Integer releaseYear;
	private Integer languageId;
	private Integer originalLanguageId;
	private Integer rentalDuration;
	private Float rentalRate;
	private Integer length;
	private Float replacementCost;
	private String rating;
	private String specialFeatures;
	private String lastUpdate;
	
	private List<Actor> actorList;
}
