import java.util.Arrays;
import java.util.LinkedHashSet;

/* 
소수 찾기
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
17	3
011	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
11과 011은 같은 숫자로 취급합니다.
 */
public class FindPrimeNumber {
	private static LinkedHashSet<Integer> comList = new LinkedHashSet<>();	// 소수를 담을 공간(중복 불가)
	private static String s = "";		// 체크용 빈 문자열
	
	private static void combine(String numbers, boolean[] checked,  int r ){
		if(r==s.length()) {
			int num = Integer.parseInt(s);
			int cnt=0;
			// 소수(PrimeNumber) 체크 알고리즘
			if(num != 1) {
				for(int i=1 ; i<=num ; i++) {
					if(num%i==0) cnt++;
				}
				if(cnt==2) comList.add(num);
			}
		}
		for(int i=0 ; i<numbers.length(); i++) {
			// 값이 하나가 선택되면은 그 인덱스의 숫자는 다시 쓸 수 없게 checked를 해준다.
			if(!checked[i]) {
				checked[i]=true;
				s+=numbers.charAt(i);
				combine(numbers, checked, r);
				checked[i]=false;		// 조합을 확인하고 나온 값의 인덱스는 재사용 가능하게 unchecked를 해준다.
				s = "";	// 조합을 다 했으니 체크용 문자열은 빈 문자열로 바꿔준다.
			}
		}
	}
	
	static int solution(String numbers) {
		int answer = 0;
		String[] num = numbers.split(""); 	// 출력할려고 만든거임 알고리즘에 사용 ㄴㄴ
		for(int i=0 ; i<numbers.length(); i++) {
			combine(numbers, new boolean[numbers.length()], i+1);
		}
		System.out.println(Arrays.toString(num) + "으로는 소수 " + comList  + "를 만들 수 있습니다.");
		answer = comList.size();
		comList.clear();
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

}
