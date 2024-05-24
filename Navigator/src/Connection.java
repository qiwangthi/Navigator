public class Connection {
    private City stadt1, stadt2;
    private double distance;

    public Connection(City stadt1, City stadt2) {
        this.stadt1 = stadt1;
        this.stadt2 = stadt2;

    }

    // Getters
    public City getStadt1() {
        return stadt1;
    }

    public City getStadt2() {
        return stadt2;
    }

    public double getDistance() {
        return distance;
    }

    // die Methode getDistanceInKm berechnet die Distanz zwischen zwei Städten in
    // Kilometern
    final double getDistanceInKm(City stadt1, City stadt2) {
        double lat1 = stadt1.getLatitude();
        double lon1 = stadt1.getLongitude();
        double lat2 = stadt2.getLatitude();
        double lon2 = stadt2.getLongitude();
        double erdRadiusKm = 6371;
        double dLat = degreesToRadians(lat2 - lat1);
        double dLon = degreesToRadians(lon2 - lon1);
        lat1 = degreesToRadians(lat1);
        lat2 = degreesToRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return erdRadiusKm * c;
    }

    private double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    // die Methode getOtherCity gibt die andere Stadt zurück, die mit der Verbindung
    // verbunden ist
    public City getOtherCity(City city) {
        if (city.equals(stadt1)) {
            return stadt2;
        } else if (city.equals(stadt2)) {
            return stadt1;
        } else {
            return null;
        }
    }

}