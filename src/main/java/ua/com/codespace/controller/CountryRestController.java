package ua.com.codespace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.codespace.model.Country;
import ua.com.codespace.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Country> getAllCountries(){
        return countryService.findAllCountries();
    }
}
