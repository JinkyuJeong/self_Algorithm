/*컴퓨터실에서 수업 중인 정보 선생님은 냉난방기의 온도를 조절하려고 한다.
냉난방기가 멀리 있어서 리모컨으로 조작하려고 하는데, 리모컨의 온도 조절 버튼은 다음과 같다.

1) 온도를 1도 올리는 버튼
2) 온도를 1도 내리는 버튼
3) 온도를 5도 올리는 버튼
4) 온도를 5도 내리는 버튼
5) 온도를 10도 올리는 버튼
6) 온도를 10도 내리는 버튼

이와 같이 총 6개의 버튼으로 목표 온도를 조절해야 한다.
현재 설정 온도와 변경하고자하는 목표 온도가 주어지면 이 버튼들을 이용하여 목표 온도로 변경하고자 한다.
이 때 버튼 누름의 최소 횟수를 구하시오.
예를 들어, 7도에서 34도로 변경하는 경우,
7 -> 17 -> 27 -> 32 -> 33 -> 34
이렇게 총 5번 누르면 된다.

현재 온도a 와 목표 온도b가 입력된다. ( 0 <= a , b <= 40 )

<입력예시>
7 34
<출력예시>
5
 */
public class RemoteControl {
	private static int solution(int a, int b) {
		int answer = 0;
		int diff = Math.abs(b-a);

		if(diff>=10) {
			while(diff>=10) {
				diff-=10;
				answer++;
			}
		}

		if(diff>=5) {
			if(diff%5 >= 3) {
				diff-=10;
				diff = Math.abs(diff);
				answer++;
			}
			while(diff>=5) {
				diff-=5;
				answer++;
			}
		}

		if(diff>=1) {
			if(diff%5 >= 3) {
				diff-=5;
				answer++;
				while(diff!=0) {
					diff+=1;
					answer++;
				}
			}else {
				while(diff>=1) {
					diff-=1;
					answer++;
				}
			}
		}



		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(15, 23));
	}

}
