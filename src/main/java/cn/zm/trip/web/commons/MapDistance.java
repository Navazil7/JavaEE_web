package cn.zm.trip.web.commons;
/**
 * 经纬距离换算
 */
public class MapDistance {

    private static final double PI = 3.14159265;
    private static final double EARTH_RADIUS = 6378137;
    private static final double RAD = Math.PI / 180.0;
    private static Double a;

    private static MapDistance mapDistance = null;

    private MapDistance() {

    }

    public static MapDistance getInstance() {
        if (mapDistance == null) {
            mapDistance = new MapDistance();
        }

        return mapDistance;
    }

    /**
     * 根据提供的经度和纬度、以及半径，取得此半径内的最大最小经纬度
     *
     * @param raidus 单位米
     * @return minLat, minLng, maxLat, maxLng
     */
    public static Double[] getAround(Double lat, Double lon, int raidus) {
        Double latitude = lat;//纬度
        Double longitude = lon;//经度
        Double degree = (24901 * 1609) / 360.0;//度
        double raidusMile = raidus;//半径
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;
        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        System.out.println(minLat + "   " + maxLat + "   " + minLng + "  " + maxLng);
        return new Double[]{minLat, maxLat, minLng, maxLng};
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     *
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static Double getDistance(Double lng1, Double lat1, Double lng2, Double lat2) {
        double radLat1 = lat1 * RAD;
        double radLat2 = lat2 * RAD;
        double a = radLat1 - radLat2;
        Double b = (lng1 - lng2) * RAD;
        Double s = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000.0;
        return s;
    }
}