/*
 * 11*11 크기의 사각형이 있다고 가정할때 다음 결과를 출력되도록 프로그램 작성하기
X□■□■□■□■□X
□X□■□■□■□X□
■□X□■□■□X□■
□■□X□■□X□■□
■□■□X□X□■□■
□■□■□X□■□■□
■□■□X□X□■□■
□■□X□■□X□■□
■□X□■□■□X□■
□X□■□■□■□X□
X□■□■□■□■□X
*/
public class XRect {

	public static void main(String[] args) {
		String[][] x = new String[11][11];
		
		for(int i=0 ; i<11;i++) {
			for(int j=0;j<11;j++) {
				if((i+j)%2==1) x[i][j]="□";
				else if(i==j) x[i][j]="X";
				else if(i+j==10) x[i][j]="X";
				else x[i][j]="■";
			}
		}

		for(int i=0 ; i<11;i++) {
			for(int j=0;j<11;j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}

}
