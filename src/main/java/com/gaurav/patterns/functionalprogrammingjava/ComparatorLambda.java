package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class ComparatorLambda {

    //Anonymous class implementation of the Comparator interface.
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(),o2.length());
        }
    };


    //lambda expression implementation of the Comparator interface.
    Comparator<String> comparatorLambda = (o1,o2) -> Integer.compare(o1.length(),o2.length());

    {
        List<String> list = Arrays.asList("$","$$$","$$","$$$$$","$$$$");
        //Collections.sort(list,comparator);
        list.sort(comparatorLambda);
        for (String l :list) {
            System.out.println(l);
        }

    }


}
