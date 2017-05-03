package ua.com.codespace.service;

import ua.com.codespace.model.Country;

import java.util.List;

public interface CountryService {

    Country findById(long id);
    Country findByName(String name);
    void saveCountry(Country country);
    void updateCountry(Country country);
    void deleteCountryByName(String name);
    List<Country> findAllCountries();

}
