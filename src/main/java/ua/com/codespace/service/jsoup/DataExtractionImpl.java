package ua.com.codespace.service.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataExtractionImpl implements DataExtraction {

    public Elements getArea() {
        Element table = null;
        try {
            Document doc = Jsoup.connect("http://ostranah.ru/_lists/area.php").get();
            table = doc.select("tbody").first();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table.select("tr");
    }

    public Elements getPopulation() {
        Element table = null;
        try {
            Document doc = Jsoup.connect("http://ostranah.ru/_lists/population.php").get();
            table = doc.select("tbody").first();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table.select("tr");
    }

    public Elements getAvgLifeDuration() {
        Element table = null;
        try {
            Document doc = Jsoup.connect("http://ostranah.ru/_lists/life_expectancy.php").get();
            table = doc.select("tbody").first();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table.select("tr");
    }

    public Elements getLifeQualityIndex(){
        Element table = null;
        try {
            Document doc = Jsoup.connect("http://gtmarket.ru/ratings/quality-of-life-index/info").get();
            table = doc.select("table[class=table-data]").first();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table.select("tr:gt(0)");
    }
}
