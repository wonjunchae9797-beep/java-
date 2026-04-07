package com.kh.chap04.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {
		// 파일은 파일인데 확장자가 .properties
		// 변경하지않는 설정정보
		// 해당 프로그램이 기본적으로 가져야할 정보들을 담는 용도 많이 사용
		Properties prop = new Properties(); // 상속의 잘못된 예
		// prop.put("sdfdsf", new Sandwich("맛있음", "에그마요"));
		prop.setProperty("List", "LinkedList");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Set", "HashSet");
		//MyProperties mp = new MyProperties();
		//mp.put
		// prop.put
		
		try {
			//prop.store(new FileOutputStream("test.properties"), "쓰고싶은거");
			
			prop.load(new FileInputStream("test.properties"));
			
			System.out.println(prop.get("Map"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
