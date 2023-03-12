import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 
아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
[입력예시] 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 
집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
[출력]
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
3           96
26 40 83
49 60 57
13 89 99
3          3
1 100 100
100 1 100
100 100 1
6          208
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
 */
public class RgbHouse {
	private static int[][] rgb;
	/*
	 * < combine 메서드 >
	 * 1. 집의 갯수와 행, 열을 입력받는다.
	 * 2. 행의 값은 집의 갯수와 같지 않을 때 까지 더하면서 자기자신을 호출한다.(재귀)
	 * 3. 행의 값이 집의 갯수와 동일시 마지막 집의 행과 열을 인덱스로 가지는 값을 반환
	 * 4. 반환되는 과정에서 Math.min()메서드를 만나 최소값이 정해짐
	 * */
	private static Integer combine(int N, int row, int col) {
		if(row !=N) {
			return switch(col) {
				case 0 -> rgb[row][col] + Math.min(combine(N, row+1, 1), combine(N, row+1, 2)) ;
				case 1 ->  rgb[row][col] + Math.min(combine(N, row+1, 0), combine(N, row+1, 2));
				case 2 -> rgb[row][col] + Math.min(combine(N, row+1, 0), combine(N, row+1, 1));
				default -> 0;
			};
		}
		return rgb[row][col];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("집의 갯수 : ");
		int N = sc.nextInt();		// 집의 갯수
		rgb = new int[N][3]; 		// rgb값을 담을 공간
		
		System.out.println("각 집마다 RGB값 입력(N*3)개 : ");
		for(int i=0 ; i<N; i++) {
			for(int j=0; j<3; j++) {
				rgb[i][j]= sc.nextInt();
			}
		}
		
		ArrayList<Integer> comList = new ArrayList<>();
		comList.add(combine(N-1, 0, 0));	// Red부터 시작하는 최소비용
		comList.add(combine(N-1, 0, 1));		// Green부터 시작하는 최소비용
		comList.add(combine(N-1, 0, 2));	// Blue부터 시작하는 최소비용
		System.out.println(comList);
		System.out.println("최소 비용 : " + Collections.min(comList));
	}

}
