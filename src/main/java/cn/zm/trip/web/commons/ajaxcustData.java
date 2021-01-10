package cn.zm.trip.web.commons;

import cn.zm.trip.web.domain.Hotel;

import java.util.List;

public class ajaxcustData {
    List<Hotel> results;
    int distance[];

    public List<Hotel> getResults() {
        return results;
    }

    public void setResults(List<Hotel> results) {
        this.results = results;
    }

    public int[] getDistance() {
        return distance;
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }
}
