package ro.fasttrackit.curs20;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class PersonMain {
    public static void main(String[] args) {
        final List<String> cities = List.of("Oradea", "Cluj", "Bucuresti");

        final Random random = new Random();


        var persons = IntStream.range(1, 11)
                .mapToObj(index -> new Person("Name" + index,
                        random.nextInt(80),
                        cities.get(random.nextInt(cities.size()))))
                .collect(toList());

        System.out.println(persons);

        System.out.println(persons.stream()
                .mapToInt(Person::getAge)
                .average());

        //name-> age
        System.out.println(persons.stream()
                .collect(toMap(Person::getName, Person::getAge)));

        //city->[name]

        System.out.println(persons.stream()
                .collect(toMap(Person::getCity, p -> List.of(p.getName()), PersonMain::union)));

        System.out.println(persons.stream()
                .collect(toMap(
                        Person::getCity,
                        p -> List.of(p.getName()),
                        (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
                                .collect(Collectors.toList()))));

        System.out.println(
                persons.stream()
                        .collect(toMap(Person::getCity,
                                person -> (double) person.getAge(),
                                (age1, age2) -> (age1 + age2 / 2)))


        );


    }

    private static List<String> union(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>(l1);
        result.addAll(l2);
        return result;

    }

}
