package netcracker.intensive.rover;

public class Ground {
    private GroundCell[][] landscape;
    private int width, length;
    public Ground(int width, int length) {

        this.width = width;
        this.length = length;
        landscape = new GroundCell[width][length];
    }

    public GroundCell getCell(int x, int y) throws OutOfGroundException {
        if(x < 0 || y < 0) {
            throw new OutOfGroundException();
        }
        if(x >= width || y >= length) {
            throw new OutOfGroundException();
        }
        return landscape[x][y];
    }

    public void initialize(GroundCell ... cells){

        int cellCount = width*length;

        if(cells.length < cellCount) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < cellCount; ++i) {
            int x = i % width;
            int y = i / width;
            landscape[x][y] = cells[i];
        }

    }
}
