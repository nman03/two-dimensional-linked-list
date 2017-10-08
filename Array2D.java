package array2d;

public class Array2D<E> {
	int rows;
	int cols;
	Array2DNode<E> head;

	public Array2D() {
	}

	public Array2D(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;

		head = new Array2DNode<>();
		Array2DNode<E> current = head;
		Array2DNode<E> tmp = head;
		Array2DNode<E> tmpR = head;

		for (int i = 0 ; i < rows ; i++) {
			if (i != rows - 1) {
				current.down = new Array2DNode<>();
				tmp = current.down;
				tmpR = current.down;
			}	
			for (int j = 0 ; j < cols ; j++) {
				if (i == 0) {
					current.down = tmp;
					if (j != cols - 1) {
						current.right = new Array2DNode<>();
						tmp.right = new Array2DNode<>();
						current = current.right;
						tmp = tmp.right;
					}	
				} else {
					if (i != rows - 1) {
						current.down = tmp;			
						if (j != cols - 1) {
							tmp.right = new Array2DNode<>();
							current = current.right;
							tmp = tmp.right;
						}	
					}				
				}
			}
			if (i != rows - 1)
				current = tmpR;
		}

	}

	public Array2D(E[][] arr) {
		this.rows = arr.length;
		this.cols = arr[0].length;

		head = new Array2DNode<E>(arr[0][0]);
		Array2DNode<E> current = head;
		Array2DNode<E> tmp = head;
		Array2DNode<E> tmpR = head;

		for (int i = 0 ; i < rows; i++) {
			if (i != rows - 1) {
				current.down = new Array2DNode<E>(arr[i+1][0]);
				tmp = current.down;
				tmpR = current.down;
			}	
			for (int j = 0 ; j < cols; j++) {
				if (i == 0) {
					current.down = tmp;
					if (j != cols - 1) {
						current.right = new Array2DNode<E>(arr[i][j+1]);
						tmp.right = new Array2DNode<E>(arr[i+1][j+1]);
						current = current.right;
						tmp = tmp.right;
					}	

				} else {
					if (i != rows - 1) {
						current.down = tmp;			
						if (j != cols - 1) {
							tmp.right = new Array2DNode<E>(arr[i+1][j+1]);
							current = current.right;
							tmp = tmp.right;
						}	
					}						
				}
			}
			if (i != rows - 1)
				current = tmpR;
		}
	}

	public String toString() {
		return null;

	}

	public void addFirstCol() { 
		// Adds a new column to the beginning of the list. 
	}

	public void addFirstRow() {
		// Adds a new row to the beginning of the list. 
	}
	
	public void addLastCol() {
		// Adds a new column to the end of the list. 
	}
	
	public void addLastRow() {
		// Adds a new column to the end of the list. 
	}
	
	public void addCol(int colIndex) {
		// Inserts a column at the given index. (Insert here means the columns shift over by 1 from the insertion point onward). 
	}
	
	public void addRow(int rowIndex) {
		// Inserts a row at the given index. (Insert here means the rows shift over by 1 from the insertion point onward). 
	}
	
	public void deleteFirstCol() {
		// Removes the first column. 
	}
	
	public void deleteFirstRow() {
		// Removes the first row. 
	}
	
	public void deleteLastCol() {
		// Removes the last column. 
	}
	
	public void deleteLastRow() {
		// Removes the last row. 
	}
	
	public void deleteCol(int index) {
		// Removes the column at the given index. 
	}
	
	public void deleteRow(int index) {
		// Removes the row at the given index. get(row, col): Returns the item at the given (row, col).  NOTE: You must return the item stored in the Array2DNode, NOT the Array2DNode itself. 
	}
	
	public void getCol(int col) {
		// Returns the Array2DNode that starts the beginning of the requested column. 
	}
	
	public void getRow(int row) {
		// Returns the Array2DNode that starts the beginning of the requested row. 
	}
	
	public void set(int row, int col, E item) {
		// Assigns the given item to the Array2DNode at position (row, col). 
	}
	
	public void colSize() {
		// Returns the number of columns. 
	}
	
	public void rowSize() {
		// Returns the number of rows. to2DArray(): Converts this linked Array2D object into a normal 2D array.  You may not use this function to implement other functions in your Array2D class.  This function must create a local 2D array and return this array. 
	}
	
}
