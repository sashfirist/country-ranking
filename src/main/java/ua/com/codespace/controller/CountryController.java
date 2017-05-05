package ua.com.codespace.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Controller
@RequestMapping({"/", "/index"})
public class CountryController {

    private final Logger logger = Logger.getLogger(CountryController.class);

    @RequestMapping(method = GET)
    public String welcome(Model model) {
        logger.info("came to web root directory");
        return "index";
    }
}
