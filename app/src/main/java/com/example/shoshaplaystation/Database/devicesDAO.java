package com.example.shoshaplaystation.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.ArrayList;
@TypeConverters({TimeConverter.class})
@Dao
public interface devicesDAO {
    @Insert
    void insertDevice(devices newDevice);
    @Update
    void updateDevice(devices oldDevice);
    @Delete
    void deleteDevice(devices oldDevice);
    @Query("select *from tbl_devices order by dev_id asc")
    LiveData<ArrayList<devices>> getAllDevice();
    @Query("select dev_name from tbl_devices where dev_id == :name")
    String getDeviceNameByID(String name);

}
