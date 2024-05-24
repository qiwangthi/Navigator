
public class Connection {
    private City stadt1;
    private City stadt2;

    public Connection(City stadt1, City stadt2) {
        this.stadt1 = stadt1;
        this.stadt2 = stadt2;
    }

    // die Methode getDistanceInKm berechnet die Distanz zwischen zwei Städten in
    // Kilometern
    final double getDistanceInKm(City stadt1, City stadt2) {
        double latstadt1 = stadt1.getLatitude();
        double lonstadt1 = stadt1.getLongitude();
        double latstadt2 = stadt2.getLatitude();
        double lonstadt2 = stadt2.getLongitude();
        double erdRadiusKm = 6371;
        double dLat = degreesToRadians(latstadt2 - latstadt1);
        double dLon = degreesToRadians(lonstadt2 - lonstadt1);
        latstadt1 = degreesToRadians(latstadt1);
        latstadt2 = degreesToRadians(latstadt2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(stadt1) * Math.cos(muenchen);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return erdRadiusKm * c;
    }

    private double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    // die Methode getOtherCity gibt die andere Stadt zurück, die mit der Verbindung
    // verbunden ist
    public City getOtherCity(City stadt1) {
        return stadt2;
    }

}