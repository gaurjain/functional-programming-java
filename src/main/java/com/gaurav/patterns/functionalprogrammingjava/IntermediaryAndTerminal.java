package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class IntermediaryAndTerminal {
    //1. Create a stream from a data source (in this case a generator function)
    Stream<String> stream = Stream.of("one","two","three","four","five");

    //2. Define predicate operations, as lambda expressions, to be passed as a behavioral parameters
    // (defining user-specified behaviors) in the stream operations.
    Predicate<String> p1 = p -> p.length() > 3;
    Predicate<String> p2 = p -> p.equals("two");

    List<String> list = new ArrayList<String>();

    {
        System.out.println("understanding the Intermediary and Terminal operations ");
        //3. declare a stream pipeline to conduct different operations only ones. It contains
        // 1. data source
        // 2. one or more intermediate operation (are lazy operations - do not get executed until terminal operation)
        // 3. a terminal operation (required to trigger execution of the stream pipeline,
        //    evaluation in one pass over the data from the data source.)
        // with each operation having passed its own list of behavioral parameters

        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .peek(s->list.add(s.replace("t","$")))
                .forEach(list::add);

        System.out.println("Done !");
        System.out.println(" print size of list " + list.size());
        System.out.println(list);

    }
}
