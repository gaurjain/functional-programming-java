package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class FirstPredicates {
    //1. Create a stream from a data source (in this case a generator function)
    Stream<String> stream = Stream.of("one","two","three","four","five");

    //2. Define predicate operations, as lambda expressions, to be passed as a behavioral parameters
    // (defining user-specified behaviors) in the stream operations.
    Predicate<String> p1 = p -> p.length() > 3;
    Predicate<String> p2 = p -> p.equals("two");


    {
        System.out.println("Java 8 Stream are monads that supports operations like map, filter, forEach, reduce etc. ");

    //3. declare a stream pipeline to conduct different operations only ones. It contains
        // 1. data source
        // 2. one or more intermediate operation
        // 3. a terminal operation
        // with each operation having passed its own list of behavioral parameters
        stream
                .filter(p2.or(p1))
                .forEach(System.out::println);

        /* will error out, since a stream can only be invoked one with a terminal operation.
           error : stream has already been operated upon or closed
        stream
                .filter(p1.or(p2))
                .forEach(System.out::println);
        */


    }



}
