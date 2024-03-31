package ejercicio7;

import java.util.ArrayList;

public class Capicua {
    
    public static boolean esCapicua(ArrayList<Integer> lista){
        
        ArrayList<Integer> lista2 = new ArrayList<>();
        
        for(int i=lista.size()-1; i >= 0 ; i--){
           lista2.add(lista.get(i));
        }
        
        //lista.add(5);
        
        if(lista.equals(lista2)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        
        lista.add(1);
        lista.add(2);
        lista.add(1);
        
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);
        
        System.out.println(esCapicua(lista)); //capicua
        System.out.println(esCapicua(lista2));//No es capicua
        
    }
}