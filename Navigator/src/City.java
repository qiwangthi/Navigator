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

    public void addConnection(City cityToConnect) {
        if (this == cityToConnect) {
            System.out.println("Eine Stadt kann nicht mit sich selbst verknüpft werden.");
        } else {

            Connection connection = new Connection(this, cityToConnect);
            connections.add(connection);
        }
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

}