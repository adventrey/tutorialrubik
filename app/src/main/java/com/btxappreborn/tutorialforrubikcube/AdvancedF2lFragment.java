package com.btxappreborn.tutorialforrubikcube;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class AdvancedF2lFragment extends Fragment {
    private FrameLayout frameLayoutF2L;
    private ImageView ImageViewF2LDetail, ImageViewF2LClose;
    private RecyclerView recyclerViewGambarf2l;
    private ArrayList<RWData> ListrwData = new ArrayList<>();

    public AdvancedF2lFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced_f2l, container, false);
        recyclerViewGambarf2l = view.findViewById(R.id.recyclerViewF2L);
        frameLayoutF2L = view.findViewById(R.id.layoutF2lZoom);
        ImageViewF2LDetail = view.findViewById(R.id.imageViewf2lDetail);
        ImageViewF2LClose = view.findViewById(R.id.imageViewClosef2l);
        ListrwData.addAll(DataGambar.DaftarDataF2L());

        showRecycleViewF2L();
        ImageViewF2LClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frameLayoutF2L.setVisibility(View.GONE);
                recyclerViewGambarf2l.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    private void showRecycleViewF2L() {


        recyclerViewGambarf2l.setLayoutManager(new GridLayoutManager(getContext(), 3));
        AdapterF2L adapterF2L = new AdapterF2L(ListrwData);
        recyclerViewGambarf2l.setHasFixedSize(true);
        recyclerViewGambarf2l.setAdapter(adapterF2L);
        adapterF2L.setOnItemClickCallback(new AdapterF2L.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                ImageViewF2LDetail.setImageResource(ListrwData.get(position).getGambar());
                frameLayoutF2L.setVisibility(View.VISIBLE);
                recyclerViewGambarf2l.setVisibility(View.GONE);

            }

        });


    }
}