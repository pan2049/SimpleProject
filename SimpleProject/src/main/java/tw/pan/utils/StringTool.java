package tw.pan.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.jsonwebtoken.lang.Arrays;

public class StringTool {
	
	public static boolean isSpace(String text) {
		String matchStr = "\\s*";
		return text.matches(matchStr);
	}
	
	public static boolean hasTextAndSpace(String text) {
		String matchStr = "^[^\\s]*$";
		return text.matches(matchStr);
	}
	
	public static List<String> cutString(String text) {
		String[] array = text.split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(array));
		while(list.remove(""));
		return list;
	}
	
	public static String getSystemTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
	
}
