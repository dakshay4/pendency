package com.dakshay.tracking.model;

import com.dakshay.tracking.exception.InvalidInputException;

import java.util.*;

public class FinanceTransactionTrack implements TrackFactory{

    private Map<Integer,Entity> entity;

    private static final String DELIMITER="_";

    @Override
    public void startTracking(int id, List<String> transactionChain) {
        if(transactionChain.size()!=3) throw new InvalidInputException("Please Input 3 tags in the id");
        Entity newEntity  = new Entity(id,transactionChain);
        this.entity = (entity==null || entity.size()==0)? new HashMap<>() : entity ;
        this.entity.put(id, newEntity);
    }

    @Override
    public void stopTracking(Integer id) {
        if(id == null){
            throw new InvalidInputException("Valid id is needed to Stop Track the transaction tag");
        }
        if(entity == null || entity.isEmpty() || !entity.containsKey(id))
            throw new InvalidInputException("No Entities found to Stop Tracking");
        entity.remove(id);
    }


    /** ToDo:
     * Map<String,Integer>
     *     This willl store delimited string vs count occurences
     *     e.g.
     *     UPI :2
     *     UPI_KANTAKA : 2
     *     UPI_KARNATAKA_BANGALORE :1
     *     UPI_KARNATAKA_MYSORE :1
     *
     *
     *     Stop TraCking Entity ( UPI, KARNATAKA, MYSORE)
     *     get the Map and decrease the UPI count by 1
     *     UPI_KARNTAKA : decrease the count by 1
     * </String,Integer>
     * @param searchTags
     * @return
     */

    @Override
    public int getCounts(List<String> searchTags) {
        int count =0;
        for(Entity e : entity.values()){
            if(searchTags.size()==1) {
                count = e.getTags().get(0).equals(searchTags.get(0)) ? (count+1) : count;
            }
            if(searchTags.size()==2) {
                count = (e.getTags().get(0).equals(searchTags.get(0))
                && e.getTags().get(1).equals(searchTags.get(1))) ? (count+1) : count;
            }

            if(searchTags.size()==3) {
                count = (e.getTags().get(0).equals(searchTags.get(0))
                        && e.getTags().get(1).equals(searchTags.get(1))
                        && e.getTags().get(2).equals(searchTags.get(2))) ? (count+1) : count;
            }
        };
        return count;
    }
}
