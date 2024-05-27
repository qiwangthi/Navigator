import java.util.ArrayList;

public class City {
    private String cityName;
    private double latitude;
    private double longitude;
    private ArrayList<Connection> connections = new ArrayList<Connection>();

    public City(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
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

    /*
     * Wird die Methode addConnection(City cityToConnect) aufgerufen, muss die
     * Verbindung in beiden Städten in der ArrayList hinzugefügt werden.
     * connection in two cities added to the ArrayList
     */
    public void addConnection(City cityToConnect) {
        Connection connection = new Connection(this, cityToConnect);
        connections.add(connection);
        cityToConnect.connections.add(connection);
    }

    public ArrayList<Connection> getConnection() {
        return connections;
    }

    /*
     * Methode namens getRouteTo(City destination) an. So können wir später
     * stuttgart.getRouteTo(regensburg); aufrufen und erhalten die kürzeste Route
     * von Stuttgart nach Regensburg. Die Methode wird die Route mit allen Städten
     * (Start, Zwischenstationen und Endpunkt) als String zurückgeben.
     */
    public String getRouteTo(City destination) {
        return Route.getShortestRoute(this, destination).toString();
    }
}
