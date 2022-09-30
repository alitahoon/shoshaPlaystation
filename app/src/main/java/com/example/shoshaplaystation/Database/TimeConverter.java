package com.example.shoshaplaystation.Database;

import androidx.room.TypeConverter;

import java.sql.Time;
public class TimeConverter {
    @TypeConverter
    public static Time toTime(Long millSecondes){
        return millSecondes==null?null:new Time(millSecondes);
    }
    @TypeConverter
    public static Long fromTime(Time time){
        return time==null?null:time.getTime();
    }
}
