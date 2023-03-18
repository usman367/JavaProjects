package sudoku.problemdomain;

import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //If the given argument is null, or its class is not equal to this class, return false
        if (o == null || getClass() != o.getClass()) return false;
        //Creating coordinates from the given argument using this class
        Coordinates that = (Coordinates) o;
        // Returns true if they're the same
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        // It will generate a unique identifier from these coordinates
        return Objects.hash(x, y);
    }
}
