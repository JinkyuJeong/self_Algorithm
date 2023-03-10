import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	private static List<ArrayList<String>> comList = new ArrayList<>();

	private static void combine(String[] nums, boolean[] checked, int start, int r ){
		if(r==0) {
			ArrayList<String> list = new ArrayList<>();
			for(int i=0; i<nums.length; i++) {
				if(checked[i]) list.add(nums[i]);
			}
			comList.add(list);
			return;
		}

		for(int i=start ; i<nums.length; i++) {
			checked[i]=true;
			combine(nums, checked, i+1, r-1);
			checked[i]=false;
		}

	}
	static int solution(String numbers) {
		int answer = 0;
		String[] strNum = numbers.split("");
		
		for(int i=0 ; i<strNum.length; i++) {
			combine(strNum, new boolean[strNum.length], 0, i+1);
			System.out.println(comList);
		}
		
		

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
//		System.out.println(solution("011"));
	}

}
