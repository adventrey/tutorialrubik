package com.btxappreborn.tutorialforrubikcube;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class BeginnerFragment extends Fragment {
    Button btnBCross, btnBWhiteCorner, btnBSecondLayers, btnBOll1, btnBOll2, btnBPll;

//    Fragment fragment;
    BeginnerInterfaces beginnerInterfaces;

    public BeginnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_beginner, container, false);

        btnBCross = v.findViewById(R.id.btnBCross);
        btnBWhiteCorner = v.findViewById(R.id.btnBWhiteCorner);
        btnBSecondLayers = v.findViewById(R.id.btnBSecondLayers);
        btnBOll1 = v.findViewById(R.id.btnBOLL1);
        btnBOll2 = v.findViewById(R.id.btnBOLL2);
        btnBPll = v.findViewById(R.id.btnBPLL);

        btnBCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(301);
                //fragment = new BeginnerCrosFragment();
                // Ganti_Fragment_beginner(fragment);

            }
        });
        btnBWhiteCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(302);
//                fragment = new BeginnerWhiteCornersFragment();
//                Ganti_Fragment_beginner(fragment);
            }
        });
        btnBSecondLayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(303);
//                fragment = new BeginnerSecondLayersFragment();
//                Ganti_Fragment_beginner(fragment);
            }
        });
        btnBOll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(304);
//                fragment = new BeginnerOll1Fragment();
//                Ganti_Fragment_beginner(fragment);
            }
        });
        btnBOll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(305);
//                fragment = new BeginnerOll2Fragment();
//                Ganti_Fragment_beginner(fragment);
            }
        });
        btnBPll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginnerInterfaces.moveFragment(306);
//                fragment = new BeginnerPllFragment();
//                Ganti_Fragment_beginner(fragment);
            }
        });
        return v;
    }

//    private void Ganti_Fragment_beginner(Fragment fragment) {
//
//        getParentFragmentManager()
//                .beginTransaction()
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                .replace(R.id.fragmentPlaceBeginner, fragment)
//                .commit();
//    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            beginnerInterfaces = (BeginnerInterfaces) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }
}