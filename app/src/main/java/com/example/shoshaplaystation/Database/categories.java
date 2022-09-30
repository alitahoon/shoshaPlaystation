package com.example.shoshaplaystation.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_categories")
public class categories {
    @NonNull
    private String cat_name;
    @NonNull
    private String cat_type;
    @PrimaryKey
    private int cat_id;

    public categories(@NonNull String cat_name, @NonNull String cat_type, int cat_id) {
        this.cat_name = cat_name;
        this.cat_type = cat_type;
        this.cat_id = cat_id;
    }

    public categories() {
    }

    @NonNull
    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(@NonNull String cat_name) {
        this.cat_name = cat_name;
    }

    @NonNull
    public String getCat_type() {
        return cat_type;
    }

    public void setCat_type(@NonNull String cat_type) {
        this.cat_type = cat_type;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
}
