package com.kenny;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DemoPython {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        // hello.py in user.dir
        String path = System.getProperty("user.dir");
        path = path + "\\hello.py";

        try {
            // execuate python program
            Process execuatePythonProgram = rt.exec("python " + path);

            // write input for python program
            BufferedWriter output = new BufferedWriter((new OutputStreamWriter(execuatePythonProgram.getOutputStream(), System.getProperty("sun.jnu.encoding"))));
            output.write("Kenny");
            output.flush();
            output.close();

            // read output from python program
            BufferedReader input = new BufferedReader(new InputStreamReader(execuatePythonProgram.getInputStream(), System.getProperty("sun.jnu.encoding")));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            // get error code
            int exitVal = execuatePythonProgram.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
