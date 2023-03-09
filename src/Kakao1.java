

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kakao1 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc")); //7
		System.out.println(solution("ababcdcdababcdcd"));//9
		System.out.println(solution("abcabcdede"));	//8	
		System.out.println(solution("abcabcabcabcdededededede"));//14		
		System.out.println(solution("xababcdcdababcdcd"));//17
	}

	static int solution(String s) {
		StringBuffer sb = new StringBuffer();
		int half = s.length()/2;
		int cnt=1,cut=2;
		String[] arr;
		List<Integer> list = new ArrayList<>();
		for(int i=1 ; i<=half ;i++) {
			arr = s.split("(?<=\\G.{" + i + "})");
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j].equals(arr[j+1])) {
					cnt++;
					if(cnt==2) {
						sb.append(cnt+arr[j]);
					}
					else{
						sb.delete(sb.length()-cut, sb.length());
						sb.append(cnt+arr[j]);
					}
				}else {
					cnt=1;
					if(j>0) {
						if(!arr[j-1].equals(arr[j]) && !arr[j].equals(arr[j+1]))
							sb.append(arr[j]);
					}else {
						sb.append(arr[j]);
					}
					if(j==arr.length-2)
						sb.append(arr[j+1]);
				}
			}
			list.add(sb.length());
			sb.delete(0, sb.length());
			cut++; cnt=1;
		}
		return (int)Collections.min(list);
	}
}
