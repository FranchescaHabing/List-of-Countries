package com.example.listofcountries;

public class Country {
    String countryN, capital, region, abbreviation, callingCodes, population, currencies, languages, borders;
    int imageId;

    public Country(String countryN, String capital, String region, String abbreviation, String callingCodes, String population, String currencies, String languages, String borders, int imageId) {
        this.countryN = countryN;
        this.capital = capital;
        this.region = region;
        this.abbreviation = abbreviation;
        this.callingCodes = callingCodes;
        this.population = population;
        this.currencies = currencies;
        this.languages = languages;
        this.borders = borders;
        this.imageId = imageId;
    }
}
