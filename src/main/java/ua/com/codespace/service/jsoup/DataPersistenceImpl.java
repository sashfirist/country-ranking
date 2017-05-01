package ua.com.codespace.service.jsoup;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.model.Country;
import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.io.IOException;

@Service
public class DataPersistenceImpl implements DataPersistence {

    @Autowired
    private DataExtraction dataExtraction;

    @Autowired
    private CountryDao countryDao;

    public void savePopulation() throws IOException {
        Elements elements = dataExtraction.getPopulation();
        for (Element element : elements) {
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("[class]").text()
                    .replaceAll("\\s+","")));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.POPULATION);
            country.getCountryDetailsList().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void saveArea() throws IOException {
        Elements elements = dataExtraction.getArea();
        for (Element element : elements) {
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("[class]").text()
                    .replaceAll("\\s+", "")));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.AREA);
            country.getCountryDetailsList().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void saveAvgLifeDuration() throws IOException {
        Elements elements = dataExtraction.getAvgLifeDuration();
        for (Element element : elements){
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("[class]").eq(0).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.AVG_LIFE_DURATION);
            country.getCountryDetailsList().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void saveLifeQualityIndex() throws IOException {
        Elements elements = dataExtraction.getLifeQualityIndex();
        for (Element element : elements){
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("td").eq(2).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2016);
            countryDetails.setInformation(InformationType.LIFE_QUALITY_INDEX);
            country.getCountryDetailsList().add(countryDetails);
            countryDao.save(country);
        }
    }
}
