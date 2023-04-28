package com.example.queriesandjoins.controllers;

import com.example.queriesandjoins.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainControllers {

    @Autowired
    private CountryServices countryServices;

    @GetMapping("/")
    private String index(Model model){
        List<Object[]> sloveneSpeak = countryServices.speakeSlovene();
        model.addAttribute("slovene" , sloveneSpeak);
        List<Object[]> mostCites = countryServices.mostCitess();
        model.addAttribute("cites"  ,mostCites);
        List<Object[]> mescio = countryServices.mesicoCitess();
        model.addAttribute("mescko"  ,mescio);
        List<Object[]> bigLag = countryServices.bigLanguages();
        model.addAttribute("lang"  ,bigLag);
        model.addAttribute("surface"  ,countryServices.surface());
        model.addAttribute("monarky"  ,countryServices.monarkye());
        model.addAttribute("messi"  ,countryServices.messi());
        model.addAttribute("region"  ,countryServices.region());
        model.addAttribute("allCountry" , countryServices.getAll("Slovene"));
        model.addAttribute("mossttt" , countryServices.mostC());
        model.addAttribute("mexico" , countryServices.mexico("Mexico"));
        model.addAttribute("langu" , countryServices.big());
        model.addAttribute("surfaceJpql" , countryServices.surfaceJpql());
        model.addAttribute("monarchys" , countryServices.monarchy());
        model.addAttribute("argentinas" , countryServices.argentinas());
        model.addAttribute("regionJpQl" , countryServices.regionJpQl());
        return "index";
    }
}
