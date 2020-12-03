package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileFilter;

@Service
public class CallingJavaFileFilter {

    private File dir = new File("/Users/gjain19/Desktop/repos/java-8-whats-new/01/demos/src/org/paumard");

    //First way calling the FileFilter interface with concrete class.

    private FileFilter preLambdaConcreteJavaFileFilter  = new PreLambdaConcreteJavaFileFilter();
    private File[] fileList1 = dir.listFiles(preLambdaConcreteJavaFileFilter);

    {
        for (File f : fileList1) {
            System.out.println("filtered via Concrete Class implementation of the FileFilter interface : "+f);
        }
    }


    //Second way calling and inline implementing the FileFilter interface with Anonymous class implementation

    private FileFilter preLambdaAnonymousJavaFileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    };
    private File[] fileList2 = dir.listFiles(preLambdaAnonymousJavaFileFilter);

    {
        for (File f : fileList2) {
            System.out.println("filtered via Anonymous Class implementation of the FileFilter Interface : "+f);
        }
    }

    //Third way calling/implementing inline with a Lambda expression.

    private FileFilter JavaFileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");
    private File[] fileList3 = dir.listFiles(JavaFileFilterLambda);

    {
        for (File f : fileList3) {
            System.out.println("filtered via Lambda expression implementation of the FileFilter Interface : "+ f);
        }
    }

}
