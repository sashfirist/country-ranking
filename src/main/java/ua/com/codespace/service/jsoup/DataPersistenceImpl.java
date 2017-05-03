package ua.com.codespace.service.jsoup;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.model.Country;
import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

@Service
@Transactional
public class DataPersistenceImpl implements DataPersistence {

    @Autowired
    private DataExtraction dataExtraction;

    @Autowired
    private CountryDao countryDao;

    public void saveArea(){
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
            country.getCountryDetails().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void savePopulation(){
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
            country.getCountryDetails().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void saveAvgLifeDuration(){
        Elements elements = dataExtraction.getAvgLifeDuration();
        for (Element element : elements){
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("[class]").eq(0).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.AVG_LIFE_DURATION);
            country.getCountryDetails().add(countryDetails);
            countryDao.save(country);
        }
    }

    public void saveLifeQualityIndex(){
        Elements elements = dataExtraction.getLifeQualityIndex();
        for (Element element : elements){
            Country country = new Country();
            CountryDetails countryDetails = new CountryDetails();
            country.setName(element.select("a").text());
            countryDetails.setValue(Double.valueOf(element.select("td").eq(2).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2016);
            countryDetails.setInformation(InformationType.LIFE_QUALITY_INDEX);
            country.getCountryDetails().add(countryDetails);
            countryDao.save(country);
        }
    }
}
