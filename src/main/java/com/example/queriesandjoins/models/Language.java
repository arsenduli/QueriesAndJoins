package com.example.queriesandjoins.models;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country_code;
    private String language;
    private String is_official;
    private Double percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id" )
    private Country countrys;
    public Language() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String coutnry_code) {
        this.country_code = coutnry_code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIs_official() {
        return is_official;
    }

    public void setIs_official(String is_official) {
        this.is_official = is_official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }


    public Country getCountrys() {
        return countrys;
    }

    public void setCountrys(Country countrys) {
        this.countrys = countrys;
    }
}
