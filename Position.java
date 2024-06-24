package sokoban;
import java.util.Objects;

/**
 * A class that represents a position using a pair of integer coordinates
 * {@code (x, y)} where {@code x} and {@code y} are non-negative values. A
 * {@code Position} object is immutable.
 * 
 * <p>
 * The positive x-direction points to the right and the positive y-direction
 * points upwards.
 * 
 * <p>
 * A special constant named {@code NONE} is defined by this class to represent
 * the value "no such position". {@code NONE} is equal to itself, and not equal
 * to every other {@code Position} object. The constant {@code NONE} is unusual
 * in that it does not enforce the class invariant that its coordinates be
 * non-negative.
 */
public class Position {

	private int x;
	private int y;

	/**
	 * The special constant representing the value "no such position".
	 */
	public static final Position NONE = new Position();
	static {
		NONE.x = -1;
		NONE.y = -1;
	}

	/*
	 * MAKE SURE THAT YOUR METHODS HAVE THE SAME RETURN TYPE, NAME, AND PARAMETER
	 * LISTS AS SHOWN IN THE DOCUMENTATION.
	 */
	public Position() {
		x = 0;
		y = 0;
	}

	public Position(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Position Out Of Bounds");
		} else {
			this.x = x;
			this.y = y;
		}
	}

	public Position(Position other) {
		this.x = other.x();
		this.y = other.y();
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}

	public Position down() {
		if (y - 1 <= 0) {
			return Position.NONE;
		}
		Position down = new Position(x, y - 1);
		return (down);
	}

	public Position up() {
		if (y + 1 >= Integer.MAX_VALUE) {
			return Position.NONE;
		}
		Position up = new Position(x, y + 1);
		return (up);
	}

	public Position left() {
		if (x - 1 <= 0) {
			return Position.NONE;
		}
		Position left = new Position(x - 1, y);
		return (left);
	}

	public Position right() {
		if (x + 1 >= Integer.MAX_VALUE) {
			return Position.NONE;
		}
		Position right = new Position(x + 1, y);
		return (right);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (this.x != other.x || this.y != other.y) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}

	public boolean isAdjacentTo(Position other) {
		if (((other.x == this.x - 1) || (other.x == this.x + 1)) && (this.y == other.y)) {
			return true;
		}
		if (((other.y == this.y - 1) || (other.y == this.y + 1)) && (this.x == other.x)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return ("[" + x + "] [" + y + "]");
	}
}
