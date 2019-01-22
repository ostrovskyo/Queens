package board_two;

public class Validation {
	
	public boolean checkCell(int[][] board, int column, int row) {
		
		for (int i = 0; i < row; i++) {
			if(board[column][i] == 1) {
				return false;
			}
		}
		
		for (int i = column, j = row; i < board.length && j >= 0; i++, j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		for (int i = column, j = row; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

}
