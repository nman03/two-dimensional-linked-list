package array2d;

public class Array2DTester {

	public static void main(String[] args) {
		
		Array2D<Integer> test = new Array2D<Integer>(3, 3);
		Array2DNode<Integer> a = test.head;
//		Integer[][] arr = {{1,2,3}, {4,5,6}};
//		Array2D<Integer> test = new Array2D<Integer>(arr);
//		
		
//		System.out.println(a.getItem());
//		System.out.println(a.right.getItem());
//		System.out.println(a.right.right.getItem());
//		System.out.println(a.down.getItem());
//		System.out.println(a.down.right.getItem());
//		System.out.println(a.down.right.right.getItem());
//		System.out.println(a.right.down.getItem());
//		System.out.println(a.right.right.down.getItem());
//		System.out.println(a.right.right.right.getItem());
//		System.out.println(a.down.down.getItem());
//		
		System.out.println(a);
		System.out.println(a.right);
		System.out.println(a.right.right);
		System.out.println(a.down);
		System.out.println(a.down.down);
		System.out.println(a.down.right);
		System.out.println(a.down.right.right);
		System.out.println(a.right.down);
		System.out.println(a.right.right.down);
		System.out.println(a.down.down.right);
		System.out.println(a.down.right.right.down);
		System.out.println(a.right.down.down);
		System.out.println(a.right.right.down.down);
		System.out.println(a.right.down.right.down);
		System.out.println(a.right.right.right);
		
		
		
		

	}

}
