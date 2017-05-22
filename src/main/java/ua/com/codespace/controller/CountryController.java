package ua.com.codespace.controller;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.CountryDetails;
import ua.com.codespace.entities.InformationType;
import ua.com.codespace.service.CountryService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Created by kernel32 on 05.05.2017.
 */
@Controller
@RequestMapping({"/", "/index"})
public class CountryController {

    private final Logger logger = Logger.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllRankings(Model model) throws IOException {
        logger.info("return main page with ranking");
        return "index";
    }

    @RequestMapping(value = "/ranking/{rank}", method = RequestMethod.GET)
    public String getRankingByArea(@PathVariable(value="rank") final String ranking, Model model, HttpServletRequest req) throws IOException {
        List<Country> countryRanking = countryService.getRankingType(ranking);
        if (countryRanking.isEmpty()) {
            countryRanking = countryService.parseRanking(ranking);
            countryService.saveRankingByArea(countryRanking);
        }
        ArrayList columns = new ArrayList(Arrays.asList("Id", "Country", "Ranking", "Value", "Year", "Operation"));
        model.addAttribute("columns", columns);
        model.addAttribute("area", countryRanking);
        logger.info("return ranking by area");
        return "index";
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.GET)
    public String getCountry(@PathVariable(value="id") final Long id, Model m) {
        Country cnt = countryService.getCountryById(id);
        m.addAttribute("item", cnt);
        logger.info("return country by id");
        return "form";
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.POST)
    public String saveCountry(@ModelAttribute("item") Country entity, Model model) {
        countryService.saveCountry(entity);
        logger.info("save edited country");
        return "redirect:/";
    }
}
