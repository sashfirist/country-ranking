package ua.com.codespace.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.entities.Country;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Service
public class CountryService {

    private final Logger logger = Logger.getLogger(CountryService.class);

    @Autowired
    private CountryDao countryDao;

    public Country findCountry(int id){
        logger.info("CountryService: find country with id: " + id);
        return countryDao.findCountryById(id);
    }
}
