package ejercicio5;

public class ejercicio5 {

	public static int[] devolverA(int[] array, int[] array2) {
		
		for(int n: array){
			
			if(n > array2[0]) {
				array2[0] = n;
			} 
			
			if(n < array2[1]){
				array2[1] = n;
			}
			array2[2] += n;
		}
		
		array2[2] /= array.length;
		return array2;
	}
	
	public static void devolverC(int[] array, Valor valor) {
		valor.buscarMaximo(array);
		valor.buscarMinimo(array);
		valor.buscarPromedio(array);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,4,6,8};
		
		int[] array2 = {0,999,0};
		
		devolverA(array, array2);
		for(int n: array2) {
			System.out.print(n + " ");
		}
		
		Valor valor = new Valor();
		devolverC(array, valor);
		System.out.println(valor);
	}

}
