package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReductionExample {

    List<Integer> listOfInteger = Arrays.asList(10,3,20);

    {
        Optional<Integer> red =
        listOfInteger.stream()
                .max(Integer::max);
        System.out.println("red " + red);

    }

}
