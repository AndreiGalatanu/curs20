package homework20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountryReader {


    public List<Country> readCountries(String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(filename));
        List<Country> result = new ArrayList<>();
        while (scanner.hasNextLine()) {


            result.add(readCountry(scanner.nextLine()));

        }

        return result;
    }


    public List<Country> raedCountriesStream(String filename) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filename))
                .lines()
                .map(this::readCountry)
                .collect(Collectors.toList());

    }


    private Country readCountry(String line) {
        final String[] tokens = line.split("[|]");

        return new Country(
                tokens[0],
                tokens[1],
                Long.parseLong(tokens[2]),
                Long.parseLong(tokens[3]),
                tokens[4],
                tokens.length > 5 ? parseNeighbours(tokens[5]) : Collections.emptyList()
        );

    }

    private List<String> parseNeighbours(String neighbours) {
        Scanner nscanner = new Scanner(neighbours);
        nscanner.useDelimiter("~");
        List<String> result = new ArrayList<>();
        while (nscanner.hasNext()) {

            result.add(nscanner.next());
        }
        return result;

    }
}