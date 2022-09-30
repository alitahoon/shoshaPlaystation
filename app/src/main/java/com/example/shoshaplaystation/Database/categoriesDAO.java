package com.example.shoshaplaystation.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

@Dao
public interface categoriesDAO {
    @Insert
    void insertCategorie(categories newDevice);
    @Update
    void updateCategorie(categories oldDevice);
    @Delete
    void deleteCategorie(categories oldDevice);
    @Query("select *from tbl_categories order by cat_id asc")
    LiveData<ArrayList<categories>> getAllCategorie();
    @Query("select cat_name from tbl_categories where cat_id == :name")
    String getCategorieNameByID(String name);
}
