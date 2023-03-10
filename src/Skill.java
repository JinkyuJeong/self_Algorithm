/* 완료
스킬트리
문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 
썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 
라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 
skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 
solution 함수를 작성해주세요.
제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 2 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
입출력 예
skill			skill_trees	          			return
CBD	[BACDE, CBADF, AECB, BDA]	  2
입출력 예 설명
BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
CBADF: 가능한 스킬트리입니다.
AECB: 가능한 스킬트리입니다.
BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
스킬 트리: 유저가 스킬을 배울 순서  */
public class Skill {
	/*
	 * solution 메서드에서 코드의 중복이 일어났기 때문에
	 * checked 라는 boolean타입의 배열 변수와 comp라는 메서드로 따로 뺐음.
	 * checked의 인덱스는 나열된 스킬커맨드의 인덱스와 일치시킴
	 * 
	 *  < My로직 >
	 *  	1. 처음 스킬이 없으면 아무것도 배울 수 없기 때문에 조건을 주었다.
	 *  	2. 첫 스킬이 없는데 나머지 스킬이 들어가 있으면 안되기 때문에 checked를 true로 하고 다음 스킬 커맨드로 넘어갔다.
	 *  	2-1. 만약 나머지 스킬 마저 안 들어가있으면 상관없기 때문에 가능한 스킬트리로 인식하였다.
	 *  	3. 그 후 answer++로 가능한 스킬트리 수를 체크하여 리턴
	 * */
	private static boolean[] checked = new boolean[1000];	
	private static void comp(char[] ch1, char[] ch2, int select) {
		for(int i=0; i<ch1.length; i++) {
			for(int j=0; j<ch2.length; j++) {
				if(ch1[i] == ch2[j]) {
					checked[select] = true;
					return;
				}
			}
		}
	}

	static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		char[] ch = skill.toCharArray();

		for(int i=0; i<skill_trees.length; i++) {
			if(skill_trees[i].indexOf(skill.charAt(0)) == -1){
				char[] ch2 = skill_trees[i].toCharArray();
				comp(ch, ch2, i);
			}else {
				char[] ch3 = skill_trees[i].substring(0, skill_trees[i].indexOf(skill.charAt(0))).toCharArray();
				comp(ch, ch3, i);
			}
			
			if(!checked[i]) {
				System.out.println(skill_trees[i]);
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println
		("결과:" + solution
				("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}
}
