package com.example.shoshaplaystation.models;

import java.io.Serializable;
import java.util.ArrayList;

public class alarmsModel implements Serializable {
    private String ReservationName;
    private String duration;
    private ArrayList <storeItemModel> sellingItemList;

    public alarmsModel(String reservationName, String duration, ArrayList<storeItemModel> sellingItemList) {
        ReservationName = reservationName;
        this.duration = duration;
        this.sellingItemList = sellingItemList;
    }

    public String getReservationName() {
        return ReservationName;
    }

    public void setReservationName(String reservationName) {
        ReservationName = reservationName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<storeItemModel> getSellingItemList() {
        return sellingItemList;
    }

    public void setSellingItemList(ArrayList<storeItemModel> sellingItemList) {
        this.sellingItemList = sellingItemList;
    }
}
