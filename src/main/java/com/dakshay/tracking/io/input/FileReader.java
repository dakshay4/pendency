package com.dakshay.tracking.io.input;

import com.dakshay.tracking.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements InputFactory{

    private String fileName;
    @Override
    public String[] takeInput() {
        InputStream is = this.getClass().getResourceAsStream("/" +getFileName());
        if(is==null) throw new InvalidInputException("Please enter correct File Name");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bReader = new BufferedReader(isr);

       List<String> testCase = new ArrayList<>();
       try {
           String line = bReader.readLine();int i=0;
           while (line != null) {
               testCase.add(line);
               line = bReader.readLine();
           }
       }catch (Exception e) {

       }
       return testCase.toArray(new String[0]);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
