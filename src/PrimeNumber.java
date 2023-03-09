

import java.util.Scanner;

/*
 * 숫자 n을 입력받아 n숫자보다 작은 소수(primary number)의 갯수를 구하기
 * 숫자를 입력하세요
 * 20
 * 
 * 1,2,3,5,7,11,13,17,19
 * 20숫자까지의 소수의 갯수:9
 * 
 */
public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		int cnt =0, numCnt=0;
		
		for(int i=1; i<num;i++) {
			for(int j=1 ;j<=i;j++) {
				if(i%j==0) cnt++;
			}
			if(i == 1 || cnt == 2) {
				System.out.print(i+", " );
				numCnt++;
			}
			cnt=0;
		}
		System.out.println("\n"+num+"숫자까지의 소수의 갯수 : " + numCnt);
		
	}
}
