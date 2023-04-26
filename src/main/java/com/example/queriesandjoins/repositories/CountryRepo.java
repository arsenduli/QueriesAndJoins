package com.example.queriesandjoins.repositories;

import com.example.queriesandjoins.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends CrudRepository<Country , Long> {


    @Query(value="SELECT name, language, percentage FROM countries\n" +
            "\t\t\tINNER JOIN languages\n" +
            "\t\t\tON countries.id = languages.country_id\n" +
            "\t\t\tWHERE language='Slovene'\n" +
            "\t\t\tORDER BY percentage DESC;", nativeQuery=true)
    List<Object[]> sloveneSpeakingCountries();



    @Query(value = "SELECT countries.name , SUM((case when cities.country_id then 1 else 0 end)) as total_cites FROM countries\n" +
           "\t\t\t JOIN cities\n" +
            "\t\t\t ON countries.id = cities.country_id\n" +
            "\t\t\t GROUP BY countries.id\n" +
            "\t\t\t ORDER BY total_cites DESC;" , nativeQuery = true)
    List<Object[]> mostCities();


    @Query(value = "SELECT cities.name , cities.population FROM countries\n" +
            "\t\t\t JOIN cities ON countries.id = cities.country_id\n" +
           "\t\t\t WHERE countries.name = 'Mexico' and cities.population > 500000\n" +
            "\t\t\t ORDER BY cities.population DESC;" , nativeQuery = true)
     List<Object[]> mescioCites();

    @Query(value = "SELECT countries.name , languages.percentage FROM countries\n" +
            "\t\t\t JOIN languages ON countries.id = languages.country_id\n" +
            "\t\t\t WHERE languages.percentage >= 89\n" +
            "\t\t\t ORDER BY languages.percentage DESC;" , nativeQuery = true)
     List<Object[]> bigLang();

    @Query(value = "SELECT countries.name , countries.surface_area , countries.population FROM countries\n" +
            "\t\t\t WHERE countries.surface_area < 501 AND countries.population >= 100000;" , nativeQuery = true)
     List<Object[]> surface();

    @Query(value = "SELECT countries.name ,  countries.surface_area , countries.government_form ,  countries.life_expectancy FROM countries\n" +
            "\t\t\t WHERE countries.government_form = 'Constitutional Monarchy' AND countries.surface_area >= 200 AND countries.life_expectancy >= 75;" , nativeQuery = true)
     List<Object[]> monarky();

    @Query(value = "SELECT countries.name  as counrty, cities.name as cite , cities.district ,  cities.population FROM countries\n" +
            "\t\t\t JOIN cities ON countries.id = cities.country_id\n" +
            "\t\t\t WHERE countries.name = 'Argentina' AND  cities.district = 'Buenos Aires' AND cities.population >= 500000;" , nativeQuery = true)
    List<Object[]> argentina();

    @Query(value = "SELECT countries.region  , SUM((case when region = region then 1 else 0 end)) as country FROM countries\n" +
            "\t\t\t GROUP BY countries.region\n" +
            "\t\t\t ORDER BY country DESC;", nativeQuery = true)
    List<Object[]> region();



}
