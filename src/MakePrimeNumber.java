

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
소수 만들기
문제 설명
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록
solution 함수를 완성해주세요.
제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
입출력 예
nums	result
[1,2,3,4]	1
[1,2,7,6,4]	4
입출력 예 설명
입출력 예 #1
[1,2,4]를 이용해서 7을 만들 수 있습니다.
입출력 예 #2
[1,2,4]를 이용해서 7을 만들 수 있습니다.
[1,4,6]을 이용해서 11을 만들 수 있습니다.
[2,4,7]을 이용해서 13을 만들 수 있습니다.
[4,6,7]을 이용해서 17을 만들 수 있습니다. */
public class MakePrimeNumber {
	private static List<ArrayList<Integer>> comList = new ArrayList<>();
	
	private static void combine(int[] nums, boolean[] checked, int start, int r ){
		if(r==0) {
			ArrayList<Integer> list = new ArrayList<>();
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
	
    static int solution(int[] nums) {
        int answer = 0;
        int start=0, r=3;
        boolean[] checked = new boolean[nums.length];
        Arrays.sort(nums);
        combine(nums, checked, start, r);
        
        List<Integer> arr = null;
        for(int i=0; i<comList.size() ; i++) {
        	arr = comList.get(i);
        	int sum=0, cnt = 0;
        	
        	for(int a : arr) sum+=a;
        	for(int j=1 ; j<=sum ; j++) {
        		if(sum%j==0) cnt++;
        	}
        	
        	if(cnt==2) {
        		System.out.println(arr+"를(을) 이용해서 "+sum+"을 만들 수 있습니다.");
        		answer++;
        	}
        }
        comList.clear();
        return answer;
   }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4})); //1
		System.out.println(solution(new int[] {1,2,7,6,4})); //4
		System.out.println(solution(new int[] {1,2,3,4,5,6})); //6
	}
}
