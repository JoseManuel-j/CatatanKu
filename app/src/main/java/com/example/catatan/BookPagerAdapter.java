package com.example.catatan;

import com.example.catatan.PengeluaranFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BookPagerAdapter extends FragmentStateAdapter {

    public BookPagerAdapter(@NonNull FragmentManager fm, @NonNull Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TabunganFragment();
            case 1:
                return new PemasukanFragment();
            case 2:
                return new PengeluaranFragment();
            default:
                return new Fragment(); // fallback fragment kosong
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
