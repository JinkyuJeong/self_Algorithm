import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*알파벳 대소문자로 된 단어가 주어지면, 
이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
단, 대문자와 소문자를 구분하지 않는다.
*/
public class Mississipi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		char[] ch = s.toCharArray();
//		int[] in = new int[26];
//		for(char c : ch) {
//			if(c>='A' && c<='Z') c = (c+"").toLowerCase().charAt(0);
//			in[c-97]++;
//		}
//		int max = IntStream.of(in).max().getAsInt();
//		int cnt=0, n=0;
//		for(int i=0; i<in.length ;i++) {
//			if(max == in[i]) {
//				cnt++;
//				n=i;
//				if(cnt>=2) {
//					System.out.println("?");
//					return;
//				}
//			}
//		}
//		System.out.println(((char)(n+97)+"").toUpperCase());
		
		String s= sc.next();
		s.toUpperCase();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Character> list2 = new ArrayList<>();
		int cnt=0;
		for(int i=0; i<s.length(); i++) {
			for(int j=i; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) cnt++;
			}
			list.add(cnt);
			list2.add(s.charAt(i));
			cnt=0;
		}
		int max = Collections.max(list);
		int n=0;
		for(int a=0; a<list.size(); a++) {
			if(max==list.get(a)) {
				cnt++;
				n=a;
				if(cnt>=2) {
					System.out.println("?");
					return;
				}
			}
		}
		System.out.println((list2.get(n)+"").toUpperCase());
		
		
	}
}
