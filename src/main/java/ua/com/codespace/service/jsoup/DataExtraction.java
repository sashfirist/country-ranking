package ua.com.codespace.service.jsoup;

import org.jsoup.select.Elements;

import java.io.IOException;

public interface DataExtraction {
    Elements getPopulation() throws IOException;
    Elements getArea() throws IOException;
    Elements getAvgLifeDuration() throws IOException;
    Elements getLifeQualityIndex() throws IOException;
}
