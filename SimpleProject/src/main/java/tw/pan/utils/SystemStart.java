package tw.pan.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tw.pan.entity.po.Film;

@Component
public class SystemStart {

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("system start !!!");
//		GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//
//		List<Film> filmList = new ArrayList<>();
//		Film obj = new Film();
//		obj.setActors("test");
//		Film obj2 = new Film();
//		obj2.setActors("test2");
//		filmList.add(obj);
//		filmList.add(obj2);
//		byte[] serialized = serializer.serialize(filmList); // 測試序列化
//		List<Film> deserialized = (ArrayList) serializer.deserialize(serialized); // 測試反序列化
//
//		System.out.println(deserialized);
		
		String password = "123";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//		String result = encoder.encode(password);
		String encoderStr = "$2a$16$O45frzOGfjkv.hrTU9CmTudTHH9/0eLLEYcmXsLaJ1pqXxV8E1Oiu";
		System.out.println("password : "+password);
		System.out.println("encoder : "+encoderStr);
		System.out.println(encoder.matches("123", encoderStr));
		
	}
}
