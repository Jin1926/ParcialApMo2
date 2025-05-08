package com.example.parcial2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_navigation = findViewById(R.id.btn_navigation);
        loadFragment(new Inicio());
        btn_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectecFragment = null;

                int itemId = item.getItemId();

                if (itemId == R.id.nav_Home){
                    selectecFragment = new Inicio();
                } else if (itemId == R.id.nav_profiles) {
                    selectecFragment = new Perfil();
                }
                if (selectecFragment !=null){
                    loadFragment(selectecFragment);
                    return true;
                }
                return false;
            }

        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frm_container,fragment).commit();
    }
}