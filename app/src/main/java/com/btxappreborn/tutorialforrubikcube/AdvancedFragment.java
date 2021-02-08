package com.btxappreborn.tutorialforrubikcube;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdvancedFragment extends Fragment {

    Button btnACros,btnAF2L,btnAOLL,btnAPll;
    AdvancedInterfaces advancedInterfaces;
    public AdvancedFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced, container, false);
        btnACros = view.findViewById(R.id.btnBCross);
        btnAF2L = view.findViewById(R.id.btnAF2L);
        btnAOLL = view.findViewById(R.id.btnAOLL);
        btnAPll = view.findViewById(R.id.btnAPLL);

        btnACros.setBackgroundTintList(view.getResources().getColorStateList(R.color.black));
        btnACros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancedInterfaces.moveFragment(401);
//                Ganti_Fragment_advanced(new BeginnerCrosFragment());
            }
        });
        btnAF2L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancedInterfaces.moveFragment(402);
//                Ganti_Fragment_advanced(new AdvancedF2lFragment());
            }
        });
        btnAOLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancedInterfaces.moveFragment(403);
//                Ganti_Fragment_advanced(new AdvancedOllFragment());
            }
        });
        btnAPll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancedInterfaces.moveFragment(404);
//                Ganti_Fragment_advanced(new AdvancedPllFragment());
            }
        });
        return view;
    }

    private void Ganti_Fragment_advanced(Fragment fragment) {

        getParentFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragmentPlaceAdvanced, fragment)
                .commit();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            advancedInterfaces = (AdvancedInterfaces) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }
}