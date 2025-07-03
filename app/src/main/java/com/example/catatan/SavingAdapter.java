package com.example.catatan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavingAdapter extends RecyclerView.Adapter<SavingAdapter.ViewHolder> {

    private List<Saving> savingList;

    public SavingAdapter(List<Saving> savingList) {
        this.savingList = savingList;
    }

    @NonNull
    @Override
    public SavingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saving, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavingAdapter.ViewHolder holder, int position) {
        Saving saving = savingList.get(position);
        holder.textSavingName.setText(saving.getName());
        holder.textSavingAmount.setText(saving.getAmount());
    }

    @Override
    public int getItemCount() {
        return savingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textSavingName, textSavingAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textSavingName = itemView.findViewById(R.id.textSavingName);
            textSavingAmount = itemView.findViewById(R.id.textSavingAmount);
        }
    }
}
