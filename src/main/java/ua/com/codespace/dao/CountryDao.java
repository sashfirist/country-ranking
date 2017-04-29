package ua.com.codespace.dao;

import ua.com.codespace.model.Country;

import java.util.List;

public interface CountryDao {

    List<Country> getAllCountries();
    Country getById(long id);
    Country getByName(String name);
    void save(Country country);
    void deleteByName(String name);
}
