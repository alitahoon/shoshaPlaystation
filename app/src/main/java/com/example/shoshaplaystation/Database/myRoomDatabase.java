package com.example.shoshaplaystation.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {categories.class,devices.class,sales_item.class}, version = 1, exportSchema = false)
public abstract class myRoomDatabase extends RoomDatabase {

    public abstract categoriesDAO CategoriesDAO();
    public abstract sales_itemDAO Sales_itemDAO();
    public abstract devicesDAO DevicesDAO();

    private static volatile myRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static myRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (myRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    myRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}