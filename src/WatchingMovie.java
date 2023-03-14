import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*극장에 n개의 빈 좌석이 있다. 
k명의 관객들이 영화를 보기 위해서 왔다. 
이 관객들이 n개의 좌석에 앉을 수 있는 서로 다른 방법의 수를 구하는 프로그램을 작성하시오. 
(단, k명의 사람을 서로 구분하지 않으며, 한 명이 좌석에 앉으면 그 양 옆자리는 비어 있도록 배치해야 한다.)

첫 번재 줄에 n 과 k 가 공백으로 구분되어 입력된다.

<입력예시>
4 2

<출력예시>
3

*/
public class WatchingMovie {
	private static int cnt = 0;
	private static ArrayList<int[]> list = new ArrayList<>();
	
	private static void combine(int[] n, int k, boolean[] checked, int start) {
		if(cnt==k) {
			list.add(Arrays.copyOf(n, n.length));
			return;
		}
		
		for(int i=start; i<n.length; i++) {
			if(!checked[i]) {
				checked[i] = true;
				cnt++;
				n[i]=1;
				combine(n, k, checked, i+1);
				checked[i] = false;
				cnt--;
				n[i]=0; 
			}
		}
	}

	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("좌석 n개와 사람 k명을 입력해주세요.");
		int[] n = new int[sc.nextInt()];
		int k = sc.nextInt();
		boolean[] checked = new boolean[n.length];
		combine(n, k, checked, 0);
		for(int [] arr: list) {
			int[] temp = new int[n.length+2];
			for(int i=1; i<=n.length; i++) 
				temp[i] = arr[i-1];
			for(int i=1; i<=n.length; i++) {
				if(temp[i]==1) {
					if(temp[i-1] == 1 || temp[i+1] == 1) break;
				}
				if(i==n.length) answer++;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(answer);
	}

}
