

import java.util.Arrays;

/*
다음의 희소 행렬을 2차원 배열의 논리적 구조로 표현하시오.
 	A=	0	0	0	9			B = 7	4	4
 		0	1	0	0				0	3	9			
 		0	0	0	0				1	1	1				
		0	0	7	0				3	2	7			
 		0	0	0	0				5	0	3				
		3	0	0	0
 		0	0	0	0
 		
 	B 배열 : 7 4 4 : A배열의 행의수,열의수,값의갯수
 	        0 3 9 : A배열의 0행3열 값:9
 	        1 1 1 : A배열의 1행1열 값:1	
 	        3 2 7 : A배열의 3행2열 값:7	
 	        5 0 3 : A배열의 5행0열 값:3	
 */
public class SparseMatrix {
	static int[][] a = {
			{0,0,0,9},
			{0,1,0,0},
			{0,0,0,0},
			{0,0,7,0},
			{0,0,0,0},
			{3,0,0,0},
			{0,0,0,0}
		};	
	public static void main(String[] args) {
		int[][] b = new int[5][3];
		int cCnt=0, vCheck=1;
		
		for(int i=0 ; i<a.length;i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j] != 0 ) {
					b[vCheck][cCnt++] = i;
					b[vCheck][cCnt++] = j;
					b[vCheck][cCnt] = a[i][j];
					vCheck++;
					cCnt=0;
				}
			}
		}
		
		b[0][0] = a.length; 
		b[0][1] = a[0].length;
		b[0][2]=vCheck-1;
		
		for(int[] arr : b) 
			System.out.println(Arrays.toString(arr));
	}
}
