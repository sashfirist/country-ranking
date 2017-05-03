package ua.com.codespace.service;

import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.util.List;

public interface CountryDetailsService {

    CountryDetails findById(long id);
    CountryDetails findByYear(int year);
    CountryDetails findByInformationType(InformationType informationType);
    void saveCountryDetails(CountryDetails countryDetails);
    void updateCountryDetails(CountryDetails countryDetails);
    void deleteCountryDetails(CountryDetails countryDetails);
    List<CountryDetails> findAllCountryDetails();
}
