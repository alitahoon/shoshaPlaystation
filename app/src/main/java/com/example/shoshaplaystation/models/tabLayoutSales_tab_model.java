package com.example.shoshaplaystation.models;

import androidx.fragment.app.Fragment;

public class tabLayoutSales_tab_model {
    private String name;
    private Fragment fragment;

    public tabLayoutSales_tab_model(String name, Fragment fragment) {
        this.name = name;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
