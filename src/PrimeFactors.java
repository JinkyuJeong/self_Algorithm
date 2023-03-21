import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactors {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 2; i <= Math.sqrt(N); i++) {	// 또는 i * i <= N
			while(N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		 
		if(N != 1) {
			System.out.println(N);
		}
		
	}

}
