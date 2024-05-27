import java.util.ArrayList;

public class Route {
    private ArrayList<City> routeCities;
    private double totalDistance;

    // defaul constructor
    public Route() {
        this.routeCities = new ArrayList<City>();
        this.totalDistance = 0;
    }

    // Copy constructor
    public Route(ArrayList<City> routeCities, double totalDistance) {
        this.routeCities = new ArrayList<City>(routeCities);
        this.totalDistance = totalDistance;
    }

    // Getters
    public ArrayList<City> getRouteCities() {
        return routeCities;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    /*
     * In der Methode muss die City zu routeCities hinzugefügt werden und falls die
     * Connection nicht null ist die Distanz in Kilometern der übergebenen
     * Connection zu der totalDistance der Route hinzugefügt werden.
     */

    public void appendCity(City ZwischenCity, Connection connection) {
        routeCities.add(ZwischenCity);
        if (connection != null) {
            totalDistance += connection.getDistance();
        }
    }

    public boolean containsCity(City city) {
        if (routeCities.contains(city)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String route = "";
        for (City city : routeCities) {
            route += city.getCityName() + " - ";
        }
        return route + ";Distanz: " + totalDistance;
    }

    private static void addALLRoutes(ArrayList<Route> allpossibleRoutes, Route currentroute, City currentCity,
            City destination, Connection connection) {
        currentroute.appendCity(currentCity, connection);
        if (currentCity == destination) {
            allpossibleRoutes.add(new Route(currentroute.getRouteCities(), currentroute.getTotalDistance()));
        } else {
            ArrayList<Connection> possibleNextCities = new ArrayList<Connection>(currentCity.getConnection());
            for (Connection c : possibleNextCities) {
                City nextCity = c.getOtherCity(currentCity);
                if (!currentroute.containsCity(nextCity)) {
                    Route continuedRoute = new Route(currentroute.getRouteCities(), currentroute.getTotalDistance());
                    addALLRoutes(allpossibleRoutes, continuedRoute, nextCity, destination, c);
                }
            }
        }
    }

    public static Route getShortestRoute(City origin, City destination) {

        ArrayList<Route> allpossibleRoutes = new ArrayList<Route>();
        Route currentroute = new Route();
        addALLRoutes(allpossibleRoutes, currentroute, origin, destination, null);
        Route shortestRoute = allpossibleRoutes.get(0);
        for (Route r : allpossibleRoutes) {
            if (r.getTotalDistance() < shortestRoute.getTotalDistance()) {
                shortestRoute = r;
            }
        }
        return shortestRoute;
    }

}
