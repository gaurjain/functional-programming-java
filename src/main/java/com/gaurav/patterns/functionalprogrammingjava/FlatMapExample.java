package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Service
public class FlatMapExample {

    List<Integer> listNumbers = Arrays.asList(1,2,3,4,5,6,7);
    List<Integer> listEven = Arrays.asList(2,4,6);
    List<Integer> listOdd = Arrays.asList(3,5,7);
    List<List<Integer>> listOfList = Arrays.asList(listNumbers,listEven,listOdd);

    //Behavioral parameter for map.
    //takes an element from a stream of List-of-Object type and
    //returns an element object of Integer type.
    Function<List<?>,Integer> sizeMapper = l->l.size();

    //Behavioral parameter for flatmap.
    //takes an element object from a stream of List-of-Integer type and
    //returns an element object of Stream-of-Integer type
    Function<List<Integer>, Stream<Integer>> flatMapper = l->l.stream();

    {
        System.out.println("print the listOfList \n" + listOfList);

        listOfList.stream()
                //.map(sizeMapper)
                // takes a function lambda expression,
                // which applies the operation on element of the stream and
                // returns an object as per function definition,
                // and map operations returns a stream-of-object.
                .map(flatMapper)
                // takes a function lambda expression
                // which applies the operation on element of the stream and
                // returns a stream object as per function definition,
                // and map operation returns a stream-of-stream object with 3 stream-elements.
                //.flatMap(flatMapper)
                //for Flattening the stream. takes a function lambda expression,
                // which returns a stream object as per function definition,
                // and flatmap operation flattens it to return
                // a stream object with 13 elements instead of a stream-of-stream object.
                .forEach(System.out::println);

    }

}
