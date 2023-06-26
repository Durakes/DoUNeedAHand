package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.Replaceable;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityServicioBinding;

public class Servicio extends AppCompatActivity {

    ActivityServicioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityServicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setSelectedItemId(R.id.menu);
        replaceFragment(new MenuFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.historial:
                    replaceFragment(new HistorialFragment());
                    break;
                case R.id.configuration:
                    replaceFragment(new ConfigurationFragment());
                    break;

                case R.id.menu:
                    replaceFragment(new MenuFragment());
                    break;
                case R.id.perfil:
                    replaceFragment(new PerfilFragment());
                    break;

                /*default:
                    replaceFragment(new HistorialFragment());
                    break;*/

            }


            return true;
        });



    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2,fragment);
        fragmentTransaction.commit();
    }


}