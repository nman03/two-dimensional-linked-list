package array2d;

public class Array2D<E> {
	private int rows;
	private int cols;
	private Array2DNode<E> head;

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
		if (head == null)
			return null;
		
		String st = "";
		Array2DNode<E> current = head;
		Array2DNode<E> tmp = head;
		
		for (int i = 0 ; i < rows ; i++) {
			for (int j = 0 ; j < cols ; j++) {
				st += String.valueOf(current.getItem()) + " ";
				current = current.right;
			}
			if (i < rows - 1)
				tmp = tmp.down;
			
			current = tmp;
			st += "\n";
		}
		
		return st;

	}

	public void addFirstCol() { 
		Array2DNode<E> current = new Array2DNode<>();
		Array2DNode<E> tmp = head;
		head = current;
		cols++;
		
		for (int i = 0 ; i < rows ; i++) {
			if (i < rows - 1) 
				current.down = new Array2DNode<>();		
			
			current.right = tmp;
			current = current.down;
			tmp = tmp.down;
		}	
	}

	public void addFirstRow() {
		Array2DNode<E> current = new Array2DNode<>();
		Array2DNode<E> tmp = head;
		head = current;
		rows++;
		
		for (int i = 0 ; i < cols ; i++) {
			if (i < cols - 1) 
				current.right = new Array2DNode<>();		
			
			current.down = tmp;
			current = current.right;
			tmp = tmp.right;
		}
	}

	public void addLastCol() {
		Array2DNode<E> current = new Array2DNode<>();
		Array2DNode<E> tmp = head;
		
		for (int k = 1 ; k < cols ; k++)
			tmp = tmp.right; 
		
		for (int i = 0 ; i < rows ; i++) {
			if (i < rows - 1) 
				current.down = new Array2DNode<>();		
			
			tmp.right = current;
			current = current.down;
			tmp = tmp.down;
		}
		
		cols++;
	}

	public void addLastRow() {
		Array2DNode<E> current = new Array2DNode<>();
		Array2DNode<E> tmp = head;
		
		for (int k = 1 ; k < rows ; k++)
			tmp = tmp.down; 
		
		for (int i = 0 ; i < cols ; i++) {
			if (i < cols - 1) 
				current.right = new Array2DNode<>();		
			
			tmp.down = current;
			current = current.right;
			tmp = tmp.right;
		}
		
		rows++;
	}

	public void addCol(int colIndex) {	
		if (colIndex > cols || colIndex < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");
		
		if (colIndex == 0) {
			addFirstCol();
		} else if (colIndex == cols) {
			addLastCol();
		} else {	
			Array2DNode<E> current = new Array2DNode<>();
			Array2DNode<E> prevCol = head;
			Array2DNode<E> nextCol = head;
			
			for (int k = 0 ; k < colIndex ; k++) {
				if (k < colIndex - 1) 
					prevCol = prevCol.right;
				nextCol = nextCol.right;
			}	
			
			for (int i = 0 ; i < rows ; i++) {
				if (i < rows - 1) 
					current.down = new Array2DNode<>();		
				
				prevCol.right = current;
				current.right = nextCol;
				current = current.down;
				prevCol = prevCol.down;
				nextCol = nextCol.down;
			}
			
			cols++;
		}
				
	}

	public void addRow(int rowIndex) {
		if (rowIndex > rows || rowIndex < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");	
		
		
		if (rowIndex == 0) {
			addFirstRow();
		} else if (rowIndex == rows) {
			addLastRow();
		} else {	
			Array2DNode<E> current = new Array2DNode<>();
			Array2DNode<E> prevRow = head;
			Array2DNode<E> nextRow = head;
			
			for (int k = 0 ; k < rowIndex ; k++) {
				if (k < rowIndex - 1) 
					prevRow = prevRow.down;
				nextRow = nextRow.down;
			}	
			
			for (int i = 0 ; i < cols ; i++) {
				if (i < cols - 1) 
					current.right = new Array2DNode<>();		
				
				prevRow.down = current;
				current.down = nextRow;
				current = current.right;
				prevRow = prevRow.right;
				nextRow = nextRow.right;
			}
			
			rows++;
		}		 
	}

	public void deleteFirstCol() {
		if (head.right != null) 
			head = head.right;
		else 
			head = null;
		
		
		cols--;
	}

	public void deleteFirstRow() {
		if (head.down != null)
			head = head.down;
		else 
			head = null;
		
		rows--;
	}

	public void deleteLastCol() {
		Array2DNode<E> current = head;
		
		for (int k = 1 ; k < cols - 1 ; k++) 
			current = current.right;
			
		
		for (int i = 0 ; i < rows ; i++) {	
			current.right = null;
			
			if (i < rows - 1) 
				current = current.down;		
		}
		
		cols--;
	}

	public void deleteLastRow() {
		Array2DNode<E> current = head;
				
		for (int k = 1 ; k < rows - 1 ; k++) 
			current = current.down;
				
		for (int i = 0 ; i < cols ; i++) {	
			current.down = null;
			
			if (i < cols - 1) 
				current = current.right;		
		}
		
		rows--;
	}

	public void deleteCol(int index) {
		if (index >= cols || index < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");	
		
		if (index == 0)
			deleteFirstCol();
		else if(index == cols - 1)
			deleteLastCol();
		else {
			Array2DNode<E> current = head;
			Array2DNode<E> nextCol = head;
			
			for (int k = 0 ; k < index + 1 ; k++) {
				if (k < index - 2)
					current = current.right;
				
				nextCol = nextCol.right;
			}
				
			for (int i = 0 ; i < rows ; i++) {
				current.right = nextCol;
				
				if (i < rows - 1) {
					current = current.down;
					nextCol = nextCol.down;
				}		
			}
			
			cols--;
		}
			
	}

	public void deleteRow(int index) {
		if (index >= rows|| index < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");	
		
		if (index == 0)
			deleteFirstRow();
		else if(index == rows- 1)
			deleteLastRow();
		else {
			Array2DNode<E> current = head;
			Array2DNode<E> nextRow = head;
			
			for (int k = 0 ; k < index + 1 ; k++) {
				if (k < index - 2)
					current = current.down;
				
				nextRow = nextRow.down;
			}
				
			for (int i = 0 ; i < cols ; i++) {
				current.down = nextRow;
				
				if (i < cols - 1) {
					current = current.right;
					nextRow = nextRow.right;
				}		
			}
			
			rows--;
		}
	}

	public Array2DNode<E> getCol(int col) {
		if (col >= cols|| col < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");	
		
		Array2DNode<E> current = head;
		
		for (int j = 0 ; j < col ; j++)
			current = current.right;
		
		return current;
		
	}

	public Array2DNode<E> getRow(int row) {
		if (row >= rows|| row < 0)
			throw new IndexOutOfBoundsException("Out of Bounds");	
		
		Array2DNode<E> current = head;
		
		for (int j = 0 ; j < row ; j++)
			current = current.down;
		
		return current;
	}

	public void set(int row, int col, E item) {
		Array2DNode<E> current = head;
		
		for (int i = 0 ; i < row ; i++) 
			current = current.down;
		
		for (int j = 0 ; j < col ; j++)
			current = current.right;	
		
		current.setItem(item);
	}

	public int colSize() {
		return cols;
	}

	public int rowSize() {
		return rows;
	}
	
//	public E[][] to2DArray() {		
//		E[][] arr = (E[][]) new Object[rows][cols];
//		
//		Array2DNode<E> current = head;
//		Array2DNode<E> tmpR = head;
//		
//		for (int i = 0 ; i < rows ; i++) {
//			current = tmpR;
//			for (int j = 0 ; j < cols ; j++) {
//				arr[i][j] = current.getItem();
//				
//				if (j < cols -1)
//					current = current.right;
//			}
//			if (i < rows - 1)
//				tmpR = tmpR.down;
//		}	
//				
//		return arr;
//	}
}
