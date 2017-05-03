package ua.com.codespace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codespace.dao.CountryDao;
import ua.com.codespace.model.Country;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country findById(long id) {
        return countryDao.getById(id);
    }

    public Country findByName(String name) {
        return countryDao.getByName(name);
    }

    public void saveCountry(Country country) {
        countryDao.save(country);
    }

    public void updateCountry(Country country) {
        Country entity = countryDao.getById(country.getId());
        if(entity!=null){
            entity.setName(country.getName());
            entity.setCountryDetails(country.getCountryDetails());
        }
    }

    public void deleteCountryByName(String name) {
        countryDao.deleteByName(name);
    }

    public List<Country> findAllCountries() {
        return countryDao.getAllCountries();
    }
}
