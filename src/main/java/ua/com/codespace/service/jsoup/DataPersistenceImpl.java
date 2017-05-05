package ua.com.codespace.service.jsoup;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.dao.CountryDetailsDao;
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

    @Autowired
    private CountryDetailsDao countryDetailsDao;

    public void saveArea(){
        Elements elements = dataExtraction.getArea();
        for (Element element : elements) {
            Country country = countryDao.getByName(element.select("a").text());
            if (country == null){
                country = new Country();
                country.setName(element.select("a").text());
            }
            CountryDetails countryDetails = new CountryDetails();
            countryDetails.setValue(Double.valueOf(element.select("[class]").text()
                    .replaceAll("\\s+", "")));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.AREA);
            country.getCountryDetails().add(countryDetails);
            countryDetailsDao.save(countryDetails);
        }
    }

    public void savePopulation(){
        Elements elements = dataExtraction.getPopulation();
        for (Element element : elements) {
            Country country = countryDao.getByName(element.select("a").text());
            if (country == null){
                country = new Country();
                country.setName(element.select("a").text());
            }
            CountryDetails countryDetails = new CountryDetails();
            countryDetails.setValue(Double.valueOf(element.select("[class]").text()
                    .replaceAll("\\s+","")));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.POPULATION);
            country.getCountryDetails().add(countryDetails);
            countryDetailsDao.save(countryDetails);
        }
    }

    public void saveAvgLifeDuration(){
        Elements elements = dataExtraction.getAvgLifeDuration();
        for (Element element : elements){
            Country country = countryDao.getByName(element.select("a").text());
            if (country == null){
                country = new Country();
                country.setName(element.select("a").text());
            }
            CountryDetails countryDetails = new CountryDetails();
            countryDetails.setValue(Double.valueOf(element.select("[class]").eq(0).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2017);
            countryDetails.setInformation(InformationType.AVG_LIFE_DURATION);
            country.getCountryDetails().add(countryDetails);
            countryDetailsDao.save(countryDetails);
        }
    }

    public void saveLifeQualityIndex(){
        Elements elements = dataExtraction.getLifeQualityIndex();
        for (Element element : elements){
            Country country = countryDao.getByName(element.select("td").eq(1).text());
            if (country == null){
                country = new Country();
                country.setName(element.select("a").text());
            }
            CountryDetails countryDetails = new CountryDetails();
            countryDetails.setValue(Double.valueOf(element.select("td").eq(2).text()));
            countryDetails.setCountry(country);
            countryDetails.setYear(2016);
            countryDetails.setInformation(InformationType.LIFE_QUALITY_INDEX);
            country.getCountryDetails().add(countryDetails);
            countryDetailsDao.save(countryDetails);
        }
    }
}
