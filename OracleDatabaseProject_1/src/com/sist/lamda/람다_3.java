package com.sist.lamda;

import java.util.*;

/*
	1. 매개변수 1개, 리턴형이 없는 람다식
		Consumer
	2. 매개변수 2개, 리턴혀잉 있는 람다식
		Function
	4. 조건 검색람다식 
		Predicate
	5. 리스트 처리 (String + Lambda)


*/
public class 람다_3 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("박문수", "홍길동", "이순신", "춘향이", "심청이");
		//names.stream().filter(name -> name.startsWith("홍")).forEach(System.out::println);
		names.forEach(name->System.out.println(name));
	}

}
