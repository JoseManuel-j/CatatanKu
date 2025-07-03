package com.example.catatan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // Gunakan if-else untuk menghindari error "Constant expression required"
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selected = null;

            if (item.getItemId() == R.id.nav_books) {
                selected = new BookFragment();
            } else if (item.getItemId() == R.id.nav_wallet) {
                selected = new WalletFragment();
            } else if (item.getItemId() == R.id.nav_savings) {
                selected = new SavingFragment();
            }

            if (selected != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selected)
                        .commit();
            }

            return true;
        });

        // Default tab ketika aplikasi pertama kali dibuka
        bottomNav.setSelectedItemId(R.id.nav_books);
    }
}
