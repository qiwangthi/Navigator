public class App {
    public static void main(String[] args) throws Exception {
        City ingolstadt = new City("Ingolstadt", 48.764001378240835, 11.42625484665524);
        City münchen = new City("München", 48.13891855227781, 11.577266137987793);
        City nürnberg = new City("Nürnberg", 49.45061728516064, 11.076253152617218);
        City ulm = new City("Ulm", 48.40203485876449, 9.976324958249457);
        City stuttgart = new City("Stuttgart", 48.77593813959718, 9.17688481609677);
        City augsburg = new City("Augsburg", 48.3684765834842, 10.89671693335146);
        City regensburg = new City("Regensburg", 49.01662121288669, 12.092787603517024);
        City würzburg = new City("Würzburg", 49.79296114327296, 9.945390533206055);

        System.out.println(ingolstadt.toString());
        System.out.println(münchen.toString());
        System.out.println(nürnberg.toString());
        System.out.println(ulm.toString());
        System.out.println(stuttgart.toString());
        System.out.println(augsburg.toString());
        System.out.println(regensburg.toString());
        System.out.println(würzburg.toString());

        ingolstadt.addConnection(münchen);
        ingolstadt.addConnection(nürnberg);
        ingolstadt.addConnection(regensburg);
        ingolstadt.addConnection(augsburg);
        münchen.addConnection(augsburg);
        ulm.addConnection(augsburg);
        stuttgart.addConnection(ulm);
        stuttgart.addConnection(nürnberg);
        stuttgart.addConnection(würzburg);
        regensburg.addConnection(münchen);
        regensburg.addConnection(nürnberg);
        nürnberg.addConnection(ulm);

        City[] cities = { ingolstadt, münchen, nürnberg, ulm, stuttgart, augsburg, regensburg, würzburg };

        for (City city : cities) {
            System.out.println(city.getCityName());
            for (Connection connection : city.getConnections()) {
                System.out.println("  Verbindung nach " + connection.getOtherCity(city).getCityName() + " mit Distanz: "
                        + connection.getDistance());
            }

        }
    }
}
