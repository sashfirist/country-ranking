package ua.com.codespace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codespace.dao.CountryDetailsDao;
import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.util.List;

@Service
@Transactional
public class CountryDetailsServiceImpl implements CountryDetailsService {

    @Autowired
    private CountryDetailsDao countryDetailsDao;

    public CountryDetails findById(long id) {
        return countryDetailsDao.getById(id);
    }

    public CountryDetails findByYear(int year) {
        return countryDetailsDao.getByYear(year);
    }

    public CountryDetails findByInformationType(InformationType informationType) {
        return countryDetailsDao.getByInformationType(informationType);
    }

    public void saveCountryDetails(CountryDetails countryDetails) {
        countryDetailsDao.save(countryDetails);
    }

    public void updateCountryDetails(CountryDetails countryDetails) {
        CountryDetails entity = countryDetailsDao.getById(countryDetails.getId());
        if(entity!=null){
            entity.setInformation(countryDetails.getInformation());
            entity.setYear(countryDetails.getYear());
            entity.setCountry(countryDetails.getCountry());
            entity.setValue(countryDetails.getValue());
        } else {
            countryDetailsDao.save(countryDetails);
        }
    }

    public void deleteCountryDetails(CountryDetails countryDetails) {
        countryDetailsDao.deleteCountryDetails(countryDetails);
    }

    public List<CountryDetails> findAllCountryDetails() {
        return countryDetailsDao.getAllCountryDetails();
    }
}
