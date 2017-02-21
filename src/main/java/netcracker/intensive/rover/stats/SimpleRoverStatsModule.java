package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleRoverStatsModule implements RoverStatsModule {

    private ArrayList<Point> visited = new ArrayList<>();

    @Override
    public void registerPosition(Point position) {
        if(!visited.contains(position))
            visited.add(position);
    }

    @Override
    public boolean isVisited(Point point) {
        return visited.contains(point);
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return visited;
    }
}
