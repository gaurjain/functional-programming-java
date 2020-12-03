package com.gaurav.patterns.functionalprogrammingjava;

import java.io.File;
import java.io.FileFilter;

public class PreLambdaConcreteJavaFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
