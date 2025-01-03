package tw.pan.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import tw.pan.entity.Film;

@Component
public class SystemStart {

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("system start !!!");
		GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

		List<Film> filmList = new ArrayList<>();
		Film obj = new Film();
		obj.setActors("test");
		Film obj2 = new Film();
		obj2.setActors("test2");
		filmList.add(obj);
		filmList.add(obj2);
		byte[] serialized = serializer.serialize(filmList); // 測試序列化
		List<Film> deserialized = (ArrayList) serializer.deserialize(serialized); // 測試反序列化

		System.out.println(deserialized);
	}
}
