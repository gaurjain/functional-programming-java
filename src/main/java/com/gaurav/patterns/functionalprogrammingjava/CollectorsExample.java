package com.gaurav.patterns.functionalprogrammingjava;

import com.gaurav.patterns.functionalprogrammingjava.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CollectorsExample {

    List<Person> persons = new ArrayList<>();

    {
        InputStream resource = null;
        try {
            resource = new ClassPathResource(
                    "people.txt").getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("resource value is "+ resource);

        try (
                BufferedReader reader
                        = new BufferedReader(
                                new InputStreamReader(resource));
                Stream<String> stream = reader.lines();
        ) {
            System.out.println(stream);
            stream
                    .map(line->{
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(),Integer.parseInt(s[1]));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Person> streamOfPerson = persons.stream();
        Optional<Person> opt =
        streamOfPerson
                .filter(p->p.getAge()>=20)
                .min(Comparator.comparing(Person::getAge));

        System.out.print("The youngest person above 20 years age is " + opt + "\n");

        Stream<Person> stream2OfPerson = persons.stream();
        Optional<Person> opt2 =
                stream2OfPerson
                        .filter(p->p.getAge()>=20)
                        .max(Comparator.comparing(Person::getAge));

        System.out.print("The oldest person above 20 years age is " + opt2 + "\n");

        Map<Integer, List<String>> map =
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList())));

        System.out.println(map);

    }


}
