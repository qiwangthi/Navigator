import java.util.ArrayList;

public class Route {
    private ArrayList<City> routeCities;
    private double totalDistance;

    // Die Konstruktoren der Stadt sind beide private

    public Route() {
        this.routeCities = new ArrayList<>();
        this.totalDistance = 0;
    }

    // Copy constructor
    public Route(Route route) {
        this.routeCities = new ArrayList<>(route.routeCities);
        this.totalDistance = route.totalDistance;
        // totalDistance abrunden in ganze Zahlen ohne Nachkommastellen
        this.totalDistance = Math.round(this.totalDistance);
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

    public void appendCity(City city, Connection connection) {
        routeCities.add(city);
        if (connection != null) {
            totalDistance += connection.getDistanceInKm(city, connection.getOtherCity(city));
        }
    }

    public boolean containsCity(City city) {
        return routeCities.contains(city);
    }

    public String toString() {
        String route = "";
        for (City city : routeCities) {
            route += city.getCityName();
            if (routeCities.indexOf(city) < routeCities.size() - 1) {
                route += " - ";

            }
        }
        return route + "; Distanz: " + totalDistance;
    }

    public static Route getShortestRoute(City origin, City destination) {
        ArrayList<Route> allPossibleRoutes = new ArrayList<>();
        Route currentRoute = new Route();
        addAllRoutes(allPossibleRoutes, currentRoute, origin, destination, null);

        // speichern die sortierte Route in routesOrderedByDistance
        ArrayList<Route> routesOrderedByDistance = new ArrayList<>(allPossibleRoutes);
        Route shortestRoute = null;
        for (int i = 0; i < routesOrderedByDistance.size(); i++) {
            for (int j = i + 1; j < routesOrderedByDistance.size(); j++) {
                if (routesOrderedByDistance.get(i).getTotalDistance() > routesOrderedByDistance.get(j)
                        .getTotalDistance()) {
                    Route temp = routesOrderedByDistance.get(i);
                    routesOrderedByDistance.set(i, routesOrderedByDistance.get(j));
                    routesOrderedByDistance.set(j, temp);

                }
            }
        }
        System.out.println("Alle möglichen Routen: ");
        for (Route route : routesOrderedByDistance) {
            System.out.println(route.toString());
        }
        shortestRoute = routesOrderedByDistance.get(0);
        return shortestRoute;
    }

    public static void addAllRoutes(ArrayList<Route> allPossibleRoutes, Route currentRoute, City currentCity,
            City destination, Connection connection) {
        currentRoute.appendCity(currentCity, connection);

        if (currentCity.equals(destination)) {
            allPossibleRoutes.add(new Route(currentRoute));
            return;
        }

        ArrayList<Connection> possibleNextCities = currentCity.getConnections();
        for (Connection conn : possibleNextCities) {
            City otherCity = conn.getOtherCity(currentCity);
            if (!currentRoute.containsCity(otherCity)) {
                Route continuedRoute = new Route(currentRoute);
                addAllRoutes(allPossibleRoutes, continuedRoute, otherCity, destination, conn);
            }
        }
    }
}
