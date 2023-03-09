

import java.util.Scanner;

/*
삼각형의 높이를 홀수로 입력하세요
5
*****
 ***
  *
 ***
*****
 */
public class StarHourglass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삼각형의 높이를 홀수로 입력하세요 : ");
		int h = sc.nextInt();
		int m = h/2;

		for(int i=1;i<=m+1;i++) {
			for(int j=1; j<i;j++) 
				System.out.print(" ");
			for(int j=i;j<=((m+1)*2)-i;j++) 
				System.out.print("*");
			System.out.println();
		}

		for(int i=1;i<=m;i++) {
			for(int j=i; j<=m-1;j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=(2*i)+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
			
			
	}
}
