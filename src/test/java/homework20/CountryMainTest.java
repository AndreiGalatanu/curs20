package homework20;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.MapAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class CountryMainTest {

    private CountryService service;


    @BeforeEach
    void setup() {
        service = new CountryService(List.of(
                new Country("Romania", "Bucharest", 19861408, 238391, "Europe", List.of("BGR", "HUN", "MDA", "SRB", "UKR")),
                new Country("Hungary", "Budapest", 9823000, 93028, "Europe", List.of("AUT", "HRV", "ROU", "SRB", "SVK", "SVN", "UKR"))
        ));
    }

    @Test
    @DisplayName("The country names are displayed correct")
    void countryNames() {

        List<String> result = service.getCountryName();
        assertThat(result).containsExactly("Romania", "Hungary");
    }

    @Test
    @DisplayName("While country is Romania capital is Bucharest")
    void capitalNames() {

        assertThat(service.getCapitalName("Romania")).contains("Bucharest");
    }

    @Test
    @DisplayName("WHILE Romania then show 19861408 as population")
    void countryPopulation() {
        var result = service.getPopulation("Romania");
        assertThat(result).contains(19861408L);

    }

    @Test
    @DisplayName("While RO/HU are EU then pass")
    void continentalCountries() {
        var result = service.getCountriesOfContinent("Europe");
        assertThat(result).containsExactly("Romania", "Hungary");
    }

    @Test
    @DisplayName("While Romania  present the list of neighbours")
    void displayNeighbours() {

        var result = service.displayNeighbours("Romania");
        assertThat(result).contains(List.of("BGR", "HUN", "MDA", "SRB", "UKR"));

    }

    @Test
    @DisplayName("Find countries larger then Hungary print Romania")
    void displayCountriesOnContinentLargerThenN() {
        var result = service.getCountriesOnContinentLargerThenNumber("Europe", 9823000);
        assertThat(result).contains("Romania");

    }

    @Test
    @DisplayName("Country that neighbour X but not neighbour Y")
    void neighbourTest() {
        var result = service.gotNeighbourXandNotY("SRB", "AUT");
        assertThat(result).containsExactly("Romania");
    }


    @Test
    @DisplayName("SortContinent by Population")
    void sortContinent() {
        var result = service.sortContinent("Europe");
        assertThat(result).containsExactly("Hungary", "Romania");
    }

    @Test
    @DisplayName("Countries sorted by area")
    void CountryByArea() {
        var result = service.sortCountryByArea("Europe");
        assertThat(result).contains("Hungary", "Romania");
    }

 /*   @Test
    @DisplayName("Map country to population")
    void countryToPopulationTest() {
        var result = service.mapFromCountryToPopulation();
        assertThat(result).contains(MAP<"Romania",19861408>);
    }
*/


}