package com.btxappreborn.tutorialforrubikcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPll extends RecyclerView.Adapter<AdapterPll.ListViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<RWData> listGambarPLL;

    public AdapterPll(ArrayList<RWData> listGambarPLL) {
        this.listGambarPLL = listGambarPLL;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blueprint, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        RWData RWData = listGambarPLL.get(position);
        holder.imageViewPll.setImageResource(RWData.getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGambarPLL.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPll;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPll = itemView.findViewById(R.id.imageViewBP);

        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(int position);
    }
}
