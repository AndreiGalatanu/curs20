package homework20;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = ofNullable(countries)// daca   nu are valoare
                .map(ArrayList::new)    //daca --ESTE--- Mappeaza lista
                .orElseGet(ArrayList::new); //daca ---NU--- e nimic fac arrau list


    }


    public List<String> getCountryName() {

        return countries.stream()
                .map(Country::getName)
                .collect(toList());

    }


    public Optional<String> getCapitalName(String country) {

        return countries.stream()
                .filter(country1 -> country1.getName().equals(country))
                .map(Country::getCapital)
                .findFirst()
                ;
    }

    public Optional<Long> getPopulation(String country) {
        return countries.stream()
                .filter(c -> c.getName().equals(country))
                .map(Country::getPopulation)
                .findFirst();

    }

    public List<String> getCountriesOfContinent(String continent) {
        return countries.stream()

                .filter(c -> c.getContinent().equals(continent))
                .map(Country::getName)
                .collect(toList())
                ;

    }


    public List<List<String>> displayNeighbours(String country) {
        return countries.stream()
                .filter(c -> c.getName().equals(country))
                .map(Country::getNeighbours)
                .collect(toList());
    }

    public List<String> getCountriesOnContinentLargerThenNumber(String continent, long largerThen) {

        return countries.stream()
                .filter(c -> c.getContinent().equals(continent))
                .filter(p -> p.getPopulation() > largerThen)
                .map(Country::getName)
                .collect(toList());


    }

    public List<String> sortContinent(String continent) {

        return countries.stream()

                .filter(country -> country.getContinent().equals(continent))
                .sorted(Comparator.comparing(Country::getPopulation))
                .map(Country::getName)
                .collect(toList());


    }


    public List<String> gotNeighbourXandNotY(String haveNeighbour, String notNeighbour) {

        return countries.stream()
                .filter(country -> country.getNeighbours().contains(haveNeighbour) && !country.getNeighbours().contains(notNeighbour))
                .map(Country::getName)
                .collect(toList());


    }


    public List<String> sortCountryByArea(String continent) {
        return countries.stream()
                .filter(s -> s.getContinent().equals(continent))
                .sorted(Comparator.comparing(Country::getArea))
                .map(Country::getName)
                .collect(toList());


    }

    public Map<String, Long> mapFromCountryToPopulation() {

        return countries.stream()
                .collect(toMap(Country::getName,
                        Country::getPopulation));


    }

    public Map<String, List<String>> mapContinentToListOfCountries() {
        return countries.stream()
                .collect(toMap(Country::getContinent,
                        country -> List.of(country.getName())
                        , (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
                                .collect(toList())));


    }

    public Map<String, List<String>> mapContinentToListOfCountrySortedByPopulation() {
        return countries.stream()
                .sorted(Comparator.comparing(Country::getPopulation))
                .collect(toMap(Country::getContinent,
                        country -> List.of(country.getName())
                        , (l1, l2) -> Stream.concat(l1.stream(), l2.stream())

                                .collect(toList())));


    }


}

