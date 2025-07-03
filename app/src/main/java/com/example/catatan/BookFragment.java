package com.example.catatan;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BookFragment extends Fragment {

    public BookFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        ViewPager2 viewPager = view.findViewById(R.id.book_viewpager);
        TabLayout tabLayout = view.findViewById(R.id.book_tabs);

        BookPagerAdapter adapter = new BookPagerAdapter(getChildFragmentManager(), getLifecycle());

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("Tabungan"); break;
                        case 1: tab.setText("Pemasukan"); break;
                        case 2: tab.setText("Pengeluaran"); break;
                    }
                }).attach();

        return view;
    }
}
