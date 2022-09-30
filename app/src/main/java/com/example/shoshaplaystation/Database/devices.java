package com.example.shoshaplaystation.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.sql.Time;
@TypeConverters({TimeConverter.class})
@Entity(tableName = "tbl_devices",foreignKeys = {@ForeignKey(entity = categories.class,
        parentColumns = {"item_id"},childColumns = {"dev_id"},onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)})

public class devices {
    @PrimaryKey
    private int dev_id;
    @NonNull
    private int dev_name;
    @NonNull
    private Time dev_book_time;
    @NonNull
    private int dev_booked_user;

    public devices(int dev_id, int dev_name, Time dev_book_time, int dev_booked_user) {
        this.dev_id = dev_id;
        this.dev_name = dev_name;
        this.dev_book_time = dev_book_time;
        this.dev_booked_user = dev_booked_user;
    }

    public devices() {
    }

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public int getDev_name() {
        return dev_name;
    }

    public void setDev_name(int dev_name) {
        this.dev_name = dev_name;
    }

    public Time getDev_book_time() {
        return dev_book_time;
    }

    public void setDev_book_time(Time dev_book_time) {
        this.dev_book_time = dev_book_time;
    }

    public int getDev_booked_user() {
        return dev_booked_user;
    }

    public void setDev_booked_user(int dev_booked_user) {
        this.dev_booked_user = dev_booked_user;
    }
}
