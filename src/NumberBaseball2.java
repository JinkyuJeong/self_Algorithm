

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/*
 * 숫자 맞추기 게임
 * 시스템이 4자리의 서로 다른 수를 저장한 후 사용자가 저장된 수를 맞추는 게임
 *    자리수도 맞는 경우 : 스트라익
 *    자리수는 틀리지만 숫자가 존재하면 : 볼
 *  4스트라익이 되면 정답
 *  알고리즘
 *  1. 시스템의 수를 지정 (Random함수 사용) 중복 되지 안도록 4자리 수 지정하기 (0~9)
 *  2. 화면으로 부터 4자리 정수를 입력
 *  3. 시스템의 수와 입력된 수를 비교하여 스트라익, 볼을 결정, 화면 출력
 *  4. 4스트라익이 될때 까지 2,3 을 계속 실행  
 *  5. 정답인 된경우 몇번만에 정답을 맞췄는지 입력 갯수를 화면에 출력하기
 */
public class NumberBaseball2 {
	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<>();
		while(set.size()!=4) {
			set.add((int)(Math.random()*9));
		}
		ArrayList<Integer> sysNum = new ArrayList<>(set);
		set.clear();
		System.out.println("[확인용] 시스템 숫자 : "+sysNum);
		
		ArrayList<Integer> userNum = null;
		Scanner sc = new Scanner(System.in);
		int ball=0, strike=0, cnt=0;
		while(strike != 4) {
			ball=0; strike=0;
			System.out.print("4자리 정수를 입력하세요 : ");
			int num = sc.nextInt();
			for(int i=0; i<4; i++) {
				set.add(num%10);
				num/=10;
			}
			
			if(set.size() !=4) {
				System.out.println("[경고] 입력숫자에 중복이 있습니다. 다시 입력하세요");
				cnt++; set.clear();
				continue;
			}else userNum = new ArrayList<>(set);
			
			Collections.reverse(userNum);
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(sysNum.get(i)==userNum.get(j)) {
						if(i==j) strike++;
						else ball++;
					}
				}
			}
			
			System.out.println(strike+"스트라이크"+ball+"볼");
			userNum.clear(); set.clear();
			cnt++;
		}
		
		System.out.println("\n[결과] "+cnt+"번 만에 맞춤");
	}

}
