package ua.com.codespace.controller;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.CountryDetails;
import ua.com.codespace.entities.InformationType;
import ua.com.codespace.service.CountryService;

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
        return getRankingByArea(model);
    }

    @RequestMapping(value = "/ranking/by/area", method = RequestMethod.GET)
    public String getRankingByArea(Model model) throws IOException {
        Map<Country, CountryDetails> areaRanking = countryService.getRankingByArea();
        if (areaRanking.isEmpty()) {
            areaRanking = countryService.parseRankingByArea();
            countryService.saveRankingByArea(areaRanking);
        }
        ArrayList columns = new ArrayList(Arrays.asList("Id", "Country", "Ranking", "Value", "Year", "Operation"));
        model.addAttribute("columns", columns);
        model.addAttribute("area", getRankingList(areaRanking));
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

    public ArrayList<Country> getRankingList(Map<Country, CountryDetails> areaRanking) {
        ArrayList<Country> aList = new ArrayList<>();
        for (Map.Entry<Country, CountryDetails> entry : areaRanking.entrySet()) {
            CountryDetails value = entry.getValue();
            Country key = entry.getKey();
            key.setCountryDetailList(new ArrayList<>(Arrays.asList(value)));
            aList.add(key);
        }
        logger.info("return ranking list");
        return aList;
    }

   /* @RequestMapping(value = "/ranking/by/life/duration", method = RequestMethod.GET)
    public String getRankingByLifeDuration(Model model) {
        Map<Country, CountryDetails> lifeDurationRanking = countryService.getRankingByLifeDuration();
        model.addAttribute("ranking", lifeDurationRanking);
        logger.info("return ranking by life duration");
        return "index";
    }

    @RequestMapping(value = "/ranking/by/life/quality", method = RequestMethod.GET)
    public String getRankingByLifeQuality(Model model) {
        Map<Country, CountryDetails> lifeQuality = countryService.getRankingByLifeQuality();
        model.addAttribute("ranking", lifeQuality);
        logger.info("return ranking by life quality");
        return "index";
    }*/
}
