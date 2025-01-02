package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.pan.entity.Film;
import tw.pan.mappers.ListMapper;

@Service
public class ListService {

	@Autowired
	private ListMapper listMapper;
	
	public List<Film> getAllFilm() {
		return listMapper.selectAllFilm();
	}
	
	public List<Film> getFilmFuzzyQuery(String text) {
		return listMapper.selectFilm(text);
	}
	
	public List<Film> getFilmFuzzyQuery(List<String> texts) {
		String likeStr = "";
		for(String text : texts) {
			likeStr += "%" + text;
		}
		likeStr += "%";
		return listMapper.selectFilmByTexts(likeStr);
	}
	
	
	
	
	
}
