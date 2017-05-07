package ua.com.codespace.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        Country country = countryService.findById(id);
        if(country == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(country,HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        if (countryService.findByName(country.getName())!= null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            countryService.saveCountry(country);
            return new ResponseEntity<>(country,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country newCountry){
        Country oldCountry = countryService.findById(id);
        if (oldCountry == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            oldCountry.setName(newCountry.getName());
            oldCountry.setCountryDetails(newCountry.getCountryDetails());
            countryService.updateCountry(oldCountry);
            return new ResponseEntity<>(oldCountry,HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Country> deleteCountryById(@PathVariable Long id){
        Country country = countryService.findById(id);
        if (country == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            countryService.deleteCountryByName(country.getName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
