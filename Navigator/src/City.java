import java.util.ArrayList;

public class City {
    private String cityName;
    private double latitude;
    private double longitude;
    private ArrayList<Connection> connections;

    public City(String cityName, double latitude, double longitude, ArrayList<Connection> connections) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connections = connections;
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

    public void addConnection(City city) {
        if (this == city) {
            System.out.println("Eine Stadt kann nicht mit sich selbst verknüpft werden.");
        } else {
            ArrayList<Connection> connections = new ArrayList<Connection>();
            connections.add(new Connection(this, city));

        }
    }
}