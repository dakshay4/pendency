package com.dakshay.tracking;

import com.dakshay.tracking.exception.InvalidInputException;
import com.dakshay.tracking.io.input.InputFactory;
import com.dakshay.tracking.io.output.OutputLogger;
import com.dakshay.tracking.model.FinanceTransactionTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTrackTransaction {

    private final FinanceTransactionTrack financeTransactionTrack;
    private final InputFactory input;
    private final OutputLogger logger;

    public AddTrackTransaction(FinanceTransactionTrack financeTransactionTrack, InputFactory input, OutputLogger logger) {
        this.financeTransactionTrack = financeTransactionTrack;
        this.input = input;
        this.logger = logger;
    }

    public void startTracking() {
        logger.printLine("Getting all cases from file");
        String[] inputStreamArray = input.takeInput();
        for(String line: inputStreamArray) {
            String[] s=line.split(" ");
            Integer id = Integer.parseInt(s[0]);
            List<String> tags = new ArrayList<>();
            for(int i=1;i<s.length;i++) tags.add(s[i]);
            financeTransactionTrack.startTracking(id, tags);
            logger.printLine("Added id " + id + " in the Transaction tracking list");
        }
    }
}
