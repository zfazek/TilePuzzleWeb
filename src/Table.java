import static java.lang.Math.abs;
import static java.lang.Math.random;

class Table {

	private int nofMoves = 1;
	private int size = 0;
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 10;
	private static final int DEFAULT_SIZE = 3;
	private int[][] table = new int[MAX_SIZE][MAX_SIZE];

	public int getDefaultSize() { return DEFAULT_SIZE; }
	public int getSize() { return size; }
	public int getMaxSize() { return MAX_SIZE; }
	public int getNofMoves() { return nofMoves; }
	public void resetNofMoves() { nofMoves = 1; }
	public int[][] getTable() { return table; }

	public boolean isDone() {
		int[][] newTable = new int[size][size];
		resetTable(newTable);
		for (int i = 0; i < size; i++) 
			for (int j = 0; j < size; j++)
				if (table[i][j] != newTable[i][j]) return false;
		return true;
	}

	public void setSize(int newSize) {
		if (newSize < MIN_SIZE || newSize > MAX_SIZE) {
			size = DEFAULT_SIZE;
		} else {
			size = newSize;

		}
		resetTable(table);
	}

	public void swap(int coord) {
		if (isLegalMove(coord) == false) return;
		int holeIdx = getHoleIdx();
		table[holeIdx / size][holeIdx % size] = 
				table[coord / size][coord % size];
		table[coord / size][coord % size] = 0;
		nofMoves++;
	}

	public void shuffle() {
		int n = 10000;
		for (int i = 0; i < n; i++) {
			swap((int)(random()*size*size));
		}
	}

	private void resetTable(int[][] table) {
		int x = 1;
		for (int i = 0; i < size; i++) 
			for (int j = 0; j < size; j++) {
				table[i][j] = x++;
				//    			if (x == ':') x = 'A';
			}
		table[size - 1][size - 1] = 0;
	}

	private int getHoleIdx() {
		for (int i = 0; i < size; i++) 
			for (int j = 0; j < size; j++)
				if (table[i][j] == 0) 
					return i * size + j;
		return -1;
	}

	private boolean isLegalMove(int coord) {
		if (coord > size * size - 1) return false;
		int holeIdx = getHoleIdx();
		if (holeIdx == -1) return false;
		if (abs(holeIdx - coord) == size) return true;
		if (holeIdx % size == 0 && coord - holeIdx == 1) return true;
		if (holeIdx % size == size - 1 && coord - holeIdx == -1) return true;
		if (holeIdx % size > 0 && holeIdx % size < size - 1 && 
				abs(holeIdx - coord) == 1) return true;
		return false;
	}
}
