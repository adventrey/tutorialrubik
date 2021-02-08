package com.btxappreborn.tutorialforrubikcube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AdvancedActivity extends AppCompatActivity implements AdvancedInterfaces{
    boolean readyIntads = false;
    private static  String AD_B_ID,AD_I_ID;
    private FrameLayout adContainerViewA;
    private AdView adView;
    InterstitialAd interstitialAdA;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        ToolbarAdvanced();

        AD_B_ID = getResources().getString(R.string.ad_banner_id);
        AD_I_ID = getResources().getString(R.string.ad_intersitial_id);
        adContainerViewA = findViewById(R.id.ad_view_container_a);
        interstitialAdA = new InterstitialAd(this);
        interstitialAdA.setAdUnitId(AD_I_ID);

        Ganti_Fragment(new AdvancedFragment());
        adContainerViewA.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });

    }
    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.

        if (interstitialAdA != null && interstitialAdA.isLoaded()) {
            interstitialAdA.show();
        } else {
            Ganti_Fragment(fragment);
        }


    }

    private void loadIntersitial() {
        if (readyIntads) {
            if (!interstitialAdA.isLoading() && !interstitialAdA.isLoaded()) {
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitialAdA.loadAd(adRequest);

                interstitialAdA.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        Ganti_Fragment(fragment);
                        super.onAdClosed();
                    }

                    @Override
                    public void onAdLoaded() {

                        super.onAdLoaded();
                      //  Toast.makeText(AdvancedActivity.this, "ed", Toast.LENGTH_SHORT).show();
                    }
                });
              //  Toast.makeText(this, "load", Toast.LENGTH_SHORT).show();
                readyIntads = false;
                Ganti_Fragment(fragment);
            }

        } else {
         //   Toast.makeText(this, "no load", Toast.LENGTH_SHORT).show();
            readyIntads = true;
            showInterstitial();
        }


    }
    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    private void loadBanner() {
        // Create an ad request.
        adView = new AdView(this);
        adView.setAdUnitId(AD_B_ID);
        adContainerViewA.removeAllViews();
        adContainerViewA.addView(adView);

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = adContainerViewA.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationBannerAdSizeWithWidth(this, adWidth);
    }

    private void ToolbarAdvanced() {

        Toolbar toolbar = findViewById(R.id.toolbarx);
        toolbar.setTitle(getString(R.string.app_name)+ " / Advanced");
        toolbar.setBackgroundColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    private void Ganti_Fragment(Fragment fragmentA) {

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragmentPlaceAdvanced, fragmentA)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_notation:
                startActivity(new Intent(this, NotationActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentPlaceAdvanced);
        if (fragment instanceof AdvancedFragment) {
            super.onBackPressed();
        } else {
            Ganti_Fragment(new AdvancedFragment());
        }


    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(

                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void moveFragment(int x) {
        if (x == 401) {
            fragment = new BeginnerCrosFragment();
        } else if (x == 402) {
            fragment = new AdvancedF2lFragment();
        } else if (x == 403) {
            fragment = new AdvancedOllFragment();
        } else if (x == 404) {
            fragment = new AdvancedPllFragment();
        }
        loadIntersitial();
    }
}