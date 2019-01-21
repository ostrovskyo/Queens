package board;

public class Cell {
	
	private int cellStatus = 0;
	private int cellX;
	private int cellY;

	public Cell(int x, int y) {
		cellX = x;
		cellY = y;
	}
	
	public int getCellX() {
		return cellX;
	}

	public int getCellY() {
		return cellY;
	}

	public int getCellStatus() {
		return cellStatus;
	}

	public void setCellStatus(int cellStatus) {
		this.cellStatus = cellStatus;
	}

	@Override
	public String toString() {
		return "[" + cellStatus + "]";
	}

}
