package com.example.queriesandjoins.services;

import com.example.queriesandjoins.models.Country;
import com.example.queriesandjoins.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServices {
    @Autowired
    private CountryRepo countryRepo;

    public CountryServices(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Object[]> speakeSlovene(){
        return countryRepo.sloveneSpeakingCountries();
    }
    public List<Object[]> mostCitess(){
        return countryRepo.mostCities();
    }
    public List<Object[]> mesicoCitess(){
        return countryRepo.mescioCites();
    }
    public List<Object[]> bigLanguages(){
        return countryRepo.bigLang();
    }
    public List<Object[]> surface(){
        return countryRepo.surface();
    }
    public List<Object[]> monarkye(){
        return countryRepo.monarky();
    }
    public List<Object[]> messi(){
        return countryRepo.argentina();
    }
    public List<Object[]> region(){
        return countryRepo.region();
    }

public List<Object[]> getAll(String language){
        return countryRepo.findAllCountryAndLanguages(language);
}
public List<Object[]> mostC(){
        return countryRepo.findCountryWithMostCities();
}
public List<Object[]> mexico(String name){
        return countryRepo.mexicos(name);
}

public List<Object[]> big(){
        return countryRepo.language();
}
public List<Country> surfaceJpql(){
        return countryRepo.surfaceJpql();
}
    public List<Country> monarchy(){
        return countryRepo.monarchy();
    }
    public List<Object[]> argentinas(){
        return countryRepo.argentinas();
    }

    public  List<Object[]> regionJpQl(){
        return countryRepo.regionJpQl();
    }
}
