package ua.com.codespace.service.jsoup;

import org.jsoup.select.Elements;

public interface DataExtraction {

    Elements getArea();
    Elements getPopulation();
    Elements getAvgLifeDuration();
    Elements getLifeQualityIndex();
}
