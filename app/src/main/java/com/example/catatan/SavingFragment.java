package com.example.catatan;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SavingFragment extends Fragment {

    private TextView textSavingAmount;
    private RecyclerView recyclerViewSavings;
    private SavingAdapter adapter;
    private List<Saving> savingList;
    private FloatingActionButton fabAddSaving;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saving, container, false);

        textSavingAmount = view.findViewById(R.id.textSavingAmount);
        recyclerViewSavings = view.findViewById(R.id.recyclerViewSavings);
        fabAddSaving = view.findViewById(R.id.fabAddSaving);

        recyclerViewSavings.setLayoutManager(new LinearLayoutManager(getContext()));

        savingList = new ArrayList<>();
        // Contoh data awal
        savingList.add(new Saving("Emergency Fund", "Rp 1.000.000"));
        savingList.add(new Saving("Vacation", "Rp 1.500.000"));
        savingList.add(new Saving("New Laptop", "Rp 2.500.000"));

        adapter = new SavingAdapter(savingList);
        recyclerViewSavings.setAdapter(adapter);

        updateTotalSaving();

        fabAddSaving.setOnClickListener(v -> showAddSavingDialog());

        return view;
    }

    private void updateTotalSaving() {
        long total = 0;
        for (Saving s : savingList) {
            String val = s.getAmount().replace("Rp ", "").replace(".", "").replace(",", "").trim();
            try {
                total += Long.parseLong(val);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String formatted = String.format("Rp %,d", total).replace(',', '.');
        textSavingAmount.setText(formatted);
    }

    private void showAddSavingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add New Saving");

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 40, 50, 10);

        final EditText inputName = new EditText(getContext());
        inputName.setHint("Saving Name");
        layout.addView(inputName);

        final EditText inputAmount = new EditText(getContext());
        inputAmount.setHint("Amount (numbers only, e.g. 1500000)");
        inputAmount.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(inputAmount);

        builder.setView(layout);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String name = inputName.getText().toString().trim();
            String amountStr = inputAmount.getText().toString().trim();

            if (!name.isEmpty() && !amountStr.isEmpty()) {
                try {
                    long amount = Long.parseLong(amountStr);
                    String formattedAmount = "Rp " + String.format("%,d", amount).replace(',', '.');

                    savingList.add(0, new Saving(name, formattedAmount)); // insert on top
                    adapter.notifyItemInserted(0);
                    recyclerViewSavings.scrollToPosition(0);
                    updateTotalSaving();

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
