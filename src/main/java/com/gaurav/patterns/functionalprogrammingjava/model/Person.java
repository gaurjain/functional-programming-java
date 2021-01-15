package com.gaurav.patterns.functionalprogrammingjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Resource;


@Data
@AllArgsConstructor
@Resource
public class Person {
    private String name;
    private Integer age;

}
