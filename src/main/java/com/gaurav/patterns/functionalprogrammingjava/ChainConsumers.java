package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Service
public class ChainConsumers {

    List<String> strings = Arrays.asList("******", "*","*****","**","*********");
    List<String> result = new ArrayList();
    Consumer<String> print1 = s -> System.out.println(s);
    Consumer<String> print2 = System.out::println;
    Consumer<String> addToResult = s -> result.add(s.replace("*","5").concat("#"));


    {
        //strings.forEach(c1);
        strings.forEach(print1.andThen(addToResult));
        result.forEach(System.out::println);


    }



}
