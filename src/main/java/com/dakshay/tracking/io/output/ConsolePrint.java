package com.dakshay.tracking.io.output;

public class ConsolePrint implements OutputLogger {
    @Override
    public void printLine(String s) {
        System.out.println(s);
    }
}
