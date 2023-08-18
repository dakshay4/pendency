package com.dakshay.tracking.io.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputFactory{
    @Override
    public String[] takeInput() {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(inputStreamReader);
        final String line;
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //FutureImprovement: We can move this string line parsing logic to separate class when multiple input types are
        //supported.
        String[] s = line.split(" ");
        return s;
    }
}
