package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileFilter;

@Service
public class CallingJavaFileFilter {

    private File dir = new File("/Users/gjain19/Desktop/repos/java-8-whats-new/01/demos/src/org/paumard");

    //1. using the concrete class implementation of the functional interface.
    //private FileFilter preLambdaConcreteClassFileFilter  = new PreLambdaConcreteClassFileFilter();
    //private File[] fileList1 = dir.listFiles(preLambdaConcreteClassFileFilter);
    private File[] fileList1 = dir.listFiles(new PreLambdaConcreteClassFileFilter());

    {
        for (File f : fileList1) {
            System.out.println("filtered via Concrete Class implementation of the FileFilter interface : "+f);
        }
    }


    //2. using the inline Anonymous class implementation of the FileFilter interfaces.
    /*private FileFilter preLambdaAnonymousClassFileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    };
    private File[] fileList2 = dir.listFiles(preLambdaAnonymousClassFileFilter);
    */
    private File[] fileList2 = dir.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    });

    {
        for (File f : fileList2) {
            System.out.println("filtered via Anonymous Class implementation of the FileFilter Interface : "+f);
        }
    }

    //3.using the lambda expression, implementing the FileFilter interface.
    //  lambda expression is another way of writing the Anonymous class implementation of a Functional interface.
    /*
    private FileFilter FileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");
    private File[] fileList3 = dir.listFiles(FileFilterLambda);
     */

    private File[] fileList3 = dir.listFiles((File pathname) -> pathname.getName().endsWith(".java"));

    {
        for (File f : fileList3) {
            System.out.println("filtered via Lambda expression implementation of the FileFilter Interface : "+ f);
        }
    }

}
