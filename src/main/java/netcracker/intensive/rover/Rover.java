package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

import static netcracker.intensive.rover.constants.Direction.SOUTH;

public class Rover implements Moveable, Turnable, Liftable, Landable{

    private GroundVisor groundVisor;
    private boolean airborne = false;
    private Point position = new Point(0, 0);
    private Direction direction = Direction.SOUTH;

    public Rover(GroundVisor groundVisor) {
        this.groundVisor = groundVisor;
    }

    @Override
    public void lift() {
        airborne = true;
        direction = null;
        position = null;
    }

    @Override
    public void move() {
        if (!airborne) {
            Point p = new Point(position.getX(), position.getY());
            switch (direction) {
                case NORTH:
                    p.decY();
                    break;
                case EAST:
                    p.incX();
                    break;
                case SOUTH:
                    p.incY();
                    break;
                case WEST:
                    p.decX();
                    break;
            }
            try {
                if (!groundVisor.hasObstacles(p)) {
                    position = p;
                }
            } catch (OutOfGroundException e) {
                lift();
            }
        }
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void land(Point position, Direction direction) {
        try {
            if(airborne && !groundVisor.hasObstacles(position)) {
                this.position = position;
                this.direction = direction;
                airborne = false;
            }
        } catch (OutOfGroundException e) {
            e.printStackTrace();
        }
    }

    public boolean isAirborne() {
        return airborne;
    }

    public Point getCurrentPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (airborne != rover.airborne) return false;
        if (groundVisor != null ? !groundVisor.equals(rover.groundVisor) : rover.groundVisor != null) return false;
        if (position != null ? !position.equals(rover.position) : rover.position != null) return false;
        return direction == rover.direction;

    }

    @Override
    public int hashCode() {
        int result = groundVisor != null ? groundVisor.hashCode() : 0;
        result = 31 * result + (airborne ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
