package com.example.shoshaplaystation.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

public class Repositery {
    categoriesDAO CategoriesDAO;
    devicesDAO DevicesDAO;
    sales_itemDAO Sales_itemDAO;

    public Repositery(Application application){
        myRoomDatabase db=myRoomDatabase.getDatabase(application);
        CategoriesDAO =db.CategoriesDAO();
        DevicesDAO=db.DevicesDAO();
        Sales_itemDAO=db.Sales_itemDAO();
    }

    ///////////////////////////////////////////////categories query's
    public void insertCategorie(categories newDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CategoriesDAO.insertCategorie(newDevice);
            }
        });
    }
    public void updateCategorie(categories oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CategoriesDAO.updateCategorie(oldDevice);
            }
        });

    }
    public void deleteCategorie(categories oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CategoriesDAO.deleteCategorie(oldDevice);
            }
        });

    }
    public LiveData<ArrayList<categories>> getAllCategorie(){
        return CategoriesDAO.getAllCategorie();
    }
    public String getCategorieNameByID(String name){
            return CategoriesDAO.getCategorieNameByID(name);
    }

    ///////////////////////////////////////////////devices query's
    void insertDevice(devices newDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DevicesDAO.insertDevice(newDevice);
            }
        });
    }
    void updateDevice(devices oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DevicesDAO.updateDevice(oldDevice);
            }
        });
    }
    void deleteDevice(devices oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DevicesDAO.deleteDevice(oldDevice);
            }
        });
    }
    LiveData<ArrayList<devices>> getAllDevice(){
        return DevicesDAO.getAllDevice();
    }
    String getDeviceNameByID(String name){
        return DevicesDAO.getDeviceNameByID(name);
    }

    ///////////////////////////////////////////////sales_item query's
    void insertSales_item(sales_item newDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Sales_itemDAO.insertSales_item(newDevice);
            }
        });
    }
    void updateSales_item(sales_item oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Sales_itemDAO.updateSales_item(oldDevice);
            }
        });
    }
    void deleteSales_item(sales_item oldDevice){
        myRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Sales_itemDAO.deleteSales_item(oldDevice);
            }
        });
    }
    LiveData<ArrayList<sales_item>> getAllSales_item(){
        return Sales_itemDAO.getAllSales_item();
    }
    LiveData<ArrayList<String>> getSales_itemByCategorieID(int id){
       return Sales_itemDAO.getSales_itemByCategorieID(id);
    }

}
