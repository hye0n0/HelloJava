package co.edu.api;

import java.io.IOException;
import java.util.Scanner;

public class StringExe1 {

	
	public static void changeCapital(String msg) throws IOException {
		// 대문자 -> 소문자, 소문자 -> 대문자(32)
		// aBcD -> AbCd   97:65, 98:66
		// 소문자: 97 ~ 122, 대문자: 65 ~ 90
		
		byte[] bytes = new byte[100];
		
		System.out.println("입력: ");
		int readByteNo = System.in.read(bytes);
		
	}
}
