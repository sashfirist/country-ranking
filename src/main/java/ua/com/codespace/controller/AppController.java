package ua.com.codespace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.codespace.service.jsoup.DataPersistence;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    DataPersistence dataPersistence;

    @RequestMapping({"","/addinfo"})
    public String getInformation (){
        return "addinfo";
    }

    @RequestMapping("/area")
    public String getArea (){
        dataPersistence.saveArea();
        return "redirect:addinfo";
    }

    @RequestMapping("/pop")
    public String getPop(){
        dataPersistence.savePopulation();
        return "redirect:addinfo";
    }

    @RequestMapping("/duration")
    public String getDuration(){
        dataPersistence.saveAvgLifeDuration();
        return "redirect:addinfo";
    }

    @RequestMapping("/lqindex")
    public String getIndex(){
        dataPersistence.saveLifeQualityIndex();
        return "redirect:addinfo";
    }
}
