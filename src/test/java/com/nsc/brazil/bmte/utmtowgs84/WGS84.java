package com.nsc.brazil.bmte.utmtowgs84;

public class WGS84 {
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public WGS84(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String toString() {
        // char ns = (latitude < 0) ? 'S' : 'N';
        // char ew = (longitude < 0) ? 'W' : 'E';
        // return String.format("%s%c %s%c", Math.abs(latitude), ns,
        // Math.abs(longitude), ew);
        return String.format("%s %s", latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WGS84) {
            WGS84 other = (WGS84) o;
            return (latitude == other.latitude) && (longitude == other.longitude);
        }
        return false;
    }

    @Override
    public int hashCode() {
        long llat = Double.doubleToRawLongBits(latitude);
        long llon = Double.doubleToRawLongBits(longitude);
        long x = llat ^ llon;
        return (int) (x ^ (x >>> 32));
    }

    public static WGS84 fromUTM(int zone, char letter, double easting, double northing) {
        double north;
        if (letter > 'M') {
            north = northing;
        } else {
            north = northing - 10000000;
        }

        double latitude = (north / 6366197.724
            / 0.9996
            + (1
            + 0.006739496742 * Math.pow(Math.cos(north / 6366197.724 / 0.9996),
            2)
            - 0.006739496742 * Math.sin(north / 6366197.724 / 0.9996)
            * Math.cos(
            north / 6366197.724
                / 0.9996)
            * (Math.atan(Math
            .cos(Math.atan((Math
                .exp((easting - 500000)
                    / (0.9996 * 6399593.625 / Math.sqrt(
                    (1 + 0.006739496742 * Math.pow(
                        Math.cos(north / 6366197.724
                            / 0.9996),
                        2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000) / (0.9996
                        * 6399593.625
                        / Math.sqrt(
                        (1 + 0.006739496742
                            * Math.pow(
                            Math.cos(
                                north / 6366197.724
                                    / 0.9996),
                            2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(north
                    / 6366197.724 / 0.9996), 2)
                    / 3))
                - Math.exp(-(easting - 500000)
                / (0.9996 * 6399593.625
                / Math.sqrt((1
                + 0.006739496742 * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2))))
                * (1 - 0.006739496742
                * Math.pow(
                (easting - 500000) / (0.9996
                    * 6399593.625
                    / Math.sqrt(
                    (1 + 0.006739496742
                        * Math.pow(
                        Math.cos(
                            north / 6366197.724
                                / 0.9996),
                        2)))),
                2)
                / 2
                * Math.pow(Math.cos(north
                / 6366197.724 / 0.9996), 2)
                / 3)))
                / 2
                / Math.cos((north - 0.9996 * 6399593.625
                * (north / 6366197.724 / 0.9996
                - 0.006739496742 * 3 / 4 * (north
                / 6366197.724
                / 0.9996
                + Math
                .sin(2 * north
                    / 6366197.724
                    / 0.9996)
                / 2)
                + Math.pow(0.006739496742 * 3 / 4,
                2) * 5
                / 3
                * (3 * (north / 6366197.724
                / 0.9996
                + Math
                .sin(2 * north
                    / 6366197.724
                    / 0.9996)
                / 2)
                + Math.sin(2
                * north
                / 6366197.724
                / 0.9996)
                * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2))
                / 4
                - Math.pow(0.006739496742 * 3 / 4,
                3) * 35
                / 27
                * (5 * (3 * (north
                / 6366197.724
                / 0.9996
                + Math
                .sin(2 * north
                    / 6366197.724
                    / 0.9996)
                / 2)
                + Math.sin(2 * north
                / 6366197.724
                / 0.9996)
                * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2))
                / 4
                + Math
                .sin(2 * north
                    / 6366197.724
                    / 0.9996)
                * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2)
                * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2))
                / 3))
                / (0.9996 * 6399593.625
                / Math.sqrt((1
                + 0.006739496742 * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2))))
                * (1 - 0.006739496742
                * Math.pow(
                (easting - 500000) / (0.9996
                    * 6399593.625
                    / Math.sqrt(
                    (1 + 0.006739496742
                        * Math.pow(
                        Math.cos(
                            north / 6366197.724
                                / 0.9996),
                        2)))),
                2)
                / 2
                * Math.pow(Math.cos(north
                / 6366197.724 / 0.9996), 2))
                + north / 6366197.724 / 0.9996)))
            * Math.tan((north - 0.9996 * 6399593.625
            * (north / 6366197.724 / 0.9996 - 0.006739496742 * 3
            / 4
            * (north / 6366197.724 / 0.9996 + Math.sin(
            2 * north / 6366197.724 / 0.9996)
            / 2)
            + Math.pow(0.006739496742 * 3 / 4, 2) * 5
            / 3 * (3
            * (north / 6366197.724
            / 0.9996
            + Math
            .sin(2 * north
                / 6366197.724
                / 0.9996)
            / 2)
            + Math.sin(2 * north
            / 6366197.724
            / 0.9996)
            * Math.pow(
            Math.cos(
                north / 6366197.724
                    / 0.9996),
            2))
            / 4
            - Math.pow(0.006739496742 * 3 / 4, 3) * 35
            / 27
            * (5 * (3
            * (north / 6366197.724
            / 0.9996
            + Math
            .sin(2 * north
                / 6366197.724
                / 0.9996)
            / 2)
            + Math.sin(2 * north
            / 6366197.724
            / 0.9996)
            * Math.pow(
            Math.cos(
                north / 6366197.724
                    / 0.9996),
            2))
            / 4
            + Math
            .sin(2 * north
                / 6366197.724
                / 0.9996)
            * Math.pow(
            Math.cos(
                north / 6366197.724
                    / 0.9996),
            2)
            * Math.pow(
            Math.cos(
                north / 6366197.724
                    / 0.9996),
            2))
            / 3))
            / (0.9996 * 6399593.625 / Math.sqrt(
            (1 + 0.006739496742 * Math.pow(Math.cos(
                north / 6366197.724 / 0.9996), 2))))
            * (1 - 0.006739496742
            * Math.pow(
            (easting - 500000)
                / (0.9996 * 6399593.625
                / Math.sqrt(
                (1 + 0.006739496742
                    * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2)))),
            2)
            / 2
            * Math.pow(Math.cos(
            north / 6366197.724 / 0.9996), 2))
            + north / 6366197.724 / 0.9996))
            - north / 6366197.724 / 0.9996)
            * 3 / 2)
            * (Math.atan(Math
            .cos(Math
                .atan((Math.exp((easting - 500000) / (0.9996 * 6399593.625
                    / Math.sqrt((1 + 0.006739496742 * Math
                    .pow(Math.cos(north / 6366197.724 / 0.9996),
                        2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000)
                        / (0.9996 * 6399593.625
                        / Math.sqrt(
                        (1 + 0.006739496742
                            * Math.pow(
                            Math.cos(
                                north / 6366197.724
                                    / 0.9996),
                            2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(
                    north / 6366197.724 / 0.9996), 2)
                    / 3))
                    - Math.exp(-(easting - 500000)
                    / (0.9996 * 6399593.625
                    / Math.sqrt((1
                    + 0.006739496742 * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000) / (0.9996
                        * 6399593.625
                        / Math.sqrt(
                        (1 + 0.006739496742
                            * Math.pow(
                            Math.cos(
                                north / 6366197.724
                                    / 0.9996),
                            2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(north
                    / 6366197.724 / 0.9996), 2)
                    / 3)))
                    / 2
                    / Math.cos((north - 0.9996 * 6399593.625
                    * (north / 6366197.724 / 0.9996
                    - 0.006739496742 * 3 / 4 * (north
                    / 6366197.724
                    / 0.9996
                    + Math
                    .sin(2 * north
                        / 6366197.724
                        / 0.9996)
                    / 2)
                    + Math.pow(0.006739496742 * 3 / 4,
                    2) * 5
                    / 3
                    * (3 * (north / 6366197.724
                    / 0.9996
                    + Math
                    .sin(2 * north
                        / 6366197.724
                        / 0.9996)
                    / 2)
                    + Math.sin(2
                    * north
                    / 6366197.724
                    / 0.9996)
                    * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2))
                    / 4
                    - Math.pow(0.006739496742 * 3 / 4,
                    3) * 35
                    / 27
                    * (5 * (3 * (north
                    / 6366197.724
                    / 0.9996
                    + Math
                    .sin(2 * north
                        / 6366197.724
                        / 0.9996)
                    / 2)
                    + Math.sin(2 * north
                    / 6366197.724
                    / 0.9996)
                    * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2))
                    / 4
                    + Math
                    .sin(2 * north
                        / 6366197.724
                        / 0.9996)
                    * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2)
                    * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2))
                    / 3))
                    / (0.9996 * 6399593.625
                    / Math.sqrt((1
                    + 0.006739496742 * Math.pow(
                    Math.cos(
                        north / 6366197.724
                            / 0.9996),
                    2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000) / (0.9996
                        * 6399593.625
                        / Math.sqrt(
                        (1 + 0.006739496742
                            * Math.pow(
                            Math.cos(
                                north / 6366197.724
                                    / 0.9996),
                            2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(north
                    / 6366197.724 / 0.9996), 2))
                    + north / 6366197.724 / 0.9996)))
            * Math.tan((north - 0.9996 * 6399593.625
            * (north / 6366197.724 / 0.9996
            - 0.006739496742 * 3 / 4
            * (north / 6366197.724 / 0.9996 + Math.sin(
            2 * north / 6366197.724 / 0.9996)
            / 2)
            + Math.pow(0.006739496742 * 3 / 4, 2) * 5 / 3 * (3
            * (north / 6366197.724 / 0.9996 + Math.sin(
            2 * north / 6366197.724 / 0.9996)
            / 2)
            + Math.sin(
            2 * north / 6366197.724 / 0.9996)
            * Math.pow(
            Math.cos(north / 6366197.724
                / 0.9996),
            2))
            / 4
            - Math.pow(0.006739496742 * 3 / 4, 3) * 35 / 27 * (5
            * (3 * (north / 6366197.724 / 0.9996
            + Math.sin(2 * north / 6366197.724
            / 0.9996) / 2)
            + Math.sin(2 * north / 6366197.724
            / 0.9996)
            * Math.pow(
            Math.cos(
                north / 6366197.724
                    / 0.9996),
            2))
            / 4
            + Math.sin(2 * north / 6366197.724 / 0.9996)
            * Math.pow(
            Math.cos(north / 6366197.724
                / 0.9996),
            2)
            * Math.pow(Math.cos(north
            / 6366197.724 / 0.9996), 2))
            / 3))
            / (0.9996 * 6399593.625
            / Math.sqrt((1 + 0.006739496742 * Math.pow(
            Math.cos(north / 6366197.724 / 0.9996),
            2))))
            * (1 - 0.006739496742
            * Math.pow(
            (easting - 500000) / (0.9996 * 6399593.625
                / Math.sqrt((1
                + 0.006739496742 * Math.pow(
                Math.cos(
                    north / 6366197.724
                        / 0.9996),
                2)))),
            2)
            / 2
            * Math.pow(Math.cos(north / 6366197.724 / 0.9996),
            2))
            + north / 6366197.724 / 0.9996))
            - north / 6366197.724 / 0.9996))
            * 180 / Math.PI;
        latitude = Math.round(latitude * 10000000);
        latitude = latitude / 10000000;

        double longitude = Math
            .atan((Math
                .exp((easting - 500000)
                    / (0.9996 * 6399593.625
                    / Math.sqrt((1 + 0.006739496742 * Math.pow(
                    Math.cos(north / 6366197.724 / 0.9996), 2))))
                    * (1 - 0.006739496742
                    * Math.pow((easting - 500000) / (0.9996 * 6399593.625
                        / Math.sqrt((1 + 0.006739496742 * Math.pow(
                    Math.cos(north / 6366197.724 / 0.9996),
                    2)))),
                    2)
                    / 2 * Math.pow(Math.cos(north / 6366197.724 / 0.9996), 2)
                    / 3))
                - Math.exp(
                -(easting - 500000)
                    / (0.9996 * 6399593.625
                    / Math.sqrt(
                    (1 + 0.006739496742 * Math.pow(Math.cos(
                        north / 6366197.724 / 0.9996), 2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000) / (0.9996 * 6399593.625
                        / Math.sqrt((1
                        + 0.006739496742 * Math.pow(
                        Math.cos(
                            north / 6366197.724
                                / 0.9996),
                        2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(north / 6366197.724 / 0.9996),
                    2)
                    / 3)))
                / 2 / Math
                .cos((north - 0.9996 * 6399593.625 * (north / 6366197.724 / 0.9996
                    - 0.006739496742 * 3 / 4 * (north / 6366197.724 / 0.9996
                    + Math.sin(2 * north / 6366197.724 / 0.9996) / 2)
                    + Math.pow(0.006739496742 * 3 / 4, 2) * 5 / 3 * (3
                    * (north / 6366197.724 / 0.9996
                    + Math.sin(2 * north / 6366197.724 / 0.9996)
                    / 2)
                    + Math.sin(2 * north / 6366197.724 / 0.9996)
                    * Math.pow(Math.cos(
                    north / 6366197.724 / 0.9996), 2))
                    / 4
                    - Math.pow(0.006739496742 * 3 / 4, 3) * 35 / 27 * (5
                    * (3 * (north / 6366197.724 / 0.9996
                    + Math.sin(2 * north / 6366197.724 / 0.9996)
                    / 2)
                    + Math.sin(2 * north / 6366197.724 / 0.9996)
                    * Math.pow(Math.cos(north
                    / 6366197.724 / 0.9996), 2))
                    / 4
                    + Math.sin(2 * north / 6366197.724 / 0.9996)
                    * Math.pow(Math
                        .cos(north / 6366197.724 / 0.9996),
                    2)
                    * Math.pow(Math.cos(
                    north / 6366197.724 / 0.9996), 2))
                    / 3))
                    / (0.9996 * 6399593.625
                    / Math.sqrt((1 + 0.006739496742 * Math.pow(
                    Math.cos(north / 6366197.724 / 0.9996),
                    2))))
                    * (1 - 0.006739496742
                    * Math.pow(
                    (easting - 500000) / (0.9996 * 6399593.625
                        / Math.sqrt((1
                        + 0.006739496742 * Math.pow(
                        Math.cos(
                            north / 6366197.724
                                / 0.9996),
                        2)))),
                    2)
                    / 2
                    * Math.pow(Math.cos(north / 6366197.724 / 0.9996),
                    2))
                    + north / 6366197.724 / 0.9996))
            * 180 / Math.PI + zone * 6 - 183;
        longitude = Math.round(longitude * 10000000);
        longitude = longitude / 10000000;

        return new WGS84(latitude, longitude);
    }

    public String toWKT() {
        return "POINT( " + longitude + " " + latitude + " )";
    }
}
