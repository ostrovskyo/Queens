package board;

public class Board {

	private int boardSize;
	private int queensCount;
	private int success = 0;
	private Cell[][] board;
	private int[][] boardHelper;
	

	public Board(int boardSize, int queensCount) {
		this.boardSize = boardSize;
		this.queensCount = queensCount;
		board = new Cell[boardSize][boardSize];
		boardHelper = new int[boardSize][boardSize];
		createBoard();
	}
	
	public int getSuccess() {
		return success;
	}

	private void createBoard() {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				board[x][y] = new Cell(x, y);
				boardHelper[x][y] = 0;
			}
		}
	}

	private void clearBoard() {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				board[x][y].setCellStatus(0);
				boardHelper[x][y] = 0;
			}
		}
	}

	public void start() {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (boardHelper[x][y] == 0) {
					setQueen(x, y);
					setQueens();
				}
			}
		}
	}

	private void setQueens() {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (boardHelper[x][y] == 0) {
					setQueen(x, y);
				}
			}
		}

		if (checkQueensCount() >= queensCount) {
			printBoard();
			success++;
		}
		clearBoard();
	}

	private void setQueen(int x, int y) {
		board[x][y].setCellStatus(1);
		boardHelper[x][y] = 1;
		updateBoard(x, y);
	}

	private int checkQueensCount() {
		int queensCount = 0;
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (board[x][y].getCellStatus() == 1) {
					queensCount++;
				}
			}
		}
		return queensCount;
	}

	private void updateBoard(int xTemp, int yTemp) {
		updateLinear(xTemp, yTemp);
		markRightDown(xTemp, yTemp);
		markLeftUp(xTemp, yTemp);
		markLeftDown(xTemp, yTemp);
		markRigthUp(xTemp, yTemp);
	}

	private void updateLinear(int xTemp, int yTemp) {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if ((x == xTemp || y == yTemp) && !(x == xTemp && y == yTemp)) {
					boardHelper[x][y] = 2;
				}
			}
		}
	}

	private void markRightDown(int xTemp, int yTemp) {
		while (xTemp < boardSize - 1 && yTemp < boardSize - 1) {
			xTemp++;
			yTemp++;
			boardHelper[xTemp][yTemp] = 2;
		}
	}

	private void markLeftUp(int xTemp, int yTemp) {
		while (xTemp > 0 && yTemp > 0) {
			xTemp--;
			yTemp--;
			boardHelper[xTemp][yTemp] = 2;
		}
	}

	private void markLeftDown(int xTemp, int yTemp) {
		while (xTemp > 0 && yTemp < boardSize - 1) {
			xTemp--;
			yTemp++;
			boardHelper[xTemp][yTemp] = 2;
		}
	}

	private void markRigthUp(int xTemp, int yTemp) {
		while (xTemp < boardSize - 1 && yTemp > 0) {
			xTemp++;
			yTemp--;
			boardHelper[xTemp][yTemp] = 2;
		}
	}

	public void printBoard() {
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				System.out.print(board[x][y]);
			}
			System.out.println();
		}
	}

}
