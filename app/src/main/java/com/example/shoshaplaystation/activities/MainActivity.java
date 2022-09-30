package com.example.shoshaplaystation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.shoshaplaystation.R;
import com.example.shoshaplaystation.databinding.ActivityMainBinding;
import com.example.shoshaplaystation.fragments.Categories;
import com.example.shoshaplaystation.fragments.addAlarm;
import com.example.shoshaplaystation.fragments.psCategorieContent;

public class MainActivity extends AppCompatActivity implements Categories.homeCategoriesClickedListener, psCategorieContent.psCategorieContentClcikedListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set theme
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(R.color.secondColor));
        }

        //load categories fragment
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter,R.anim.exit);
        ft.replace(R.id.MainActivityFragmentContainer, new Categories());
        ft.commit();


    }

    @Override
    public void onHomeCategoriesClicked(String clickedCategorieName) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
        Toast.makeText(this, "cat "+clickedCategorieName, Toast.LENGTH_SHORT).show();
        switch (clickedCategorieName){
            case "ps-1":
                binding.homeHeaderTitle.setText("جهاز رقم 1");
                ft.replace(R.id.MainActivityFragmentContainer, new psCategorieContent());
                ft.commit();
                break;

            case "ps-2":
                binding.homeHeaderTitle.setText("جهاز رقم 2");
                ft.replace(R.id.MainActivityFragmentContainer, new psCategorieContent());
                ft.commit();
                break;

            case "ps-3":
                binding.homeHeaderTitle.setText("جهاز رقم 3");
                ft.replace(R.id.MainActivityFragmentContainer, new psCategorieContent());
                ft.commit();
                break;

            case "ps-4":
                binding.homeHeaderTitle.setText("جهاز رقم 4");
                ft.replace(R.id.MainActivityFragmentContainer, new psCategorieContent());
                ft.commit();
                break;
        }
        binding.btnFooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.homeHeaderTitle.setText("القائمه الرئيسيه");
                //load categories fragment
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter,R.anim.exit);
                ft.replace(R.id.MainActivityFragmentContainer, new Categories());
                ft.commit();
            }
        });

    }

    @Override
    public void onPsCategorieContentClcikedListener(String btnClciked) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_up,R.anim.slide_out_down);
        switch (btnClciked){
            case "btnAddAlarmClicked":
                ft.replace(R.id.MainActivityFragmentContainer, new addAlarm());
                ft.commit();
                break;
        }
    }
}