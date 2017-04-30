package ua.com.codespace.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DataExtraction {

    public Elements getPopulation() throws IOException{
        Document doc = Jsoup.connect("http://ostranah.ru/_lists/population.php").get();
        Element table = doc.select("tbody").first();
        return table.select("a, [class='digits']");
    }

    public Elements getArea() throws IOException{
        Document doc = Jsoup.connect("http://ostranah.ru/_lists/area.php").get();
        Element table = doc.select("tbody").first();
        return table.select("a, [class='digits']");
    }

    public Elements getAvgLifeDuration() throws IOException{
        Document doc = Jsoup.connect("http://ostranah.ru/_lists/life_expectancy.php").get();
        Element table = doc.select("tbody").first();
        return table.select("a, tr > td[class='digits']:eq(2)");
    }

    public Elements getLifeQualityIndex() throws IOException{
        Document doc = Jsoup.connect("http://gtmarket.ru/ratings/quality-of-life-index/info").get();
        Element table = doc.select("table[class='table-data']").first();
        return table.select("tr:gt(0) td:gt(0)");
    }
}
