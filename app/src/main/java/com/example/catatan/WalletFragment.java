package com.example.catatan;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WalletFragment extends Fragment {

    // Deklarasi variabel class
    TextView textWalletTitle, textWalletBalance, textWalletSubtitle;
    FloatingActionButton fabAddTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        textWalletTitle = view.findViewById(R.id.textWalletTitle);
        textWalletBalance = view.findViewById(R.id.textWalletBalance);
        textWalletSubtitle = view.findViewById(R.id.textWalletSubtitle);
        fabAddTransaction = view.findViewById(R.id.fabAddTransaction);

        textWalletTitle.setText("Hello, Jose!");
        textWalletBalance.setText("Rp 3.000.000");
        textWalletSubtitle.setText("Current available balance");

        fabAddTransaction.setOnClickListener(v -> {
            // aksi tombol tambah transaksi
        });

        return view;
    }
}
