package edu.se329.client.model;

import java.util.ArrayList;

/**
 * Created by Jack on 10/11/2016.
 */
public class TimeModel {
    private ArrayList<String> timeList;

    public TimeModel(ArrayList<String> timeList) {
        this.timeList = timeList;

    }

    public ArrayList<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(ArrayList<String> timeList) {
        this.timeList = timeList;
    }


}
