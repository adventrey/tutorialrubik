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


public class AdvancedPllFragment extends Fragment {
    private RelativeLayout relativeLayoutPll;
    private ImageView ImageViewOllDetail, ImageViewPllClose;
    private RecyclerView recyclerViewGambarPll;
    private ArrayList<RWData> ListrwData = new ArrayList<>();

    public AdvancedPllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced_pll, container, false);

        recyclerViewGambarPll = view.findViewById(R.id.recyclerViewPLL);
        relativeLayoutPll = view.findViewById(R.id.layoutPllZoom);
        ImageViewOllDetail = view.findViewById(R.id.imageViewPllDetail);
        ImageViewPllClose = view.findViewById(R.id.imageViewPLLClose);
        ListrwData.addAll(DataGambar.DaftarDataPll());

        showRecycleViewPll();
        ImageViewPllClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayoutPll.setVisibility(View.GONE);
                recyclerViewGambarPll.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void showRecycleViewPll() {

        recyclerViewGambarPll.setLayoutManager(new GridLayoutManager(getContext(), 3));
        AdapterPll adapterPll = new AdapterPll(ListrwData);
        recyclerViewGambarPll.setHasFixedSize(true);
        recyclerViewGambarPll.setAdapter(adapterPll);
        adapterPll.setOnItemClickCallback(new AdapterPll.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                ImageViewOllDetail.setImageResource(ListrwData.get(position).getGambar());
                relativeLayoutPll.setVisibility(View.VISIBLE);
                recyclerViewGambarPll.setVisibility(View.GONE);
            }
        });

    }
}