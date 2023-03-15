import java.util.Scanner;

/*
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력							출력
3								3
happy
new
year

4								1
aba
abab
abcabc
a

5								4
ab
aa
aca
ba
bb

2								0
yzyzy
zyzyz

1								1
z
*/
public class GroupChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] word = new String[n];
		for(int i=0 ;i<word.length; i++) {
			word[i]=sc.next();
		}
		
		for(int i=0; i<word.length; i++) {
			char ch = word[i].charAt(0);
			boolean[] checked = new boolean[26];
			checked[(int)ch-97] = true;
			for(int j=1; j<word[i].length(); j++) {
				ch = word[i].charAt(j);
				if(ch == word[i].charAt(j-1)) continue;
				
				if(checked[(int)ch-97]) {
					n--;
					break;
				}
				
				checked[(int)ch-97] = true;
			}
		}
		
		System.out.println(n);
		
		
	}
}
