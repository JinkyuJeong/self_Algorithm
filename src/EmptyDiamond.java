import java.util.Scanner;

public class EmptyDiamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		System.out.print("높이를 입력하세요 : ");
		int h=s.nextInt();
		int m=h/2;
		for(int i=0; i<m+1;i++) {
			if(i==m) {
				for(int j=1;j<=h;j++) {
					System.out.print(" ");
				}
			}else{
				for(int j=1;j<=m-i;j++) {
					System.out.print("*");
				}
				for(int j=1;j<=2*i+1;j++) {
					System.out.print(" ");
				}
				for(int j=1;j<=m-i;j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(int j=i;j<=2*m-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}


