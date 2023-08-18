package com.dakshay.tracking;

import com.dakshay.tracking.io.input.FileReader;
import com.dakshay.tracking.io.input.InputFactory;
import com.dakshay.tracking.io.output.OutputLogger;
import com.dakshay.tracking.model.FinanceTransactionTrack;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class TrackingLoop {

    private final FinanceTransactionTrack financeTransactionTrack;
    private final InputFactory input;
    private final OutputLogger logger;


    public TrackingLoop(FinanceTransactionTrack financeTransactionTrack, InputFactory input, OutputLogger logger) {
        this.financeTransactionTrack = financeTransactionTrack;
        this.input = input;
        this.logger = logger;
    }

    public void track() {
        while (true) {
            try {

                logger.printLine("Enter Type of Transaction you want ?");
                logger.printLine("1. Start Tracking\n" +
                        "2. Stop Tracking\n" +
                        "3. Get Counts of Transactions");
                String inputStreamArray[] = input.takeInput();
                Integer option = Integer.parseInt(inputStreamArray[0]);
                switch (option) {
                    case 1:
                        logger.printLine("Provide Tracking file name");
                        inputStreamArray = input.takeInput();
                        String fileName = inputStreamArray[0];
                        FileReader reader = new FileReader();
                        reader.setFileName(fileName);
                        AddTrackTransaction addTrackTransaction =
                                new AddTrackTransaction(financeTransactionTrack, reader, logger);
                        addTrackTransaction.startTracking();
                        break;
                    case 2:
                        logger.printLine("Provide single id input to remove from tracking");
                        inputStreamArray = input.takeInput();
                        int stopId = Integer.parseInt(inputStreamArray[0]);
                        financeTransactionTrack.stopTracking(stopId);
                        logger.printLine("Stopped tracking id " + stopId);
                        break;
                    case 3:
                        logger.printLine("Provide id space separated tags to search");
                        inputStreamArray = input.takeInput();
                        List<String> searchTags = new ArrayList<>();
                        for (String s : inputStreamArray) searchTags.add(s);
                        int count = financeTransactionTrack.getCounts(searchTags);
                        logger.printLine("Output: " + count);
                        break;
                    default:
                        break;

                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
