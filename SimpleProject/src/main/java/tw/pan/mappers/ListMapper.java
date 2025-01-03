package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.Film;

public interface ListMapper {

	List<Film> selectAllFilm();
	
	List<Film> selectFilm(String text);
	
	List<Film> selectFilmByTexts(String texts);
	
	List<Film> selectFilmByActor(String actorFullName);
	
	List<Film> selectFilmByCategory(String categoryName);
}
