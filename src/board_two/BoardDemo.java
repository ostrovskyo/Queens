package board_two;

public class BoardDemo {
	
	public static void main(String[] args) {
		
		Board board = new Board(8, 8);
		board.findSolutions(board.getBoard(), 0);
		System.out.println("Solutions found: " + board.getSolutionsCount());
	}
}
