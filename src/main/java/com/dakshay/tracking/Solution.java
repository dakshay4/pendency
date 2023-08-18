package com.dakshay.tracking;

import com.dakshay.tracking.io.input.ConsoleReader;
import com.dakshay.tracking.io.output.ConsolePrint;
import com.dakshay.tracking.model.FinanceTransactionTrack;

public class Solution {
    public static void main(String[] args) {

        TrackingLoop loop = new TrackingLoop(new FinanceTransactionTrack(), new ConsoleReader(), new ConsolePrint());
        loop.track();
    }

}