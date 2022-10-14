package co.edu.morning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Morning20221014 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		String[] memAry = null;
		try (FileReader fr = new FileReader("C:/Temp/memberList.txt");
			BufferedReader br = new BufferedReader(fr);	){
			//시작할때 txt파일 내용을 list에 저장
			br.readLine();
			while (true) {
			String mem = br.readLine();
			if(mem == null) 
				break;
			
			memAry = mem.split("\t");
			list.add(new Member(memAry[0], memAry[1], Integer.parseInt(memAry[2])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			// 입력받은 값 list에 저장
		while(true) {
			System.out.println("입력>> ex)user1\t홍길동\t3000  (종료)quit");
			String val = scn.nextLine();
			if(val.equals("quit")) {
				System.out.println("시스템을 종료합니다");
				break;
			}else {
				memAry = val.split(" ");
				list.add(new Member(memAry[0], memAry[1], Integer.parseInt(memAry[2])));
			}
		}
			
			//종료하기 전 list안에 있던 값들 txt에 입력후 종료
		try(FileWriter fw = new FileWriter("c:/Temp/memberList.txt");){
			fw.write("회원아이디 회원이름 회원포인트 \n");
			for(Member mem : list) {
				fw.write(mem.getId()+ "\t" 
						+ mem.getName() + "\t"
						+ mem.getPoint() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed");
	}
}
