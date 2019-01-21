package board;

public class BoardDemo {

	public static void main(String[] args) {
		Board board = new Board(8,8);
		board.start();
		System.out.println("Found solutions: " + board.getSuccess());
	}
}
