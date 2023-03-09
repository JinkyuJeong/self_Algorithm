
/*
주어진 배열을 시계방향으로 90도 회전시켜서  출력하는 프로그램을 완성하시오.
주어진 배열에 값
 **  
 **  
 *****
 *****
[결과]
 *****
 *****
 ** 
 **  
*/
public class Rotation {

	public static void main(String[] args) {
		char[][] star = { 
				  { '*', '*', ' ', ' ', ' ' }, 
		          { '*', '*', ' ', ' ', ' ' }, 
		          { '*', '*', '*', '*', '*' },
		          { '*', '*', '*', '*', '*' } 
		          };
		
		for(int i=3 ; i>=0 ; i--) {
			for(int j=0; j<5; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
	}
}
