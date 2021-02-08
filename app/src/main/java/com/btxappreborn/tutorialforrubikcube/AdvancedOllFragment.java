package com.btxappreborn.tutorialforrubikcube;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class AdvancedOllFragment extends Fragment {
    private RelativeLayout relativeLayoutOll;
    private ImageView ImageViewOllDetail, ImageViewOllClose;
    private RecyclerView recyclerViewGambarOll;
    private ArrayList<RWData> ListrwData = new ArrayList<>();

    public AdvancedOllFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced_oll, container, false);

        recyclerViewGambarOll = view.findViewById(R.id.recyclerViewOLL);
        relativeLayoutOll = view.findViewById(R.id.layoutOLLZoom);
        ImageViewOllDetail = view.findViewById(R.id.imageViewOLLDetail);
        ImageViewOllClose = view.findViewById(R.id.imageViewOLLClose);
        ListrwData.addAll(DataGambar.DaftarDataOll());

        showRecycleViewOll();
        ImageViewOllClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayoutOll.setVisibility(View.GONE);
                recyclerViewGambarOll.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    private void showRecycleViewOll() {
        recyclerViewGambarOll.setLayoutManager(new GridLayoutManager(getContext(), 3));
        AdapterPll adapterPll = new AdapterPll(ListrwData);
        recyclerViewGambarOll.setHasFixedSize(true);
        recyclerViewGambarOll.setAdapter(adapterPll);
        adapterPll.setOnItemClickCallback(new AdapterPll.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                ImageViewOllDetail.setImageResource(ListrwData.get(position).getGambar());
                relativeLayoutOll.setVisibility(View.VISIBLE);
                recyclerViewGambarOll.setVisibility(View.GONE);
            }
        });

    }
}