package com.liveguru.frontend;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		Map<String, Integer> test = new HashMap<String, Integer>();
		test.put("test1", 1);
		test.put("test2", 2);
		test.put("test3", 3);

		for (String name: test.keySet()){
            int value = test.get(name);  
            System.out.println(name + " " + value);  
} 
	}

}
