

import java.util.Scanner;

public class FractalTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삼각형 한 변의 길이를 적으세요. (3*2^k값만 가능) : ");
		int n = sc.nextInt();
		String[] star = new String[n];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";
		String space ="   ";
	
		for(int i=3,k=1;i<n;i<<=1,k<<=1) {
			for(int j=0; j<i;j++) {
				star[i+j] = star[j] + " "+ star[j];
				star[j]= space+star[j]+space;
			}
			for(int j=0; j<k;j++)
				space+="   ";
		}
		
		for(String s : star)
			System.out.println(s);
	}

}
