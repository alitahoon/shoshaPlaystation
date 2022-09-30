package com.example.shoshaplaystation.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.shoshaplaystation.models.tabLayoutSales_tab_model;

import java.util.ArrayList;

public class tbl_sales_categories_adapter extends FragmentStateAdapter {
    ArrayList<tabLayoutSales_tab_model> tabList=new ArrayList<>();
    public tbl_sales_categories_adapter(@NonNull FragmentActivity fragmentActivity,ArrayList<tabLayoutSales_tab_model> tabList) {
        super(fragmentActivity);
        this.tabList=tabList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return tabList.get(position).getFragment();
    }

    @Override
    public int getItemCount() {
        return tabList.size();
    }
}
