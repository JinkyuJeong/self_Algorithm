
/*
 *  피보나찌 수열 
 */
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibo2(7));
	}
	
	static int fibo(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0); list.add(1);
		for(int i =2; i<=n ; i++) {
			list.add(list.get(i-2)+list.get(i-1));
		}
		return list.get(n);
	}
	
	static int fibo2(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibo2(n-2)+fibo2(n-1);
	}

}
