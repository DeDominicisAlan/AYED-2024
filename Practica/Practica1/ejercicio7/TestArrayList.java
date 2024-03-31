package ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		ArrayList<Integer> lista= new ArrayList<>();
		
		for(int i=0; i < args.length; i++) {
			lista.add(Integer.parseInt(args[i]));
		}
		
		System.out.println(lista.toString());
		
	
        //5701465400
        //5014259200
        
	}

}
