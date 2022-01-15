package life;

public enum Neighbour {
    NW(-1, -1),
    N(-1, 0),
    NE(-1, 1),
    E(0, -1),
    W(0, 1),
    SW(1, -1),
    S(1, 0),
    SE(1, 1);

    private final int x;
    private final int y;

    Neighbour(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
