package com.kenny;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DemoJava {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        // Test.java in user.dir
        String path = System.getProperty("user.dir");
        path = path + "\\Test.java";

        try {
            // convert to class file => Test.class
            Process convertToJavaClass = rt.exec("javac -encoding utf8 " + path);
            convertToJavaClass.waitFor();

            path = System.getProperty("user.dir");
            // execuate java program => compare two lists wheather they are strictly identical
            Process execuateJavaProgram = rt.exec("java -classpath " + path + " Test");

            // write input for java program
            BufferedWriter output = new BufferedWriter((new OutputStreamWriter(execuateJavaProgram.getOutputStream(), System.getProperty("sun.jnu.encoding"))));
            output.write("3");
            output.newLine();

            output.write("1");
            output.newLine();

            output.write("2");
            output.newLine();

            output.write("3");
            output.newLine();

            output.write("3");
            output.newLine();

            output.write("1");
            output.newLine();

            output.write("2");
            output.newLine();
            output.write("3");

            output.flush();
            output.close();

            // read output from java program
            BufferedReader input = new BufferedReader(new InputStreamReader(execuateJavaProgram.getInputStream(), System.getProperty("sun.jnu.encoding")));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            // get error code
            int exitVal = execuateJavaProgram.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
