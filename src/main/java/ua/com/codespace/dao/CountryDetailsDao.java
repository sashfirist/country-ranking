package ua.com.codespace.dao;

import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.util.List;

public interface CountryDetailsDao {

    List<CountryDetails> getAllCountryDetails();
    CountryDetails getById(long id);
    CountryDetails getByYear(int year);
    CountryDetails getByInformationName(InformationType information);
    void save(CountryDetails countryDetails);
    void deleteCountryDetails(CountryDetails countryDetails);
}
