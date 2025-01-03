package tw.pan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Film{

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
	private Set<String> specialFeatures;
	private String lastUpdate;
	
	// exception param
	private String category;
	private String actors;
	
}
