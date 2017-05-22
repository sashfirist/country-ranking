package ua.com.codespace.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.CountryDetails;
import ua.com.codespace.entities.InformationType;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> getRankingType(String ranking){
        InformationType item = InformationType.get(ranking);
        List<Country> list;
        switch (item) {
            case AREA:
                list = countryDao.findRankingByArea();
                break;
            case POPULATION:
                list = countryDao.findRankingByPopulation();
                break;
            case AVG_LIFE_DURATION:
                list = countryDao.findRankingByLifeDuration();
                break;
            case LIFE_QUALITY_INDEX:
                list = countryDao.findRankingByLifeQuality();
                break;
            default:
                throw new IllegalArgumentException("Invalid Ranking Type");
        }
        return list;
    }

    public List<Country> parseRanking(String ranking) throws IOException {
        URL url = new URL(getUrl(ranking));
        Document doc = Jsoup.parse(url, 3000);
        Elements rows = doc.select("table#sort-table tr");
        List<Country> cntList = new ArrayList<>();
        GregorianCalendar gr = new GregorianCalendar();
        gr.setTime(new Date());
        String value = null;
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            String id = row.select("th").text();
            String countryName = row.select("td > a").text();
            if(ranking.equalsIgnoreCase("population") || ranking.equalsIgnoreCase("area")){
                value = row.select("td.digits").text().replace(" ", "");
            } else {
                value = row.select("td:eq(2)").text().replace(" ", "");
            }

            CountryDetails cD = new CountryDetails();
            cD.setInformation(InformationType.get(ranking));
            cD.setValue(Double.parseDouble(value));
            cD.setYear(gr.get(Calendar.YEAR));

            Country country = new Country();
            country.setName(countryName);
            //country.setId(Integer.parseInt(id));
            country.setCountryDetailList(new ArrayList<>(Arrays.asList(cD)));

            cntList.add(country);
        }
        return cntList;

    }

    private String getUrl(String ranking) {
        switch(ranking){
            case "area": return "http://ostranah.ru/_lists/population.php";
            case "population": return "http://ostranah.ru/_lists/population.php";
            case "average-life-duration": return "http://ostranah.ru/_lists/life_expectancy.php";
            case "life-quality-index": return "http://ostranah.ru/_lists/population_growth.php";
            default: throw new IllegalArgumentException("No inquired ranking found");
        }
    }

    public void saveRankingByArea( List<Country> areaRanking) {
        countryDao.saveCountries(areaRanking);
    }

    public Country getCountryById(Long id) {
        return countryDao.findCountryById(id);
    }

    public void saveCountry(Country entity) {
        countryDao.saveCountry(entity);
    }
}
