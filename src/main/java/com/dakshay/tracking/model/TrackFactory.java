package com.dakshay.tracking.model;

import java.util.List;

public interface TrackFactory {

    public void startTracking(int id, List<String> transactionChain);
    public void stopTracking(Integer id);

    public int getCounts(List<String> transactionChain);
}
