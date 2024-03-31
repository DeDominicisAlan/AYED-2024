package tp2.EDD;

import tp2.EDD.*;


public class BinaryTree<T> {
	private T data;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	
	public BinaryTree(){
		super();
	}
	
	public BinaryTree(T dato) {
		data = dato;
		leftChild = null;
		rightChild = null;
	}
	
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	
	public BinaryTree getLeftChild() {
		return leftChild;
	}

	public void addRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
	}

	public void addLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}
	
	public Boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
	
	public int contarHojas() {
		int contHI = 0; int contHD = 0;
		if(isLeaf()) {
			return 1;
		}else {
			if(hasLeftChild()) {
				contHI = this.getLeftChild().contarHojas();
			}
			if(hasRightChild()) {
				contHD = this.getRightChild().contarHojas();
			}
		}
		
		return contHI + contHD;
	}
	
	public BinaryTree<T> espejo(){
		if(this.isEmpty()) {
			return new BinaryTree<>();
		}else {
			BinaryTree<T> espejoAbb = new BinaryTree<>(this.getData());
			if(this.hasLeftChild()) {
				espejoAbb.addRightChild(this.getLeftChild().espejo());
			}
			if(this.hasRightChild()) {
				espejoAbb.addLeftChild(this.getRightChild().espejo());
			}
			return espejoAbb;
		}
	}
	
	public void entreNiveles() {
		BinaryTree<T> arbol = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			arbol = cola.dequeue();
			if(arbol !=null) {
				System.out.println(arbol.getData());
				if(arbol.hasLeftChild()) {
					cola.enqueue(arbol.getLeftChild());
				}
				if(arbol.hasRightChild()) {
					cola.enqueue(arbol.getRightChild());
				}
			}else if(!cola.isEmpty()) {
				System.out.println();
				cola.enqueue(null);
			}
		}
	}
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
}
