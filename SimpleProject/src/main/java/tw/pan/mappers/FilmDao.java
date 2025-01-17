package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.po.Film;

public interface FilmDao {

	List<Film> selectAllFilm();
	
	List<Film> selectFilm(String text);
	
	List<Film> selectFilmByTexts(String texts);
	
	List<Film> selectFilmByActor(String actorFullName);
	
	List<Film> selectFilmByCategory(String categoryName);
}
