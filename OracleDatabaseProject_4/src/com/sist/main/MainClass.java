package com.sist.main;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		StudentVO vo = new StudentVO();
		vo.setName("춘향이");
		vo.setKor(90);
		vo.setEng(90);
		vo.setMath(90);
		
		StudentDAO dao = StudentDAO.newInscance();
		dao.stdInsert(vo);
		
		System.out.println("저장 완료");

	}

}
