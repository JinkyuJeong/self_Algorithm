import java.util.Arrays;
import java.util.Scanner;

/*프로그래밍 문제를 풀다 보면 뒤죽박죽인 N개의 데이터를 숫자의 크기 순으로 0 ~ N-1까지의 숫자로 재정렬 해야되는 경우가 종종 있다.
예를 들어 N=5 이고,
50 23 54 24 123
이라는 데이터가 있다면,
2 0 3 1 4
가 된다.
데이터를 재정렬하는 프로그램을 작성하시오.

50 23 54 24 123 에서
23, 24, 50, 54, 123 순서로 0, 1, 2, 3, 4 가 된다.
그리고 원래의 위치대로 출력한다.

첫째 줄에 데이터의 개수 N이 입력된다. ( 1 <= N <= 50,000)
둘째 줄에 공백으로 분리되어 N개의 서로 다른 데이터가 입력된다. (값의 범위:0~500,000)

<입력예시>
5
50 23 54 24 123

<출력예시>
2 0 3 1 4 
*/
public class DataSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 개수 N을 입력해주세요.");
		int N = sc.nextInt();
		System.out.println("숫자 N개를 입력해주세요.");
		int[] nums = new int[N];
		for(int i=0 ;i<N; i++)
			nums[i] = sc.nextInt();
		int[] copyNums = Arrays.copyOf(nums,N);
		Arrays.sort(nums);
		int[] temp = new int[N];
		for(int i=0 ; i<N; i++) {
			for(int j=0 ; j<N; j++) {
				if(copyNums[i]==nums[j]) {
					temp[i] = j;
				}
			}
		}
		for(int a : temp)
			System.out.print(a+" ");
	}

}
