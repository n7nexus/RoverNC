package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground;
    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    public boolean hasObstacles(Point point) throws OutOfGroundException{
        if(ground.getCell(point.getX(), point.getY()).getState() == CellState.OCCUPIED) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroundVisor that = (GroundVisor) o;

        return ground != null ? ground.equals(that.ground) : that.ground == null;

    }

    @Override
    public int hashCode() {
        return ground != null ? ground.hashCode() : 0;
    }
}
