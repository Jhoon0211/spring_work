package di_p.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CompareMain {

	public static void main(String[] args) {
		int [] arr = {55,66,33,66,88,77,22,33,44,55};
		
		ArrayList a1 = new ArrayList();
		HashSet s1 = new HashSet();
		LinkedHashSet s2 = new LinkedHashSet();
		TreeSet s3 = new TreeSet();

		// 익명 함수
		// 맨 앞만 출력 - compare 작동이 안된 것 
		TreeSet ts1 = new TreeSet(
				new Comparator() {
					@Override
					public int compare(Object o1, Object o2) {
						// TODO Auto-generated method stub
						return 0;
					}
				});
		
		// ArrayList와 출력 값 동일 (중복 허용)
		// TreeSet은 정렬되지 않는다는 것을 반박
		TreeSet ts2 = new TreeSet(
				new Comparator() {
					@Override
					public int compare(Object o1, Object o2) {
						// TODO Auto-generated method stub
						return 1;
					}
				});
		
		TreeSet ts3 = new TreeSet(
				new Comparator() {
					@Override
					public int compare(Object o1, Object o2) {
						if(o1 == o2) {
							return 0;
						}
						return 1;
					}
				});
		
		TreeSet ts4 = new TreeSet(
				new Comparator() {
					@Override
					public int compare(Object o1, Object o2) {
						int me = (int)o1;
						int you = (int)o2;
						
						System.out.println(me+":"+you);
						
						return you-me;
					}
				});
		
		for(int i : arr) {
			a1.add(i);
			s1.add(i);
			s2.add(i);
			s3.add(i);
			ts1.add(i);
			ts2.add(i);
			ts3.add(i);
			ts4.add(i);
			System.out.println(">>");
		}
		System.out.println("============================================");

		// int [] arr 고대로 출력
		System.out.println("arr : " + Arrays.toString(arr));
		
		// ArrayList 고대로 출력
		System.out.println("ArrayList : "+a1);
		
		// HashSet 중복 제거, 순서 뒤죽박죽
		System.out.println("HashSet : "+s1);
		
		// LinkedHashSet 중복 제거, 순서 유지만
		System.out.println("LinkedHashSet : "+s2);
		
		// TreeSet 중복 제거, 순서 정렬
		System.out.println("TreeSet : "+s3);
		
		System.out.println("============================================");
		// TreeSet
		System.out.println("ts1 : "+ts1);
		System.out.println("ts2 : "+ts2);
		System.out.println("ts3 : "+ts3);
		System.out.println("ts4 : "+ts4);	
	}
}
