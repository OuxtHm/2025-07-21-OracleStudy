package com.sist.main;

public class MainClass {
	public static void main(String[] args) {
		try {
			for(int i = 1; i <= 10; i++)
			{
				int r = (int)(Math.random() * 3);
				System.out.println(i / r);
			}
		} catch (Exception e) {}
	}
}
