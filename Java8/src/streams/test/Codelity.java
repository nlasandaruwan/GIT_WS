package streams.test;

import java.util.Collections;
import java.util.stream.Stream;

public class Codelity {

	public static void main(String[] args) {
	
		System.out.println(solution(new int[] {-2,2,4,-1,3}));
		
		inverter("Sandaruwan");
	}
	
	static String inverter(String toInvert){
		
		if (toInvert == null || toInvert.equals("")){
			
			return "";
		}
		else {
			
//			toInvert.codePoints().mapToObj( c -> String.valueOf((char) c)).map(a -> ).forEach(System.out::print); ;
		}
		return null;
	}
	
	static int solution(int[] a) {

		int ans = 0;

		for (int i = 0; i < a.length; i++)

			if (ans > a[i]) {
				ans = a[i];
			}
		return ans;
	}
}
