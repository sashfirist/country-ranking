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

    public Map<Country, CountryDetails> getRankingByArea() {
        List<Country> rankingByArea = countryDao.findRankingByArea();
        Map<Country, CountryDetails> cntMap = new HashMap<>();
        for(Country item : rankingByArea){
            cntMap.put(item, item.getCountryDetailList().get(0));
        }
        return cntMap;
    }

    public Map<Country, CountryDetails> parseRankingByArea() throws IOException {
        URL url = new URL("http://ostranah.ru/_lists/population.php");
        Document doc = Jsoup.parse(url, 3000);
        Elements rows = doc.select("table#sort-table tr");
        Map<Country, CountryDetails> cntMap = new HashMap<>();
        GregorianCalendar gr = new GregorianCalendar();
        gr.setTime(new Date());

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            String id = row.select("th").text();
            String countryName = row.select("td > a").text();
            String population = row.select("td.digits").text().replace(" ", "");

            CountryDetails cD = new CountryDetails();
            cD.setInformation(InformationType.AREA);
            cD.setValue(Double.parseDouble(population));
            cD.setYear(gr.get(Calendar.YEAR));

            Country country = new Country();
            country.setName(countryName);
            country.setId(Integer.parseInt(id));

            cntMap.put(country, cD);
        }
        return cntMap;
    }

    public void saveRankingByArea( Map<Country, CountryDetails> areaRanking) {
        countryDao.saveCountries(areaRanking);
    }

    public Country getCountryById(Long id) {
        return countryDao.findCountryById(id);
    }

    public void saveCountry(Country entity) {
        countryDao.saveCountry(entity);
    }
}
