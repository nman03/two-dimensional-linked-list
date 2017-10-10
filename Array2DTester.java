package array2d;

public class Array2DTester {

	public static void main(String[] args) {
		Array2D<String> empty = new Array2D<>();
		System.out.println(empty.toString());
		
		Array2D<Character> nulls = new Array2D<>(2, 2);
		System.out.println(nulls.toString());
		
		Integer[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		Array2D<Integer> test = new Array2D<Integer>(arr);
		
		System.out.println(test.toString());
		System.out.println(test.colSize());
		
		test.addFirstCol();
		test.addCol(1);
		test.addLastCol();
		
		System.out.println(test.toString());
		
		test.addFirstRow();
		test.addRow(1);
		test.addLastRow();
		
		System.out.println(test.toString());
		
		test.deleteFirstCol();
		test.deleteFirstRow();
 		test.deleteLastCol();
		test.deleteCol(1);
		test.deleteRow(1);
		System.out.println(test.getCol(2).getItem());
		System.out.println(test.getRow(2).getItem());
		test.set(2, 2, 6);
			
		System.out.println(test.toString());
		
	}

}
