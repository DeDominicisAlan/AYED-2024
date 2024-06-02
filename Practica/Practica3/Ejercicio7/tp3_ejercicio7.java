package tp3;

import java.util.LinkedList;
import java.util.List;

public class tp3_ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2);
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3);
		List<GeneralTree<Integer>> childs= new LinkedList<GeneralTree<Integer>>();
		childs.add(a1);
		childs.add(a2);
		childs.add(a3);
		GeneralTree<Integer> a4 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> a5 = new GeneralTree<Integer>(5);
		GeneralTree<Integer> a6 = new GeneralTree<Integer>(6);
		GeneralTree<Integer> a7 = new GeneralTree<Integer>(7);
		a1.addChildNode(a4);
		a1.addChildNode(a5);
		a1.addChildNode(a6);
		a2.addChildNode(a7);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childs);
		GeneralTree<Integer> a8 = new GeneralTree<Integer>(8);
		a7.addChildNode(a8);
		a3.addChildNode(new GeneralTree<Integer>(10));
		a.PorNiveles();
		
		Caminos camino = new Caminos(a);
		List<Integer> lista = camino.caminoAHojaMasLejana();
		System.out.println(lista);
		
		camino.Hojas();
	}

}
