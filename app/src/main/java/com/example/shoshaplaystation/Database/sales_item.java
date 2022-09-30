package com.example.shoshaplaystation.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "tbl_sales_item",foreignKeys = {@ForeignKey(entity = categories.class,
parentColumns = {"cat_id"},childColumns = {"cat_id"},onDelete = ForeignKey.CASCADE,
onUpdate = ForeignKey.CASCADE)})
public class sales_item {
    @PrimaryKey
    private int item_id;
    @NonNull
    private String item_name;
    @NonNull
    private Double item_price;
    @NonNull
    private int item_Quantity;
    @NonNull
    private int cat_id;

    public sales_item(int item_id, @NonNull String item_name, @NonNull Double item_price, int item_Quantity, int cat_id) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_Quantity = item_Quantity;
        this.cat_id = cat_id;
    }

    public sales_item() {
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    @NonNull
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(@NonNull String item_name) {
        this.item_name = item_name;
    }

    @NonNull
    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(@NonNull Double item_price) {
        this.item_price = item_price;
    }

    public int getItem_Quantity() {
        return item_Quantity;
    }

    public void setItem_Quantity(int item_Quantity) {
        this.item_Quantity = item_Quantity;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
}
