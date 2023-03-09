

import java.util.Scanner;

/*
국어, 영어, 수학, 물리, 화학, 사회, 컴퓨터 점수를  입력받은 후, 총점, 평균을 구하고 이들 모두에 대한 
막대그래프를 아래 조건에 맞게 그릴 수 있는 프로그램을 작성하시오.
(1) 국어, 영어, 수학, 물리, 화학, 사회, 컴퓨터 점수를 점수를 입력받은 후, 
   이에 대한 총점, 평균, 최대 점수, 최소 점수를 구한다. 
(2) 평균은 정수로 출력해야하며, 소수점은 모두 버린다. 
(3) 위에서 구한 점수들을 출력 후에는 이들 값을 기준으로모두 막대그래프로 표현한다.
과목별 점수와, 평균, 최대점수, 최소점수가 그래프를 그려야할 대상이며 막대그래프는 10 점 당 '*' 하나로 
대표하며, 10 의 단위이하의 자리숫자는 고려하지 않는다. 
[결과]
국어 영어 수학 물리 화학 사회 컴퓨터 점수를(1 - 100) 입력하세요
70 80 90 100 80 75 60
총합 :555
평균 :79
최대 :100
최소 :60
100	 	 	 	*	 	 	 	*	 	 
 90	 	 	*	*	 	 	 	*	 	 
 80	 	*	*	*	*	 	 	*	 	 
 70	*	*	*	*	*	*	 	*	 	*
 60	*	*	*	*	*	*	*	*	*	*
 50	*	*	*	*	*	*	*	*	*	*
 40	*	*	*	*	*	*	*	*	*	*
 30	*	*	*	*	*	*	*	*	*	*
 20	*	*	*	*	*	*	*	*	*	*
 10	*	*	*	*	*	*	*	*	*	*
	국어	영어	수학	물리	화학	사회	컴퓨터	최대	최소	평균	
 */
public class Graph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 영어 수학 물리 화학 사회 컴퓨터 점수를(1 - 100) 입력하세요");
		int [] score = new int[10];
		int sum=0;

		for(int i=0 ;i<score.length-3;i++) {
			score[i] = sc.nextInt();
			sum+=score[i];
		}
		int min=score[0], max=score[0];
		for(int i=1 ;i<score.length-3;i++) {
			if(max<score[i])
				max=score[i];
			if(min>score[i])
				min=score[i];
		}
		score[score.length-3] = max;
		score[score.length-2] = min;
		score[score.length-1] = sum/(score.length-3);
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+score[score.length-1]);
		System.out.println("최대 : " + score[score.length-3]);
		System.out.println("최소 : " + score[score.length-2]);

		String[][] printScore = new String[score.length][score.length+1];

		for(int i=0; i<printScore.length;i++) {
			printScore[i][0]=((10-i)*10)+"\t";
		}

		for(int i=0;i<score.length;i++) {
			score[i] /=10;
		}
		
		for(int i=printScore.length-1;i>=0;i--) {
			for(int j=printScore[i].length ; j>=2;j--) {
				if(score[i] >0) {
					printScore[j-2][i+1]="\t*\t";
					score[i]--;
				}
				else {
					printScore[j-2][i+1]="\t \t";
					score[i]--;
				}
			}
		}

		for(int i=0;i<printScore.length;i++) {
			for(int j=0 ; j<printScore[i].length;j++) {
				System.out.print(printScore[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("점수\t\t국어\t\t영어\t\t수학\t\t물리\t\t화학\t\t사회\t\t컴퓨터\t\t최대\t\t최소\t\t평균");

	}

}
