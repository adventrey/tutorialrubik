package com.btxappreborn.tutorialforrubikcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterF2L extends RecyclerView.Adapter<AdapterF2L.ListViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<RWData> listGambarF2L;

    public AdapterF2L(ArrayList<RWData> listGambarF2L) {
        this.listGambarF2L = listGambarF2L;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blueprint, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        RWData RWData = listGambarF2L.get(position);
        holder.imageViewF2L.setImageResource(RWData.getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGambarF2L.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewF2L;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewF2L = itemView.findViewById(R.id.imageViewBP);

        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(int position);
    }
}
