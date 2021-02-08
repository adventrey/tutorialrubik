package com.btxappreborn.tutorialforrubikcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterOll extends RecyclerView.Adapter<AdapterOll.ListViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<RWData> listGambarOLL;

    public AdapterOll(ArrayList<RWData> listGambarOLL) {
        this.listGambarOLL = listGambarOLL;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blueprint, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        RWData RWData = listGambarOLL.get(position);
        holder.imageViewOll.setImageResource(RWData.getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGambarOLL.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewOll;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewOll = itemView.findViewById(R.id.imageViewBP);

        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(int position);
    }
}
