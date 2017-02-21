package netcracker.intensive.rover;

public class Point {
    //не забудьте реализовать equals, hashCode, toString!
    private int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incX() {
        x++;
    }

    public void incY() {
        y++;
    }
    public void decX() {
        x--;
    }

    public void decY() {
        y--;
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;

     /* obj ссылается на null */

        if(obj == null)
            return false;

     /* Удостоверимся, что ссылки имеют тот же самый тип */
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Point p = (Point)obj;
            if(this.x == p.x && this.y == p.y) {
                return true;
            }
            return false;
        }

    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }
}
