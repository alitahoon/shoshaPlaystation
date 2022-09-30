package com.example.shoshaplaystation.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
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
import com.example.shoshaplaystation.adapters.rcv_alarms_adapter;
import com.example.shoshaplaystation.databinding.FragmentPsCategorieContentBinding;
import com.example.shoshaplaystation.interfaces.rcv_alarms_click_listener;
import com.example.shoshaplaystation.models.alarmsModel;
import com.example.shoshaplaystation.models.storeItemModel;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link psCategorieContent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class psCategorieContent extends Fragment {
    FragmentPsCategorieContentBinding binding;
    psCategorieContentClcikedListener listener;
    ArrayList<alarmsModel>AlarmsList=new ArrayList<>();
    ArrayList<storeItemModel>storeItemModelsList=new ArrayList<>();
    rcv_alarms_adapter alarms_adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CategorieName = "CategorieName";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mCategorieName;
    private String mParam2;

    public psCategorieContent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment psCategorieContent.
     */
    // TODO: Rename and change types and number of parameters
    public static psCategorieContent newInstance(String param1, String param2) {
        psCategorieContent fragment = new psCategorieContent();
        Bundle args = new Bundle();
        args.putString(ARG_CategorieName, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof psCategorieContentClcikedListener)
            listener=(psCategorieContentClcikedListener) context;
        else
            throw new RuntimeException("please implement psCategorieContentClcikedListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategorieName = getArguments().getString(ARG_CategorieName);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPsCategorieContentBinding.inflate(inflater,container,false);
        //handle click on add alarm button
        binding.psCategorieContentBtnAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPsCategorieContentClcikedListener("btnAddAlarmClicked");

            }
        });
        //prepare recycleView
        storeItemModelsList.add(new storeItemModel("اندومي بالجبنه",3.5,"اندومي"));
        AlarmsList.add(new alarmsModel("علي طاحون","1:30:00",
                storeItemModelsList));
        alarms_adapter=new rcv_alarms_adapter(AlarmsList, getContext(), new rcv_alarms_click_listener() {
            @Override
            public void on_rcv_alarms_click_listener(String item_clciked) {

            }
        });
        binding.rcvAlarms.setAdapter(alarms_adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public interface psCategorieContentClcikedListener{
        void onPsCategorieContentClcikedListener(String btnClciked);
    }
}