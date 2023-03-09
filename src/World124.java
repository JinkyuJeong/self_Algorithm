


public class World124 {
	public static void main(String[] args) {
		System.out.println("1 :" + solution(1));
		System.out.println("2 :" + solution(2));
		System.out.println("3 :" + solution(3));
		System.out.println("4 :" + solution(4));
		System.out.println("5 :" + solution(5));
		System.out.println("6 :" + solution(6));
		System.out.println("7 :" + solution(7));
		System.out.println("8 :" + solution(8));
		System.out.println("9 :" + solution(9));
		System.out.println("10 :" + solution(10));
		System.out.println("11 :" + solution(11));
		System.out.println("12 :" + solution(12));
		System.out.println("13 :" + solution(13));
		System.out.println("14 :" + solution(14));
		System.out.println("15 :" + solution(15));
		System.out.println("16 :" + solution(16));
		System.out.println("17 :" + solution(17));
		System.out.println("18 :" + solution(18));

	}
	
	private static String solution(int num) {
		StringBuffer sb = new StringBuffer();
		while(num>0) {
			if(num%3==0) {
				sb.insert(0, 4);
				num= (int)(num/3.00000001);
				continue;
			}
			switch(num%3) {
				case 1 : sb.insert(0, 1); break;
				case 2 : sb.insert(0, 2); break;
			}
			num/=3;
		}
		return sb.toString();
	}
}
