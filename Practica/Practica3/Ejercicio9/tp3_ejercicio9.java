package tp3;

public class tp3_ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(1);
		arbol.addChildNode(new GeneralTree<Integer>(1));
		arbol.addChildNode(new GeneralTree<Integer>(0));
		
		
		
		GeneralTree<Integer> arbol12Aux = new GeneralTree<Integer>(1);
		arbol12Aux.addChildNode(new GeneralTree<Integer>(0));
		arbol12Aux.addChildNode(new GeneralTree<Integer>(0));
		
		arbol.getChildren().get(1).addChildNode(new GeneralTree<Integer>(1));
		
		arbol.getChildren().get(0).addChildNode(arbol12Aux);
		
		GeneralTree<Integer> arbol33 = new GeneralTree<Integer>(1);
		arbol33.addChildNode(new GeneralTree<Integer>(1));
		arbol33.addChildNode(new GeneralTree<Integer>(1));
		arbol33.addChildNode(new GeneralTree<Integer>(0));
		arbol33.addChildNode(new GeneralTree<Integer>(0));
		
		arbol12Aux.addChildNode(arbol33);
		
		arbol.PorNiveles();
		
		ParcialArboles parcial = new ParcialArboles(arbol);
		System.out.println(parcial.esDeSeleccion());
		
		arbol33.addChildNode(new GeneralTree<Integer>(1));
		System.out.println(parcial.esDeSeleccion());
		//parcial.PorNiveles();
	}

}
