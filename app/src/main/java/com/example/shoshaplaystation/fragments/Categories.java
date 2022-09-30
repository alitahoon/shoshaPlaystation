package com.example.shoshaplaystation.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoshaplaystation.R;
import com.example.shoshaplaystation.databinding.FragmentCategoriesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Categories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Categories extends Fragment {
    FragmentCategoriesBinding binding;
    homeCategoriesClickedListener listener;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Categories() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Categories.
     */
    // TODO: Rename and change types and number of parameters
    public static Categories newInstance(String param1, String param2) {
        Categories fragment = new Categories();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //initialize the interface
        if (context instanceof homeCategoriesClickedListener)
            listener=(homeCategoriesClickedListener) context;
        else
            throw new RuntimeException("please implement homeCategoriesClickedListener");
    }

    //realise the listener from context
    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
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
        // Inflate the layout for this fragment
        binding=FragmentCategoriesBinding.inflate(inflater,container,false);

        //send clicked categorie to the main activity
        binding.btnPs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHomeCategoriesClicked("ps-1");
            }
        });

        binding.btnPs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHomeCategoriesClicked("ps-2");
            }
        });

        binding.btnPs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHomeCategoriesClicked("ps-3");
            }
        });

        binding.btnPs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHomeCategoriesClicked("ps-4");
            }
        });

        return binding.getRoot();
    }

    //create the interface to be listener for categorie click
    public interface homeCategoriesClickedListener{
        void onHomeCategoriesClicked(String clickedCategorieName);
    }
}