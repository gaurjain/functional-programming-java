package com.gaurav.patterns.functionalprogrammingjava;

import com.gaurav.patterns.functionalprogrammingjava.model.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CollectorsExample {

    List<Person> persons = new ArrayList<>();

    {
        InputStream resource = null;
        try
        {   //Define an input stream of bytes over a file
            resource = new ClassPathResource("people.txt").getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("resource value is "+ resource);

        try (   // define a buffered reader over the inputstream.
                // Reads text from a character-input stream,
                // buffering characters so as to provide for the efficient reading of
                // characters, arrays, and lines.
                BufferedReader reader
                        = new BufferedReader(
                                new InputStreamReader(resource));

                //define or open a stream-of-String for lines read from the buffered reader defined
                // over the inputstream opened over the text file.
                Stream<String> lineStream = reader.lines()
        )
        {
            Function<String,Person> mapperFunction = l -> {
                String[] s = l.split(" "); //Split the line using ""
                Person p = new Person(s[0].trim(),Integer.parseInt(s[1])); //build a person instance
                persons.add(p); //add the person to the persons List.
                return p; //return the person object.
            };
            //define a stream pipeline to first map each lineString-element
            //from input stream-of-string-objects and return a stream-of-Person-objects and than
            //terminate by printing each Person-object from the stream.
            lineStream
                    .map(mapperFunction) //returns a stream-of-Person object
                    .forEach(System.out::println); //prints the elements of stream-of-Person object


        } catch (IOException e) {
            e.printStackTrace();
        }

        //open another Stream-of-Person on persons List.
        Stream<Person> streamOfPerson = persons.stream();

        //define a stream pipeline to return Person object with minimum age above 20, by first
        //filtering the input Stream-of-Person objects with age >= 20 predicate
        //and than terminating with a minimum operation to by comparing the Person's age.
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

        //define a stream pipeline that returns a concatenated string formed by first
        //filtering the streamOfPersons by age >= 20 predicate and
        //intermediately map to get the stream of names and lastly
        //applying a terminating collect operation that returns a String object by taking
        //a collector mutable reduction operation as the behavioral parameter,

        Stream<Person> stream3OfPerson = persons.stream();

        //Collectors.joining method, takes the characterSequence as a parameter and
        // applies a joining of names from the stream returning
        // a concatenated string using the charSequence as a delimiter.)
        Collector<CharSequence,?,String> collector = Collectors.joining(", ") ;
        String opt3 =
                stream3OfPerson
                        .filter(p->p.getAge()>=20)
                        .map(Person::getName)
                        .collect(collector);

        System.out.print("Collection of names of all persons above 20 year age " + opt3 + "\n");

        //define a stream pipeline that returns a map of Integer to List-of-String,
        //over the persons stream, by terminating with a collect(reducing) operation
        //to a list all Person::name strings, grouped by age key
        Collector<Person,?, Map<Integer, List<String>>> collector2 =
                Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName,Collectors.toList()
                        ));

        Map<Integer, List<String>> map =
                persons.stream()
                .collect(collector2);

        System.out.println(map);

    }


}
