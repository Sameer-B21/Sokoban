package sokoban;

/**
 * A class that represents a game piece in Sokoban.
 * 
 * <p>
 * The game Sokoban uses four different types of pieces: The player, boxes that
 * the player pushes around the board, storage positions that mark the positions
 * where the boxes are to be placed by the player, and walls that restrict the
 * movement of the player and boxes.
 * 
 * <p>
 * Every {@code Piece} instance knows its current position on the board and its
 * type (player, box, storage position, wall).
 */
public class Piece {
	/*
	 * MAKE SURE THAT YOUR FIELDS ARE PRIVATE.
	 * 
	 * MAKE SURE THAT YOUR METHODS HAVE THE SAME RETURN TYPE, NAME, AND PARAMETER
	 * LISTS AS SHOWN IN THE DOCUMENTATION.
	 */
	private PieceType type;
	private Position pos;

	public Piece(PieceType type, Position pos) {
		this.type = type;
		this.pos = pos;
	}

	public PieceType type() {
		return type;
	}

	public Position position() {
		return pos;
	}

	public boolean isMovable() {
		if (this.type == PieceType.PLAYER || this.type == PieceType.BOX) {
			return true;
		}
		return false;
	}

	public boolean moveTo(Position to) {
		if (this.isMovable() && pos.isAdjacentTo(to)) {
			this.pos = to;
			return true;
		}
		return false;
	}

	public boolean moveUp() {
		if(this.isMovable() && pos.up() != Position.NONE) {
			pos.up(); 
			return true; 
		}
		return false; 
	}

	public boolean moveDown() {
		if(this.isMovable() && pos.down() != Position.NONE) {
			pos.down(); 
			return true; 
		}
		return false; 
	}

	public boolean moveLeft() {
		if(this.isMovable() && pos.left() != Position.NONE) {
			pos.left(); 
			return true; 
		}
		return false; 
	}

	public boolean moveRight() {
		if(this.isMovable() && pos.right() != Position.NONE) {
			pos.right(); 
			return true; 
		}
		return false; 
	}
}
