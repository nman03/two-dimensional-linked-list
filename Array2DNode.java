package array2d;

public class Array2DNode<E> {
	private E item;
	protected Array2DNode<E> down;
	protected Array2DNode<E> right;
	
	public Array2DNode() {
	}
	
	public Array2DNode(E item) {
		this.item = item;
	}
	
	public E getItem() {
		return item;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
}
