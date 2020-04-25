package homework20;

import java.io.FileNotFoundException;
import java.util.List;

public class CountryMain {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Country> countries = new CountryReader().readCountries("src/main/resources/countries2");
        final List<Country> countriess = new CountryReader().raedCountriesStream("src/main/resources/countries2");


        CountryService service = new CountryService(countries);


        // Green    System.out.println(service.getCountryName());

        // Green    System.out.println(service.getCapitalName("Romania"));

        // Green    System.out.println(service.getPopulation("Romania"));

        // Green    System.out.println(service.getCountriesOfContinent("Asia"));

        // Green    System.out.println(service.displayNeighbours("China"));

        // Green    System.out.println(service.getCountriesOnContinentLargerThenNumber("Asia",100000000L));

        // Green    System.out.println(service.sortContinent("Asia"));

        // Green    System.out.println(service.gotNeighbourXandNotY("SRB", "AUT"));

        // Green    System.out.println(service.sortCountryByArea("Asia"));

        //  No test Created --- but works   System.out.println(service.fromCountryToPopulation());

        //  No test Created --- but works   System.out.println(service.mapContinentToListOfStrings());

        //  No test Created  --- but works   System.out.println(service.mapContinentToListOfCountrySortedByPopulation());
    }
}
