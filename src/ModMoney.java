/*어떤 가게의 욕심쟁이 점원은 거스름돈을 나눠줄때 거스름돈의 개수를 적게해서 주고자 한다.
거스름돈을 입력 받아 점원이 줄 수 있는 최소 거스름돈의 개수를 출력하시오.
예를 들어 54520원인 경우,
거스름돈으로 50000원권 1장, 1000원권 4장, 500원 1개, 10원 2개 해서 총 8개이다.

<입력예시>
54520
<출력예시>
8
*/
public class ModMoney {
	private static int solution(int money) {
		int answer = 0;
		int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int i=0; i<m.length; i++) {
			answer+=money/m[i];
			money%=m[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(40010));
	}

}
