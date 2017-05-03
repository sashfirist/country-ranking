package ua.com.codespace.dao;

import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.util.List;

public interface CountryDetailsDao {

    CountryDetails getById(long id);
    CountryDetails getByYear(int year);
    CountryDetails getByInformationType(InformationType informationType);
    void save(CountryDetails countryDetails);
    void deleteCountryDetails(CountryDetails countryDetails);
    List<CountryDetails> getAllCountryDetails();
}
