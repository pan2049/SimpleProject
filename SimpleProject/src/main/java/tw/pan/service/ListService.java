package tw.pan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import tw.pan.entity.Film;
import tw.pan.mappers.ListMapper;

@Service
public class ListService {

	@Autowired
	private ListMapper listMapper;
	
	@Cacheable(value = "filmSearchCache", key = "'all'")
	public List<Film> getAllFilm() {
		return listMapper.selectAllFilm();
	}
	
	@Cacheable(value = "filmSearchCache", key = "#text")
	public List<Film> getFilmFuzzyQuery(String text) {
		System.out.println("search!!!");
		return listMapper.selectFilm(text);
	}
	
	@Cacheable(value = "filmSearchCache", key = "#texts.toString()")
	public List<Film> getFilmFuzzyQuery(List<String> texts) {
		String likeStr = "";
		for(String text : texts) {
			likeStr += "%" + text;
		}
		likeStr += "%";
		return listMapper.selectFilmByTexts(likeStr);
	}
	
	@Cacheable(value = "filmActorCache", key = "#actorFullName")
	public List<Film> getFilmByActor(String actorFullName) {
		return listMapper.selectFilmByActor(actorFullName);
	}
	
	@Cacheable(value = "filmCategoryCache", key = "#categoryName")
	public List<Film> getFilmByCategory(String categoryName) {
		return listMapper.selectFilmByCategory(categoryName);
	}
	
}
