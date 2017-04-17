package ua.com.codespace.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by D10020 on 12.04.2017.
 */
public class Ranking<T> {

    private String name;
    private int year;
    private Map<Country, T> rankingMap = new HashMap();

    public Ranking(String name) {
        this.name = name;
    }

    public Ranking(String name, int year, Map<Country, T> rankingMap) {
        this.name = name;
        this.year = year;
        this.rankingMap = rankingMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<Country, T> getRankingMap() {
        return rankingMap;
    }

    public void setRankingMap(HashMap<Country, T> rankingMap) {
        this.rankingMap = rankingMap;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rankingMap=" + rankingMap +
                '}';
    }
}



