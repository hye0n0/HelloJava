package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

public class MapExample {
	public static void main(String[] args) {
		// key: Integer, val: String
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식"); // 똑같은 key값이 있으면 덮어쓰기함. 전의 val은 사라짐.
		
		map.remove(300); // 삭제
		
		System.out.println("컬렉션: " + map.size());
		
		System.out.println("val: " + map.get(300));
		
		// 반복자 생성
		Set<Integer> keySet = map.keySet(); // 키만 새로운 set컬렉션에 저장
		for(Integer key : keySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key));
		}
		
		Set<Entry<Integer,String>> entSet =  map.entrySet(); // key와 val 둘다 가져옴
		for(Entry<Integer,String> ent : entSet) {
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
		}
		
	}
}
