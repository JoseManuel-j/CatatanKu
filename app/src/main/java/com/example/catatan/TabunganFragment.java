package com.example.catatan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class TabunganFragment extends Fragment {

    public TabunganFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_tabungan.xml
        return inflater.inflate(R.layout.fragment_tabungan, container, false);
    }
}
