package com.example.shoshaplaystation.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

@Dao
public interface sales_itemDAO {
    @Insert
    void insertSales_item(sales_item newDevice);
    @Update
    void updateSales_item(sales_item oldDevice);
    @Delete
    void deleteSales_item(sales_item oldDevice);
    @Query("select *from tbl_sales_item order by item_id asc")
    LiveData<ArrayList<sales_item>> getAllSales_item();
    @Query("select item_name from tbl_sales_item where cat_id like '%' || :id ||'%' ")
    LiveData<ArrayList<String>> getSales_itemByCategorieID(int id);
}
