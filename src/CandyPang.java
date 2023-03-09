

import java.util.Arrays;

/*
캔디팡은 7 * 7 모양의 격자 판에 같은 색깔이 연속 3개 이상인 부분을 찾아 터치하면 터지면서 점수를 얻는 게임이다. 
이때 연속된 부분은 상, 하, 좌, 우만 판단한다.
캔디팡 격자 정보가 주어졌을 때 터치하면 터지는 영역의 개수를 출력하는 프로그램을 작성하시오.

※ 색깔정보
빨강 = 1 , 노랑 = 2 , 파랑 = 3 , 초록 = 4 , 보라 = 5

입력 예시   
2	1 	5 	1 	1 	3 	4
2	1 	5 	1 	3 	5 	3
2 	3 	4 	5 	2 	2 	4
4 	4 	3 	2 	3 	1 	3
4 	3 	5 	3 	1 	4 	3
5 	4 	4 	3 	3 	5 	5
2 	1 	3 	5 	1 	1 	2



-
출력 예시
=>4
 */
public class CandyPang {

	public static void main(String[] args) {
		System.out.println ("=>"+solution(new int[][] { 
			{ 2, 1, 5, 1, 1, 3, 4 }, 
			{ 2, 1, 5, 1, 3, 5, 3},  
			{ 2, 3, 4, 5, 2, 2, 4},
			{ 4, 4, 3, 2, 3, 1, 3}, 
			{ 4, 3, 5, 3, 1, 4, 3}, 
			{ 5, 4, 4, 3, 3, 5, 5 },
			{ 2, 1, 3, 5, 1, 1, 2}  }));
	}

	static int solution(int[][] candy) {
		int cnt = 1, tCnt=0;
		int[][] one = new int[9][9];
		for(int i=0; i<candy.length; i++) {
			for(int j=0; j<candy[i].length; j++) {
				one[i+1][j+1] = candy[i][j];
			}
		}
		for(int [] arr : one) {
			System.out.println(Arrays.toString(arr));
		}
		for(int i=1 ; i<one.length -1 ; i++) {
			for(int j=1 ; j<one[i].length -1 ; j++) {
				if(one[i][j] == one[i-1][j]) cnt++;
				if(one[i][j] == one[i+1][j]) cnt++;
				if(one[i][j] == one[i][j-1]) cnt++;
				if(one[i][j] == one[i][j+1]) cnt++;
				
				if(cnt >=3) {
					tCnt++;
					cnt=1;
				}else cnt=1;
			}
		}
		return tCnt;
	}
}
