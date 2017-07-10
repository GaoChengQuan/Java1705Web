package com.situ.day43.filter;

import java.util.ArrayList;
import java.util.List;

public class WordsUtil {
	private static List<String> list = new ArrayList<String>();
	
	static {
		//这些敏感数据应该从数据库取出来，这里只是模拟这个过程
		list.add("骂人");
		list.add("NND");
	}
	
	public static List<String> getWords() {
		return list;
	}
}
