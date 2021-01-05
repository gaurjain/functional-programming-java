package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Service
public class ChainConsumers {

    List<? extends String> strings = Arrays.asList("******", "*","*****","**","*********");
    List<String> result = new ArrayList<>();

    Consumer<String> printLambda = s -> System.out.println("Printing strings from the list : " + s);
    Consumer<String> printMethodReference = System.out::println;
    Consumer<String> addToResultLambda = s ->result.add(s.replace("*","#"));

    {
        strings.forEach(printLambda.andThen(addToResultLambda));
        System.out.println("printing from result List now  ....");
        result.forEach(printMethodReference);
    }



}
