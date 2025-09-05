package com.sist.lambda;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

//함수형 인터페이스
@FunctionalInterface
interface MyCalc
{
	int calc(int a, int b);	// 반드시 메소드가 한 개만 선언
	
}
/*
	Runnable -> run()
	ActionListener -> actionPerformed()
	단순하게 DB에서 가지고 오는 데이터 제어 
	
	-> 코드 간결
	-> Stream 지원 -> Collection 제어
	--------------
	-> 가독성이 떨어진다
	-> 복잡한 로직에는 사용금지
	
	전체 사원 출력
	급여가 2000 이상
	부서별 평균
	직위별 최고 급여
	가장 높은 급여 
	------------------ SQL 
	조건 : fliter(vo -> vo.getSal() >= 2000)
	출력 형식 : map(EmpVO::getEname)
	여러개 출력 : forEach
	정렬 : sorted(EmpVO::getSal)
	---------------------------------
	-> 함수 포인터 -> lambda : x + y(파이썬)
	JWT -> Sprint-Boot : 카카오 / 네이버 .....
	--- 쿠키
*/

public class LambdaMain2 {

	public static void main(String[] args) {
		/*
			public int calc(int a, int b)
			{
				return a + b;
			}
		
		*/

		MyCalc plus = (a, b) -> a + b;
		MyCalc minus = (a, b) -> a - b;
		MyCalc multi = (a, b) -> a * b;
		MyCalc div = (a, b) -> a / b;
		
		System.out.println(plus.calc(10, 3));
		System.out.println(minus.calc(10, 3));
		System.out.println(multi.calc(10, 3));
		System.out.println(div.calc(10, 3));
	}

}
