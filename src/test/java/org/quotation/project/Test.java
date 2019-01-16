package org.quotation.project;

import java.util.regex.Pattern;

public class Test {
	
	
	public static void main(String[] args) {
		
		String test = "org.quotation.project.Demo";
		
		String[] str = test.split(Pattern.quote("."));
		
		System.out.println(str[str.length-1]);
		
	}


}
