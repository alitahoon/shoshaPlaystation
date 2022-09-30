package com.example.shoshaplaystation.fragments;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.shoshaplaystation.R;
import com.example.shoshaplaystation.adapters.tbl_sales_categories_adapter;
import com.example.shoshaplaystation.databinding.FragmentAddAlarmBinding;
import com.example.shoshaplaystation.models.tabLayoutSales_tab_model;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addAlarm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addAlarm extends Fragment {
    FragmentAddAlarmBinding binding;
    ArrayList<tabLayoutSales_tab_model> tabList=new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addAlarm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addAlarm.
     */
    // TODO: Rename and change types and number of parameters
    public static addAlarm newInstance(String param1, String param2) {
        addAlarm fragment = new addAlarm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddAlarmBinding.inflate(inflater,container,false);
//        setNumberPickerTextColor(binding.numberPicker1,getActivity().getColor(R.color.secondColor));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.numberPicker1.setTextColor(getActivity().getColor(R.color.secondColor));
            binding.numberPicker1.setMinValue(0);
            binding.numberPicker1.setMaxValue(24);
            binding.numberPicker2.setTextColor(getActivity().getColor(R.color.secondColor));
            binding.numberPicker2.setMinValue(0);
            binding.numberPicker2.setMaxValue(60);
            binding.numberPicker3.setTextColor(getActivity().getColor(R.color.secondColor));
            binding.numberPicker3.setMinValue(0);
            binding.numberPicker3.setMaxValue(60);
        }

        //prepare tabSales
        tabList.add(new tabLayoutSales_tab_model("اندومي",new tabSalesContent()));
        tabList.add(new tabLayoutSales_tab_model("قلبظ",new tabSalesContent()));
        tabList.add(new tabLayoutSales_tab_model("شيبسي",new tabSalesContent()));

        tbl_sales_categories_adapter newPagerAdapter=new tbl_sales_categories_adapter(getActivity(),tabList);
        binding.addAlarmViewPager.setAdapter(newPagerAdapter);
        new TabLayoutMediator(binding.addAlarmTablayout, binding.addAlarmViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("الاندومي");
                        break;
                    case 1:
                        tab.setText("القلبظ");
                        break;
                    case 2:
                        tab.setText("الشيبسي");
                        break;
                }
            }
        }).attach();
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    public static void setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {

        try{
            @SuppressLint("SoonBlockedPrivateApi") Field selectorWheelPaintField = numberPicker.getClass()
                    .getDeclaredField("mSelectorWheelPaint");
            selectorWheelPaintField.setAccessible(true);
            ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
        }
        catch(NoSuchFieldException e){
            Log.w("setNumberPickerTextColor", e);
        }
        catch(IllegalAccessException e){
            Log.w("setNumberPickerTextColor", e);
        }
        catch(IllegalArgumentException e){
            Log.w("setNumberPickerTextColor", e);
        }

        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText)
                ((EditText)child).setTextColor(color);
        }
        numberPicker.invalidate();
    }
}