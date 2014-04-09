package com.mycompany.myproject.testscripts;

public class SandBox {

	public static void main(String[] args) {
		String s = "VISA Ending in (9674)";
		
		String pd = "";
		pd = s.substring(0,s.indexOf(" ")) +"::"+ s.substring(s.indexOf("(")+1,s.indexOf("(")+5) ;

		
		System.out.println(">>>"+s.substring(0,s.indexOf(" ") ));
		
		System.out.println("##>>"+s.substring(s.indexOf("(")+1,s.indexOf("(")+5 ));
		
		System.out.println(pd);
		
	}
	
}
