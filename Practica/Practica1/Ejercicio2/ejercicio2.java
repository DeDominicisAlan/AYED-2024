package ejercicio2;

import java.util.Scanner;

public class ejercicio2 {

	public static int[] multiplos(int n) {
		int[] vector = new int[n];
		
		for (int i = 0 ; i < n ; i ++) {
			vector[i] = n * (i+1);
			
		}
		
		return vector;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		for(int n: multiplos(s.nextInt())) {
			System.out.println(n);
		}
	}

}
