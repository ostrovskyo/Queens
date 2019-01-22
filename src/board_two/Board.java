package board_two;

public class Board {
	
	private int boardSize;
	private int queensCount;
	private int solutionsCount;
	private int[][] board;
	Validation validate = new Validation();
	
	public Board(int boardSize, int queensCount) {
		this.boardSize = boardSize;
		this.queensCount = queensCount;
		board = new int[boardSize][boardSize];
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public int getSolutionsCount() {
		return solutionsCount;
	}
	
	
	public void findSolutions(int[][] board, int row) {
		if (row == queensCount) {
			printBoard(board);
			solutionsCount++;
			return;
		}
		
		for (int i = 0; i < boardSize; i++) {
			if (validate.checkCell(board, i, row)) {
				board[i][row] = 1;
				findSolutions(board, row + 1);
				board[i][row] = 0;
			}
		}
	}
	
	public void printBoard(int[][] board) {
		for(int j = 0; j < queensCount; j++) {
			for (int i = 0; i < queensCount; i++) {
				System.out.print("[" + board[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println();
	}

}
