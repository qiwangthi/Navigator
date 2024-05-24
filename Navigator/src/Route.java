import java.util.ArrayList;

public class Route {
    private ArrayList<Route> routeCities = new ArrayList<Route>();
    private String startCity;
    private String endCity;
    private double totalDistance;

    public Route(ArrayList<Route> routeCities, String startCity, String endCity, double totalDistance) {
        this.routeCities = routeCities;
        this.totalDistance = totalDistance;
        this.startCity = startCity;
        this.endCity = endCity;
    }

    // Getters
    public ArrayList<Route> getRouteCities() {
        return routeCities;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

}
