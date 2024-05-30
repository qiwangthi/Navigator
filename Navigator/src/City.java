import java.util.ArrayList;

public class City {
    private String cityName;
    private double latitude;
    private double longitude;
    private ArrayList<Connection> connections;

    public City(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connections = new ArrayList<Connection>();
    }

    // Getters
    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Setters
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return cityName + " " + latitude + " " + longitude + " ";

    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connection> connections) {
        this.connections = connections;
    }

    /*
     * Wird die Methode addConnection(City cityToConnect) aufgerufen, muss die
     * Verbindung in beiden Städten in der ArrayList hinzugefügt werden.
     * connection in two cities added to the ArrayList
     */
    public void addConnection(City cityToConnect) {
        if (this == cityToConnect) {
            System.out.println("Eine Stadt kann nicht mit sich selbst verknüpft werden.");
            return;
        } else {
            Connection connection = new Connection(this, cityToConnect, 0);
            connections.add(connection);
            cityToConnect.connections.add(connection);
        }
    }

    public String getRouteTo(City destination) {
        return Route.getShortestRoute(this, destination).toString();

    }
}