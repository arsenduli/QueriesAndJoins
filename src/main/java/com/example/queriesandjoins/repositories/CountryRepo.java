package com.example.queriesandjoins.repositories;

import com.example.queriesandjoins.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends CrudRepository<Country , Long> {


    // 1 What query would you run to get all the countries that speak Slovene?
    // Your query should return the name of the country, language, and language percentage.
    // Your query should arrange the result by language percentage in descending order.

    @Query(value="SELECT name, language, percentage FROM countries\n" +
            "\t\t\tINNER JOIN languages\n" +
            "\t\t\tON countries.id = languages.country_id\n" +
            "\t\t\tWHERE language='Slovene'\n" +
            "\t\t\tORDER BY percentage DESC;", nativeQuery=true)
    List<Object[]> sloveneSpeakingCountries();


    @Query("SELECT c , l FROM Country c  JOIN c.languages l WHERE l.language= ?1  ORDER BY l.percentage DESC")
    List<Object[]> findAllCountryAndLanguages(String language);

   // 2 What query would you run to display the total number of cities for each country?
   // Your query should return the name of the country and the total number of cities.
   // Your query should arrange the result by the number of cities in descending order.
    @Query(value = "SELECT countries.name , SUM((case when cities.country_id then 1 else 0 end)) as total_cites FROM countries\n" +
           "\t\t\t JOIN cities\n" +
            "\t\t\t ON countries.id = cities.country_id\n" +
            "\t\t\t GROUP BY countries.id\n" +
            "\t\t\t ORDER BY total_cites DESC;" , nativeQuery = true)
    List<Object[]> mostCities();

    @Query("SELECT c , COUNT(ci) FROM Country c  JOIN c.cities ci GROUP BY c.id ORDER BY COUNT(ci) DESC")
    List<Object[]> findCountryWithMostCities();

   // 3 What query would you run to get all the cities in Mexico with a population of greater than 500,000?
   // Your query should arrange the result by population in descending order.
    @Query(value = "SELECT cities.name , cities.population FROM countries\n" +
            "\t\t\t JOIN cities ON countries.id = cities.country_id\n" +
           "\t\t\t WHERE countries.name = 'Mexico' and cities.population > 500000\n" +
            "\t\t\t ORDER BY cities.population DESC;" , nativeQuery = true)
     List<Object[]> mescioCites();

    @Query("SELECT c , ci FROM Country c JOIN c.cities ci WHERE c.name = ?1 and  ci.population > 500000 ORDER BY ci.population DESC ")
    List<Object[]> mexicos(String name);

   //4  What query would you run to get all languages in each country with a percentage greater than 89%?
   // Your query should arrange the result by percentage in descending order.
    @Query(value = "SELECT countries.name , languages.percentage FROM countries\n" +
            "\t\t\t JOIN languages ON countries.id = languages.country_id\n" +
            "\t\t\t WHERE languages.percentage >= 89\n" +
            "\t\t\t ORDER BY languages.percentage DESC;" , nativeQuery = true)
     List<Object[]> bigLang();

    @Query("SELECT c , l FROM Country c JOIN  c.languages l WHERE l.percentage >= 89 ORDER BY l.percentage DESC")
    List<Object[]> language();


    // 5 What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
    @Query(value = "SELECT countries.name , countries.surface_area , countries.population FROM countries\n" +
            "\t\t\t WHERE countries.surface_area < 501 AND countries.population >= 100000;" , nativeQuery = true)
     List<Object[]> surface();

    @Query("SELECT c FROM Country  c WHERE c.surface_area < 501  AND c.population >= 100000 ")
    List<Country> surfaceJpql();


    // 6 What query would you run to get countries with only Constitutional Monarchy
    // with a surface area of more than 200 and a life expectancy greater than 75 years?
    @Query(value = "SELECT countries.name ,  countries.surface_area , countries.government_form ,  countries.life_expectancy FROM countries\n" +
            "\t\t\t WHERE countries.government_form = 'Constitutional Monarchy' AND countries.surface_area >= 200 AND countries.life_expectancy >= 75;" , nativeQuery = true)
     List<Object[]> monarky();

    @Query("SELECT c FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area >= 200 AND c.life_expectancy >= 75 ")
    List<Country> monarchy();


   // 7 What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000?
    // The query should return the Country Name, City Name, District, and Population.

    @Query(value = "SELECT countries.name  as counrty, cities.name as cite , cities.district ,  cities.population FROM countries\n" +
            "\t\t\t JOIN cities ON countries.id = cities.country_id\n" +
            "\t\t\t WHERE countries.name = 'Argentina' AND  cities.district = 'Buenos Aires' AND cities.population >= 500000;" , nativeQuery = true)
    List<Object[]> argentina();

    @Query("SELECT c , ci FROM Country  c JOIN c.cities ci  WHERE c.name = 'Argentina' AND  ci.district = 'Buenos Aires' AND ci.population >= 500000")
    List<Object[]> argentinas();

   // 8 What query would you run to summarize the number of countries in each region?
   // The query should display the name of the region and the number of countries.
   // Also, the query should arrange the result by the number of countries in descending order.
    @Query(value = "SELECT countries.region  , SUM((case when region = region then 1 else 0 end)) as country FROM countries\n" +
            "\t\t\t GROUP BY countries.region\n" +
            "\t\t\t ORDER BY country DESC;", nativeQuery = true)
    List<Object[]> region();

    @Query("SELECT c.region , SUM((case when c.region = c.region then 1 else 0 end)) as country FROM Country  c  GROUP BY c.region  ORDER BY country DESC")
    List<Object[]> regionJpQl();


}
